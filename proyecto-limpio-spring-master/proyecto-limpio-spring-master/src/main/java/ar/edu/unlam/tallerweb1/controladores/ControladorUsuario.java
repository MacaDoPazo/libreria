package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {
	@Inject
	private ServicioUsuario servicioUsuario;
	
	
	@RequestMapping("/registroUsuario")
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("registroUsuario", modelo);
	}
	
	@RequestMapping("/mostrarUsuarioRegistrado")
	public ModelAndView usuarioRegistrado(
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("sexo") String sexo,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("passwordRepetido") String passwordRepetido
			) {
		
		Usuario usuario = new Usuario();
			
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setSexo(sexo);
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.setRol(2); // Por defecto se crean usuarios de tipo cliente (2)
			Long id= servicioUsuario.guardarUsuario(usuario);
		
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido);
		modelo.put("sexo", sexo);
		modelo.put("email", email);

	
		return new ModelAndView("mostrarUsuarioRegistrado", modelo);
		
	}
	
}
