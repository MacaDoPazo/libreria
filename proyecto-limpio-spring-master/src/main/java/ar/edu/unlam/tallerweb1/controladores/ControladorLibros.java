package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorLibros {

	@Inject
	private servicioLibro servicioLibro;
	@RequestMapping("/mostrarCatalogoLibros")
	public ModelAndView mostrarCatalogoLibros() {
		return new ModelAndView("catalogolibros");
	}
	
	@RequestMapping(path="/buscarLibroPorId",method = RequestMethod.GET)
	public ModelAndView buscarLibroPorId(@RequestParam(value="id")Long id)
	{
		ModelMap model = new ModelMap();

		Libro libroEncontrado = servicioLibro.consultarLibroPorId(id);

		model.put("libro", libroEncontrado);
		return new ModelAndView("catalogolibros",model);
	}
	@RequestMapping("/guardarLibro")
	public ModelAndView guardarLibro(@RequestParam(value="nombre")String nombre/*,@RequestParam(value="nombreAutor")String nombreautor,
			@RequestParam(value="apellidoAutor")String apellidoAutor*/)
	{
		Libro libro = new Libro();
		libro.setNombre(nombre);
		/*libro.getAutor().setNombre(nombreautor);
		libro.getAutor().setApellido(apellidoAutor);*/
		Long idLibro = servicioLibro.guardarlibro(libro);
		ModelMap modelo = new ModelMap();
		modelo.put("id",idLibro);
		modelo.put("nombre",nombre);
		/*modelo.put("nombreAutor",nombreautor);
		modelo.put("apellidoAutor",apellidoAutor);*/
		return new ModelAndView("catalogolibros",modelo);
	}
	
    @RequestMapping("/listarLibros")
	public ModelAndView listarLibros() {
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("listalibros",listalibros);
		return new ModelAndView ("catalogolibros",modelo);
	}
}
