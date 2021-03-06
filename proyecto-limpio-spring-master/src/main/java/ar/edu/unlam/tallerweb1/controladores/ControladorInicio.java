package ar.edu.unlam.tallerweb1.controladores;

import java.util.Iterator;
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
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioGenero;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
import ar.edu.unlam.tallerweb1.servicios.ServicioVenta;
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
	@Inject
	private ServicioResenia servicioResenia;
	@Inject
	private ServicioVenta servicioVenta;
	@RequestMapping(path="/pantalla-inicial"/*, method = RequestMethod.POST*/)//servicio libro promedio
	public ModelAndView irAlInicio(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		
	if(idUsuario != null)
		{
			List<Libro> listalibros = servicioLibro.listarLibros();
			List<Integer> listaPromedio = servicioLibro.listarPromedioDeReseniaPorCadaLibro(listalibros);
			Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
			ModelMap modelo = new ModelMap();
			try {
				List<Libro> listarLibrosGeneroMayorPuntaje = servicioLibro.listarLibrosGeneroMayorPuntaje(idUsuario);
				List<Integer> listaPromedioMayorPuntaje = servicioLibro.listarPromedioDeReseniaPorCadaLibro(listarLibrosGeneroMayorPuntaje);
				Libro libro = listarLibrosGeneroMayorPuntaje.get(0);
				modelo.put("alertaFacturados",alertaFacturados);
				modelo.put("idGeneroSugerido",libro.getGenero().getId());
				modelo.put("generoSugerido",libro.getGenero().getNombre());
				modelo.put("lista",listalibros);
				modelo.put("listaGenero",listarLibrosGeneroMayorPuntaje);
				modelo.put("listaPromedio",listaPromedio);
				modelo.put("promedioMayorPuntaje",listaPromedioMayorPuntaje);
			}catch (Exception e) {
				String error= e.getMessage();
				Libro libro = listalibros.get(0);
				
				modelo.put("alertaFacturados",alertaFacturados);
				modelo.put("error",error);
				modelo.put("lista",listalibros);
				
			}
			List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idUsuario,"armando");
			modelo.put("cantidadLibrosPedidos",librosPedidos.size());
			modelo.put("listaPromedio",listaPromedio);
			modelo.put("alertaFacturados",alertaFacturados);
			return new ModelAndView("pantallainicial",modelo);
						
		}
		
			List<Libro> listalibros = servicioLibro.listarLibros();
			List<Integer> listaPromedio = servicioLibro.listarPromedioDeReseniaPorCadaLibro(listalibros);
			List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idUsuario,"armando");
			Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
			ModelMap modelo = new ModelMap();
			modelo.put("lista",listalibros);
			modelo.put("listaPromedio",listaPromedio);
			modelo.put("cantidadLibrosPedidos",librosPedidos.size());
			modelo.put("alertaFacturados",alertaFacturados);
			return new ModelAndView("pantallainicial",modelo);
		
		
		
	}
	
	@RequestMapping(path="/detalle-producto", method=RequestMethod.GET)//servicio libro promedio
	
		public ModelAndView irADetalleProducto(@RequestParam(value="idLibro")Long idLibro,
				@RequestParam("promedio") Integer promedio) {
		ModelMap model = new ModelMap();

		Libro libroEncontrado = servicioLibro.consultarLibroPorId(idLibro);
		
		List<Resenia> reseniasDelLibro = servicioResenia.listarReseniasDelLibro(idLibro); 
		List<Libro> librosRelacionados = servicioLibro.listarLibrosConMismoGeneroOMismoAutor(idLibro);
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		model.put("libro", libroEncontrado);
		model.put("promedio", promedio);
		model.put("listaReseniasDelLibro", reseniasDelLibro);
		model.put("listaLibrosRelacionados", librosRelacionados);
		model.put("alertaFacturados",alertaFacturados);
			return new ModelAndView("detalleproducto",model);
		}
	@RequestMapping(path="/ver-pedido")
	
		public ModelAndView verPedido(HttpServletRequest request)
		{
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		
		while (idUsuario == null)
		{
			return new ModelAndView("redirect:/login");
		}
		Pedido pedido =servicioPedido.buscarPedidoArmando(idUsuario, "armando");
		if(pedido != null)
		{
			List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idUsuario,"armando");
			Long subtotal = servicioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
			Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
			ModelMap modelo = new ModelMap();
			modelo.put("subtotal",subtotal);
			modelo.put("librosPedidos",librosPedidos);
			modelo.put("cantidadLibrosPedidos",librosPedidos.size());
			modelo.put("alertaFacturados",alertaFacturados);
				return new ModelAndView("carrito", modelo);
		}
		else
		{
			Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
			ModelMap modelo = new ModelMap();
			modelo.put("alertaFacturados",alertaFacturados);
			modelo.put("mensaje","no cargo ningun libro al carrito");
			modelo.put("alertaFacturados",alertaFacturados);
			return new ModelAndView("carrito",modelo);
		}
		}
	
	@RequestMapping("/carrito-compras")
		public ModelAndView irAlCarrito(
			@RequestParam(value="cantidad",required = false)Long cantidad ,
			@RequestParam(value="idLibroSolicitado", required = false)Long idLibroSolicitado,
			HttpServletRequest request) {		
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		Pedido pedidoArmando = servicioPedido.buscarPedidoArmando(idUsuario,"armando");
		
		if(pedidoArmando == null)
		{
			Pedido pedido = new Pedido();
			pedido.setEstado("armando");
			pedido.setCliente(idUsuario);
			Long idPedido =servicioPedido.guardarPedido(pedido);
			Pedido pedidoCliente = servicioPedido.consultarPedidoPorId(idPedido);
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibroSolicitado);
			Long total = cantidad*libroPedir.getPrecio();
			CantidadLibros cantidadLibros = new CantidadLibros();
			cantidadLibros.setLibro(libroPedir);
			cantidadLibros.setPedido(pedidoCliente);
			cantidadLibros.setCantidad(cantidad);
			cantidadLibros.setPrecioTotal(total);
			Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			
			
		}
		else
		{
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibroSolicitado);
			CantidadLibros libroEncontrado=servicioCantLibros.buscarLibroEnPedidoArmado(pedidoArmando,libroPedir);
			if(libroEncontrado != null)
			{	
			Long total = cantidad*libroPedir.getPrecio();
			libroEncontrado.setCantidad(cantidad+libroEncontrado.getCantidad());
			libroEncontrado.setPrecioTotal(total+libroEncontrado.calcularPrecioTotal());
			 servicioCantLibros.actualizarCantidadLibros(libroEncontrado);
			
			}
			else
			{
				Libro libroPedi = servicioLibro.consultarLibroPorId(idLibroSolicitado);
				Long total = cantidad*libroPedir.getPrecio();
				CantidadLibros cantidadLibros = new CantidadLibros();
				cantidadLibros.setLibro(libroPedir);
				cantidadLibros.setPedido(pedidoArmando);
				cantidadLibros.setCantidad(cantidad);
				cantidadLibros.setPrecioTotal(total);
				Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
				
			}
			
		}
		
		List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idUsuario,"armando");
		Long subtotal = servicioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		ModelMap modelo = new ModelMap();
		modelo.put("subtotal",subtotal);
		modelo.put("librosPedidos",librosPedidos);
		modelo.put("cantidadLibrosPedidos",librosPedidos.size());
		modelo.put("alertaFacturados",alertaFacturados);
		return new ModelAndView("carrito", modelo);

	}

}
