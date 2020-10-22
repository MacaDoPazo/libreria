package ar.edu.unlam.tallerweb1.controladores;

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
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioStock;
import ar.edu.unlam.tallerweb1.servicios.ServicioVenta;

@Controller
public class ControladorVenta {

	@Inject
	private ServicioVenta servicioVenta;
	
	@Inject
	private ServicioPedido servicioPedido;
	
	@Inject
	private ServicioCantLibros servicioCantidadLibros;
	
	@Inject
	private ServicioStock servicioStock;
	
	@RequestMapping(path= "/guardar-venta", method= RequestMethod.POST)
	public ModelAndView guardarVenta(
			@RequestParam("idCliente") Long idCliente,
			@RequestParam("montoTotal") Long montoTotal,
			@RequestParam("localidadEnvio") Integer localidadEnvio,
			@RequestParam("nombreTitularTarjeta") String nombreTitularTarjeta,
			@RequestParam("apellidoTitularTarjeta") String apellidoTitularTarjeta,
			@RequestParam("numeroTarjeta") Long numeroTarjeta,
			@RequestParam("fechaCaducidadTarjeta") String fechaCaducidadTarjeta,
			@RequestParam("codigoSeguridadTarjeta") Integer codigoSeguridadTarjeta			
			) {
		
		Pedido pedido = servicioPedido.buscarPedidoArmando(idCliente, "armando");

		
		Venta venta = new Venta();
			venta.setIdCliente(idCliente);
			venta.setMontoTotal(montoTotal);
			venta.setLocalidadEnvio(localidadEnvio);
			venta.setNombreTitularTarjeta(nombreTitularTarjeta);
			venta.setApellidoTitularTarjeta(apellidoTitularTarjeta);
			venta.setNumeroTarjeta(numeroTarjeta);
			venta.setFechaCaducidadTarjeta(fechaCaducidadTarjeta);
			//Agregar fecha de venta
			venta.setCodigoSeguridadTarjeta(codigoSeguridadTarjeta);
			venta.setPedido(pedido);
			java.sql.Date fechaVenta = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
			venta.setFechaDeVenta(fechaVenta);
			servicioVenta.guardarVenta(venta);
			
			List <CantidadLibros> listaLibrosVendidos= servicioCantidadLibros.listarLibrosPedidoDelCliente(idCliente, "armando");
			servicioStock.descontarStock(listaLibrosVendidos);
			
			pedido.setEstado("facturado");
			servicioPedido.actualizarEstadoDelPedido(pedido.getId(), pedido.getEstado());

		
	ModelMap modelo = new ModelMap();
		
		modelo.put("idCliente", idCliente);
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
	
	
}

