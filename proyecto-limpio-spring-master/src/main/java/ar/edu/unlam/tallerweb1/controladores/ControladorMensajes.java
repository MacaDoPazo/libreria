package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensaje;


@Controller
public class ControladorMensajes {

	@Inject
	private ServicioMensaje servicioMensaje;
	
	@RequestMapping(path="/mensajes")
	public ModelAndView verMensajes (HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		ArrayList<Mensaje> lista=(ArrayList<Mensaje>) session.getAttribute("mensajes");
		ArrayList<Mensaje> mensajes_leidos=session.getAttribute("mensajes_leidos")!=null ? (ArrayList<Mensaje>)session.getAttribute("mensajes_leidos"):null;
		int cant_mjes_no_leidos=servicioMensaje.consultarMensajesNoLeidosUsuario(lista);
		if(mensajes_leidos!=null) {
			servicioMensaje.actualizarListaMensajes(mensajes_leidos);
		}
		ModelMap modelo = new ModelMap();
		modelo.put("lista_mensajes",lista);
		modelo.put("no_leidos",cant_mjes_no_leidos);
		return new ModelAndView("mensajes",modelo);
	}

	public ServicioMensaje getServicioMensaje() {
		return servicioMensaje;
	}

	public void setServicioMensaje(ServicioMensaje servicioMensaje) {
		this.servicioMensaje = servicioMensaje;
	}
	
	
}
