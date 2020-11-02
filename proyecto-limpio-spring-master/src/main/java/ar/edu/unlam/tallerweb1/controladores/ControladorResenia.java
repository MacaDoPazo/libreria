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
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorResenia {
	@Inject
	private ServicioResenia servicioResenia;
	@Inject
	private ServicioCantLibros servicioCantLibros;
	@Inject
	private ServicioPedido servicioPedido;
	@Inject
	private servicioLibro servicioLibro;
	@Inject 
	private ServicioUsuario servicioUsuario;
	@RequestMapping(path="/registrar-resenia", method= RequestMethod.POST)
	public ModelAndView IrAlRegistroDelaResenia(@RequestParam("idPedido") Long idPedido){		
		List<CantidadLibros> librosComprados = servicioCantLibros.listarLibrosComprados(idPedido);
		
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		ModelMap modelo = new ModelMap();
		modelo.put("librosComprados",librosComprados);
		modelo.put("pedido",pedido);
		return new ModelAndView("registrarResenia",modelo);		
	}
	
	@RequestMapping(path="/comentar-resenia", method= RequestMethod.POST)
	public ModelAndView comentarResenia(@RequestParam("idCliente") Long idCliente,
			@RequestParam("idLibro") Long idLibro,
			@RequestParam("idPedido") Long idPedido){
		Libro libro = servicioLibro.consultarLibroPorId(idLibro);
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		Usuario usuario = servicioUsuario.consultarUsuarioPorId(idCliente);
		Resenia_Libros_Cliente reseniaLibroCliente = servicioResenia.consultarReseniaLibroCliente(libro,usuario);
		ModelMap modelo = new ModelMap();
		while(reseniaLibroCliente != null)
		{
			List<CantidadLibros> librosComprados = servicioCantLibros.listarLibrosComprados(idPedido);
			modelo.put("error","ya hizo la reseña de este libro");
			modelo.put("librosComprados",librosComprados);
			modelo.put("pedido",pedido);
			return new ModelAndView("registrarResenia",modelo);
		}
		
		modelo.put("libro",libro);
		modelo.put("pedido",pedido);
		return new ModelAndView("comentarResenia",modelo);			
	}
	
	@RequestMapping(path="/guardar-resenia", method= RequestMethod.POST)
	public ModelAndView guardarResenia(@RequestParam("idCliente") Long idCliente,
			@RequestParam("idLibro") Long idLibro,
			@RequestParam("comentario") String comentario,
			@RequestParam("puntuacion") Integer puntuacion,
			@RequestParam("idPedido") Long idPedido){
		Libro libro = servicioLibro.consultarLibroPorId(idLibro);
		Usuario usuario = servicioUsuario.consultarUsuarioPorId(idCliente);
		
		Resenia resenia = new Resenia();
		resenia.setCliente(usuario);
		resenia.setLibro(libro);
		resenia.setComentario(comentario);
		resenia.setPuntuacion(puntuacion);
		servicioResenia.guardarResenia(resenia);
		Resenia_Libros_Cliente reseniaLibroCliente = new Resenia_Libros_Cliente();
		reseniaLibroCliente.setResenia(resenia);
		reseniaLibroCliente.setLibro(libro);
		reseniaLibroCliente.setUsuario(usuario);
		servicioResenia.guardarReseniaLibrosCliente(reseniaLibroCliente);
		List<CantidadLibros> librosComprados = servicioCantLibros.listarLibrosComprados(idPedido);	
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		ModelMap modelo = new ModelMap();
		while(reseniaLibroCliente != null)
		{
		
			modelo.put("error","ya hizo la reseña de este libro");
			modelo.put("librosComprados",librosComprados);
			modelo.put("pedido",pedido);
			return new ModelAndView("registrarResenia",modelo);
		}
		modelo.put("librosComprados",librosComprados);
		modelo.put("pedido",pedido);
		
		return new ModelAndView("registrarResenia",modelo);			
	}

}
