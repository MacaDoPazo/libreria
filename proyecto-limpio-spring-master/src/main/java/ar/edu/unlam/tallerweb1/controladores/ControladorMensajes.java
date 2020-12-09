package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Controller
public class ControladorMensajes {

	@RequestMapping(path="/mensajes")
	public ModelAndView verMensajes (HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		ArrayList<Mensaje> lista=(ArrayList<Mensaje>)session.getAttribute("mensajes");
		
		ModelMap modelo = new ModelMap();
		modelo.put("lista_mensajes",lista);
		
		return new ModelAndView("listaMensajes",modelo);
	}
}
