package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioVenta;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorPedido {

	@Inject
	
	private ServicioPedido servicioPedido;
	
	@Inject
	private servicioLibro servicioLibro;

	@Inject
	private ServicioCantLibros servicioCantLibros;

	@Inject
	private ServicioVenta servicioVenta;
	
	
	@RequestMapping("/agregar-al-carrito")
	public ModelAndView agregarAlCarrito (@RequestParam("idLibro") Long idLibro,
			@RequestParam("canitdad") Long cantidad,
			@RequestParam("precio") Long precio,@RequestParam("idCliente") Long idCliente)
	{
		Pedido pedidoArmando = servicioPedido.buscarPedidoArmando(idCliente,"armando");
		
		if(pedidoArmando == null)
		{
			Pedido pedido = new Pedido();
			pedido.setEstado("armando");
			pedido.setCliente(idCliente);
			Long idPedido =servicioPedido.guardarPedido(pedido);
			Pedido pedidoCliente = servicioPedido.consultarPedidoPorId(idPedido);
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibro);
			Long total = cantidad*precio;//servicioPedido
			CantidadLibros cantidadLibros = new CantidadLibros();
			cantidadLibros.setLibro(libroPedir);
			cantidadLibros.setPedido(pedidoCliente);
			cantidadLibros.setCantidad(cantidad);
			cantidadLibros.setPrecioTotal(cantidadLibros.calcularPrecioTotal());
			Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			
			
		}
		else
		{
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibro);
			CantidadLibros libroEncontrado=servicioCantLibros.buscarLibroEnPedidoArmado(pedidoArmando,libroPedir);
			if(libroEncontrado != null)
			{	
			Long total = cantidad*precio;
			libroEncontrado.setCantidad(cantidad+libroEncontrado.getCantidad());
			libroEncontrado.setPrecioTotal(libroEncontrado.calcularPrecioTotal());
			 servicioCantLibros.actualizarCantidadLibros(libroEncontrado);
			}
			else
			{
			//	Libro libroPedi = servicioLibro.consultarLibroPorId(idLibro);
			// total = cantidad*precio;
				CantidadLibros cantidadLibros = new CantidadLibros();
				cantidadLibros.setLibro(libroPedir);
				cantidadLibros.setPedido(pedidoArmando);
				cantidadLibros.setCantidad(cantidad);
				cantidadLibros.setPrecioTotal(cantidadLibros.calcularPrecioTotal());
				Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			}
			
		}
		
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		return new ModelAndView("pantallainicial",modelo);
	}

	@RequestMapping("/listar-pedidos-clientes")
	public ModelAndView listarPedidosClientes()
	{
		List<Venta> listaPedidos = servicioVenta.listarPedidosFacturados();
		ModelMap modelo = new ModelMap();
		modelo.put("listaPedidosCliente",listaPedidos);
		return new ModelAndView("listaPedidosClientes",modelo);
	}
	
	@RequestMapping(path="/cambiar-estado",method= RequestMethod.POST)
	public ModelAndView cambiarEstado(@RequestParam("idPedido")Long idPedido,
			@RequestParam("estado") String estado,
			@RequestParam("idVenta")Long idVenta)
	{
		servicioPedido.actualizarEstadoDelPedido(idPedido, estado);
		List<CantidadLibros> librosComprados = servicioCantLibros.listarLibrosComprados(idPedido);
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		Venta venta = servicioVenta.consultarVentaPorId(idVenta);
		ModelMap modelo = new ModelMap();
		
		modelo.put("librosComprados",librosComprados);
		modelo.put("venta",venta);
		modelo.put("pedido",pedido);
		return new ModelAndView("detalleVenta",modelo);
	}
}
