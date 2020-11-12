package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioGenero;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorInicio {
	@Inject
	private servicioLibro servicioLibro;
	@Inject
	private ServicioCantLibros servicioCantLibros;
	@Inject
	private ServicioPedido servicioPedido;
	@Inject ServicioGenero servicioGenero;
	
	@RequestMapping(path="/pantalla-inicial"/*, method = RequestMethod.POST*/)
	public ModelAndView irAlInicio(HttpServletRequest request) {
		Long id = (long) 1;
		List<Libro> listalibros = servicioLibro.listarLibros();
		List<Libro> listarLibrosGeneroMayorPuntaje = servicioLibro.listarLibrosGeneroMayorPuntaje(id);
		ModelMap modelo = new ModelMap();
	//	Libro libro = listarLibrosGeneroMayorPuntaje.get(1);
	//	modelo.put("generoSugerido",libro.getGenero());
		modelo.put("lista",listalibros);
		modelo.put("listaGenero",listarLibrosGeneroMayorPuntaje);
		return new ModelAndView("pantallainicial",modelo);
	}
	
	@RequestMapping(path="/detalle-producto", method=RequestMethod.GET)
	
		public ModelAndView irADetalleProducto(@RequestParam(value="idLibro")Long idLibro) {
		ModelMap model = new ModelMap();

		Libro libroEncontrado = servicioLibro.consultarLibroPorId(idLibro);

		model.put("libro", libroEncontrado);
			return new ModelAndView("detalleproducto",model);
		}
	@RequestMapping(path="/ver-pedido")
	
		public ModelAndView verPedido(@RequestParam(value="idCliente", required = true)Long idCliente)
		{
		Pedido pedido =servicioPedido.buscarPedidoArmando(idCliente, "armando");
		if(pedido != null)
		{
			List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idCliente,"armando");
			Long subtotal = servicioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
			ModelMap modelo = new ModelMap();
			modelo.put("subtotal",subtotal);
			modelo.put("librosPedidos",librosPedidos);
				return new ModelAndView("carrito", modelo);
		}
		else
		{
			ModelMap modelo = new ModelMap();
			modelo.put("mensaje","no cargo ningun libro al carrito");
			return new ModelAndView("carrito",modelo);
		}
		}
	
	@RequestMapping("/carrito-compras")
		public ModelAndView irAlCarrito(
			@RequestParam(value="cantidad",required = false)Long cantidad ,
			@RequestParam(value="idLibroSolicitado", required = false)Long idLibroSolicitado,
			@RequestParam(value="idCliente", required = true)Long idCliente) {		
		Pedido pedidoArmando = servicioPedido.buscarPedidoArmando(idCliente,"armando");
		
		if(pedidoArmando == null)
		{
			Pedido pedido = new Pedido();
			pedido.setEstado("armando");
			pedido.setCliente(idCliente);
			Long idPedido =servicioPedido.guardarPedido(pedido);
			Pedido pedidoCliente = servicioPedido.consultarPedidoPorId(idPedido);
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibroSolicitado);
		//	Long total = cantidad*libroPedir.getPrecio();
			CantidadLibros cantidadLibros = new CantidadLibros();
			cantidadLibros.setLibro(libroPedir);
			cantidadLibros.setPedido(pedidoCliente);
			cantidadLibros.setCantidad(cantidad);
	//		cantidadLibros.setPrecioTotal(total);
			Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			
			
		}
		else
		{
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibroSolicitado);
			CantidadLibros libroEncontrado=servicioCantLibros.buscarLibroEnPedidoArmado(pedidoArmando,libroPedir);
			if(libroEncontrado != null)
			{	
		//	Long total = cantidad*libroPedir.getPrecio();
			libroEncontrado.setCantidad(cantidad+libroEncontrado.getCantidad());
		//	libroEncontrado.setPrecioTotal(total+libroEncontrado.calcularPrecioTotal());
			 servicioCantLibros.actualizarCantidadLibros(libroEncontrado);
			
			}
			else
			{
			//	Libro libroPedi = servicioLibro.consultarLibroPorId(idLibroSolicitado);
			//	Long total = cantidad*libroPedir.getPrecio();
				CantidadLibros cantidadLibros = new CantidadLibros();
				cantidadLibros.setLibro(libroPedir);
				cantidadLibros.setPedido(pedidoArmando);
				cantidadLibros.setCantidad(cantidad);
			//	cantidadLibros.setPrecioTotal(total);
				Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
				
			}
			
		}
		
		List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idCliente,"armando");
		Long subtotal = servicioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
		ModelMap modelo = new ModelMap();
		modelo.put("subtotal",subtotal);
		modelo.put("librosPedidos",librosPedidos);
			return new ModelAndView("carrito", modelo);

	}

}
