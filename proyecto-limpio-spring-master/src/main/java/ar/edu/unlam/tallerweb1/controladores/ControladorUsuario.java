package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public ModelAndView cargarUsuario(
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("sexo") char sexo,
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
		Date today = Calendar.getInstance().getTime();
		usuario.setFecha_ultimo_login(today);
		Long idUsuario = servicioUsuario.guardarUsuario(usuario);
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido);
		modelo.put("sexo", sexo);
		modelo.put("email", email);
		modelo.put("password", password);
		modelo.put("passwordRepetido", passwordRepetido);
	
		return new ModelAndView("mostrarUsuarioRegistrado", modelo);
		
	}
	
	@RequestMapping("/usuarios_no_frecuentes")
	public ModelAndView consultarUsuariosNoFrecuentes() {

		ModelMap modelo = new ModelMap();
		
		ArrayList<Usuario> lista=servicioUsuario.consultarUsuariosNoFrecuentes();
		modelo.put("lista_usuarios", lista);
		return new ModelAndView("listaUsuariosNoFrecuentes", modelo);
	}
	
	@RequestMapping("/enviar_recordatorios")
	public ModelAndView enviarRecordatoriosMasivo() {

		ModelMap modelo = new ModelMap();
		String resultado="";
		ArrayList<Usuario> lista=servicioUsuario.consultarUsuariosNoFrecuentes();
		try {
			resultado=servicioUsuario.enviarEmailUsuariosNoFrecuentes(lista).equals("ok")? "El envio de correos fue exitoso!":"Revise el log";
		}catch (Exception e) {
			resultado=e.getMessage();
		}
		modelo.put("mensaje", resultado);
		return new ModelAndView("listaUsuariosNoFrecuentes", modelo);
	}
	
	
}
