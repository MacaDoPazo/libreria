package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioStock;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVenta;

@Controller
public class ControladorVenta {
	
	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioVenta servicioVenta;
	
	@Inject
	private ServicioPedido servicioPedido;
	
	@Inject
	private ServicioCantLibros servicioCantidadLibros;
	
	@Inject
	private ServicioStock servicioStock;
	@Inject
	private ServicioLocalidad servicioLocalidad;
	@RequestMapping(path= "/guardar-venta", method= RequestMethod.POST)
	public ModelAndView guardarVenta(
			HttpServletRequest request,
			@RequestParam("montoTotal") Long montoTotal,
			@RequestParam("localidadEnvio") Integer localidadEnvio,
			@RequestParam("nombreTitularTarjeta") String nombreTitularTarjeta,
			@RequestParam("apellidoTitularTarjeta") String apellidoTitularTarjeta,
			@RequestParam("numeroTarjeta") Long numeroTarjeta,
			@RequestParam("fechaCaducidadTarjeta") String fechaCaducidadTarjeta,
			@RequestParam("codigoSeguridadTarjeta") Integer codigoSeguridadTarjeta,
			@RequestParam("fechaEntrega") Date fechaEntrega
			) {
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		Pedido pedido = servicioPedido.buscarPedidoArmando(idUsuario, "armando");
		Localidad localidad = servicioLocalidad.consultarLocalidadPorCP(localidadEnvio);
		
		Venta venta = new Venta();
			venta.setIdCliente(idUsuario);
			venta.setMontoTotal(montoTotal);
			venta.setLocalidadEnvio(localidadEnvio);
			venta.setNombreTitularTarjeta(nombreTitularTarjeta);
			venta.setApellidoTitularTarjeta(apellidoTitularTarjeta);
			venta.setNumeroTarjeta(numeroTarjeta);
			venta.setFechaCaducidadTarjeta(fechaCaducidadTarjeta);
			//Agregar fecha de venta
			venta.setCodigoSeguridadTarjeta(codigoSeguridadTarjeta);
			venta.setPedido(pedido);
			pedido.setVenta(venta);
			pedido.setLocalidad(localidad);
			pedido.setFechaEntrega(fechaEntrega);
			java.sql.Date fechaVenta = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
			venta.setFechaDeVenta(fechaVenta);
			servicioVenta.guardarVenta(venta);
			servicioPedido.actualizarPedido(pedido);
			List <CantidadLibros> listaLibrosVendidos= servicioCantidadLibros.listarLibrosPedidoDelCliente(idUsuario, "armando");
			servicioStock.descontarStock(listaLibrosVendidos);
			
			pedido.setEstado("facturado");
			servicioPedido.actualizarEstadoDelPedido(pedido.getId(), pedido.getEstado());

		
	ModelMap modelo = new ModelMap();
		
		modelo.put("idCliente", idUsuario);
		modelo.put("montoTotal", montoTotal);
		modelo.put("localidadEnvio", localidadEnvio);
		modelo.put("nombreTitularTarjeta", nombreTitularTarjeta);
		modelo.put("apellidoTitularTarjeta", apellidoTitularTarjeta);
		modelo.put("numeroTarjeta", numeroTarjeta);
		modelo.put("fechaCaducidadTarjeta", fechaCaducidadTarjeta);
		modelo.put("codigoSeguridadTarjeta", codigoSeguridadTarjeta);
		modelo.put("listaLibrosVendidos", listaLibrosVendidos);
		
		return new ModelAndView ("resultadoVenta", modelo);
		
	}
	
	@RequestMapping(path="/detalle-venta", method= RequestMethod.GET)
	public ModelAndView detalleVenta (@RequestParam("pedidoId")Long pedidoId)
	{
		List<CantidadLibros> librosComprados = servicioCantidadLibros.listarLibrosComprados(pedidoId);
		Pedido pedido = servicioPedido.consultarPedidoPorId(pedidoId);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("librosComprados",librosComprados);
		
		modelo.put("pedido",pedido);
		return new ModelAndView("detalleVenta",modelo);
	}
	
	@RequestMapping(path="/listaVentasAlCliente", method= RequestMethod.GET)
	public ModelAndView listarVentasAlCliente(
			HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		List <Venta> listadoVentasRealizadasAlCliente = servicioVenta.listarVentasAlCliente(idUsuario);
		List <Venta> listaDeVentasSinEntregarEnTiempo = servicioVenta.listarVentasSinEntregarATiempo(listadoVentasRealizadasAlCliente);
		ModelMap modelo = new ModelMap();
		if(listaDeVentasSinEntregarEnTiempo == null)
		{
			
			modelo.put("idCliente", idUsuario);
			modelo.put("listadoVentasRealizadasAlCliente", listadoVentasRealizadasAlCliente);
			return new ModelAndView ("ventasAlCliente", modelo);	
		}
		else
		{
			modelo.put("idCliente", idUsuario);
			modelo.put("listadoVentasRealizadasAlCliente", listadoVentasRealizadasAlCliente);
			modelo.put("EntregasAtrasadas",listaDeVentasSinEntregarEnTiempo);
			return new ModelAndView ("ventasAlCliente", modelo);
		}
		
	}
	
	
}

