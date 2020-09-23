package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorInicio {
	
	@RequestMapping("/pantalla-inicial")
	public ModelAndView irAlInicio() {

		return new ModelAndView("pantallainicial");
	}
	
	@RequestMapping("/detalle-producto")
	
		public ModelAndView irADetalleProducto() {
			return new ModelAndView("detalleproducto");
		}
	@RequestMapping("/carrito-compras")
	public ModelAndView registrarUsuario()
	{
		return new ModelAndView("carrito");
	}
	

}
