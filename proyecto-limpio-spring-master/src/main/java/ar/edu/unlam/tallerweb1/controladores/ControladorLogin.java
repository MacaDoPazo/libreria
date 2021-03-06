package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioUsuario servicioUsuario;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		String passwordHardcodeada=servicioUsuario.hardcodearCadena(usuario.getPassword());
		usuario.setPassword(passwordHardcodeada);
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			Date today = Calendar.getInstance().getTime();
			usuarioBuscado.setFecha_ultimo_login(today);
			servicioUsuario.actualizarUsuario(usuarioBuscado);
			request.getSession().setAttribute("usuario_id", usuarioBuscado.getId());
			request.getSession().setAttribute("usuario_nombre", usuarioBuscado.getNombre());
			request.getSession().setAttribute("usuario_rol", usuarioBuscado.getRol());
			request.getSession().setAttribute("mensajes", servicioUsuario.obtenerMensajesUsuario(usuarioBuscado.getId()));
			return new ModelAndView("redirect:/pantalla-inicial");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/salir")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("usuario_id");
		session.removeAttribute("usuario_nombre");
		session.removeAttribute("usuario_rol");
		session.removeAttribute("mensajes");
		session.removeAttribute("mensajes_leidos");
	    session.invalidate();
			return new ModelAndView("redirect:/pantalla-inicial");
		
	}
	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
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
			@RequestParam("fechaNac") String fechaNac,
			@RequestParam("password") String password,
			@RequestParam("passwordRepetido") String passwordRepetido
			) {
		char sex=sexo.charAt(0);
		Usuario usuario=new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setSexo(sex);
		usuario.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fechaNac));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setFechaNac(calendar.getTime());
		usuario.setPassword(password);
		usuario.setRol("Cliente");
		Date today = Calendar.getInstance().getTime();
		usuario.setFecha_ultimo_login(today);
		servicioUsuario.guardarUsuario(usuario);
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido);
		modelo.put("sexo", sexo);
		modelo.put("email", email);
		modelo.put("password", password);
		modelo.put("passwordRepetido", passwordRepetido);
	
		return new ModelAndView("mostrarUsuarioRegistrado", modelo);
		
	}
	
}
