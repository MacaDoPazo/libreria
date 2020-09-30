package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;

@Controller
public class ControladorAutor {

	@Inject
	private ServicioAutor servicioAutor;

	@RequestMapping(path="/registroDeAutor")
	
	public ModelAndView irAregistrarAutor()
	{
			return new ModelAndView("registrarAutor");
	}
	
	@RequestMapping("/registrar-autor")
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
}
