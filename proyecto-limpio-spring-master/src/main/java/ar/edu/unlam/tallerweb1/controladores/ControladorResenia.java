package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView IrAlRegistroDelaResenia(@RequestParam("idPedido") Long idPedido, HttpServletRequest request){		
		
		Long usuario = (Long) request.getSession().getAttribute("usuario_id");
		
		List<CantidadLibros> librosComprados = servicioCantLibros.listarLibrosComprados(idPedido);
		List<Resenia_Libros_Cliente> listaReseniaLibroCliente = servicioResenia.listarReseniasDelCliente(usuario);
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		ModelMap modelo = new ModelMap();
		modelo.put("librosComprados",librosComprados);
		modelo.put("pedido",pedido);
		modelo.put("listaResenia",listaReseniaLibroCliente);
		return new ModelAndView("registrarResenia",modelo);		
	}
	
	@RequestMapping(path="/comentar-resenia", method= RequestMethod.POST)
	public ModelAndView comentarResenia(HttpServletRequest request,
			@RequestParam("idLibro") Long idLibro,
			@RequestParam("idPedido") Long idPedido){
		Libro libro = servicioLibro.consultarLibroPorId(idLibro);
		Pedido pedido = servicioPedido.consultarPedidoPorId(idPedido);
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		Usuario usuario = servicioUsuario.consultarUsuarioPorId(idUsuario);
		List<Resenia_Libros_Cliente> listaReseniaLibroCliente = servicioResenia.listarReseniasDelCliente(idUsuario);
		Resenia_Libros_Cliente reseniaLibroCliente = servicioResenia.consultarReseniaLibroCliente(libro,usuario);
		ModelMap modelo = new ModelMap();
		
		modelo.put("listaResenia",listaReseniaLibroCliente);
		modelo.put("libro",libro);
		modelo.put("pedido",pedido);
		return new ModelAndView("comentarResenia",modelo);			
	}
	
	@RequestMapping(path="/guardar-resenia", method= RequestMethod.POST)
	public ModelAndView guardarResenia(HttpServletRequest request,
			@RequestParam("idLibro") Long idLibro,
			@RequestParam("comentario") String comentario,
			@RequestParam("puntuacion") Integer puntuacion,
			@RequestParam("idPedido") Long idPedido){
		Libro libro = servicioLibro.consultarLibroPorId(idLibro);
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		Usuario usuario = servicioUsuario.consultarUsuarioPorId(idUsuario);
		
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
		
		
		return new ModelAndView("redirect:/pantalla-inicial");		
	}
	
	@RequestMapping("/listar-resenias-cliente")
	
	public ModelAndView listarReseniasDelCliente (HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_id") != null)
		{
			List<Resenia_Libros_Cliente> listaResenia =servicioResenia.listarReseniasDelCliente((Long) request.getSession().getAttribute("usuario_id"));
			ModelMap model = new ModelMap();
			model.put("listaResenia",listaResenia);
			return new ModelAndView("reseniasCliente",model);
		}
		else
		{
			return new ModelAndView("redirect:/pantalla-inicial");	
		}
		
	}

}
