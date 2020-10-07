package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {
	@Inject
	private ServicioUsuario servicioUsuario;

	public ModelAndView cargarUsuario(
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("sexo") String sexo,
			@RequestParam("fechaNacimiento") Date fechaNacimiento, //tipo date
			@RequestParam("mail") String mail,
			@RequestParam("password") String password,
			@RequestParam("passwordRepetido") String passwordRepetido
			) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setSexo(sexo);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setEmail(mail);
		usuario.setPassword(password);
		Long idUsuario = servicioUsuario.guardarUsuario(usuario);
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido);
		modelo.put("sexo", sexo);
		modelo.put("fechaNacimiento", fechaNacimiento);
		modelo.put("mail", mail);
		modelo.put("password", password);
		modelo.put("passwordRepetido", passwordRepetido);
	
		return new ModelAndView("mostrarUsuarioRegistrado", modelo);
		
	}
	
	
}
