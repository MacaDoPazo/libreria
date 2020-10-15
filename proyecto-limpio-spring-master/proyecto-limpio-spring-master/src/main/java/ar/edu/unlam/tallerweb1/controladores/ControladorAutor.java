package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;

@Controller
public class ControladorAutor {

	@Inject
	private ServicioAutor servicioAutor;

	@RequestMapping(path="/registrar-autor")
	
	public ModelAndView irAregistrarAutor()
	{
			return new ModelAndView("registrarAutor");
	}
	
	@RequestMapping("/guardar-autor")
	public ModelAndView registrarAutor(@RequestParam(value="nombre")String nombre,@RequestParam(value="apellido")String apellido,@RequestParam(value="sexo")String sexo)
	{
		Autor autor = new Autor();
		autor.setNombre(nombre);
		autor.setApellido(apellido);
		autor.setSexo(sexo);
		Long id=servicioAutor.guardarAutor(autor);
		ModelMap modelo = new ModelMap();
		modelo.put("nombre",nombre);
		modelo.put("apellido",apellido);
		modelo.put("sexo",sexo);
		
		return new ModelAndView("registrarAutor",modelo);
		
	}
	
	@RequestMapping("/borrar-autor")
	public ModelAndView borrarAutor(@RequestParam(value="idAutor")Long idAutor)
	{
		servicioAutor.borrarAutor(idAutor);
		return new ModelAndView("registrarAutor");
	}
	@RequestMapping("/catalogo-autores")
	public ModelAndView listarLibros() {
		List<Autor> listaAutores = servicioAutor.listarAutores();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listaAutores);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("catalogoAutores");
		return mivista;
	}
}
