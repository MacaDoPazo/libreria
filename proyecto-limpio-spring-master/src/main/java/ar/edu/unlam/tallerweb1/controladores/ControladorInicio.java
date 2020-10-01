package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorInicio {
	@Inject
	private servicioLibro servicioLibro;
	
	@RequestMapping("/pantalla-inicial")
	public ModelAndView irAlInicio() {
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		return new ModelAndView("pantallainicial",modelo);
	}
	
	@RequestMapping(path="/detalle-producto", method=RequestMethod.GET)
	
		public ModelAndView irADetalleProducto(@RequestParam(value="idLibro")Long idLibro) {
		ModelMap model = new ModelMap();

		Libro libroEncontrado = servicioLibro.consultarLibroPorId(idLibro);

		model.put("libro", libroEncontrado);
			return new ModelAndView("detalleproducto",model);
		}
	@RequestMapping("/carrito-compras")
	public ModelAndView registrarUsuario()
	{
		return new ModelAndView("carrito");
	}
	

}
