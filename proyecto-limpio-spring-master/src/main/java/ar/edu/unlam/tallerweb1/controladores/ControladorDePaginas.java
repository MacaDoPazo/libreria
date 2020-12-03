package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioOperaciones;

@Controller //anotation
public class ControladorDePaginas {
	@Autowired
	private ServicioOperaciones servicioOperaciones;
	@RequestMapping("/operaciones")
	public ModelAndView operaciones() {
		return new ModelAndView("operaciones");
	}
	@RequestMapping(path="sumar", method=RequestMethod.GET)
	public ModelAndView suma(@RequestParam(value="num1",required=false)Integer num1,@RequestParam(value="num2",required=false)Integer num2)
	{
		Integer resultado=servicioOperaciones.sumar(num1, num2);
		ModelMap modelo= new ModelMap();
		modelo.put("suma",resultado);
		return new ModelAndView("operaciones",modelo);
	}
	@RequestMapping(path="restar", method=RequestMethod.GET)
	public ModelAndView resta(@RequestParam(value="num1",required=false)Integer num1,@RequestParam(value="num2",required=false)Integer num2)
	{
		Integer resultado=servicioOperaciones.restar(num1, num2);
		ModelMap modelo= new ModelMap();
		modelo.put("resta",resultado);
		return new ModelAndView("operaciones",modelo);
	}
	@RequestMapping(path="multiplicar", method=RequestMethod.GET)
	public ModelAndView multiplicar(@RequestParam(value="num1",required=false)Double num1,@RequestParam(value="num2",required=false)Double num2)
	{
		Double resultado=servicioOperaciones.multiplicar(num1, num2);
		ModelMap modelo= new ModelMap();
		modelo.put("multiplicacion",resultado);
		return new ModelAndView("operaciones",modelo);
	}
	@RequestMapping(path="dividir", method=RequestMethod.GET)
	public ModelAndView dividir(@RequestParam(value="num1",required=false)Double num1,@RequestParam(value="num2",required=false)Double num2) 
	{
		
		
		ModelMap modelo= new ModelMap();
		try {
			Double resultado = servicioOperaciones.dividir(num1, num2);
			modelo.put("dividir",resultado);
		} catch (Exception e) {
			String error= e.getMessage();
			modelo.put("error",error);
		}
		
		return new ModelAndView("operaciones",modelo);
	}
	@RequestMapping("/mostrarcontacto")//ruta que pone el usuario
	public ModelAndView contact() { //nombre vinculada a la ruta
		Integer resultado=servicioOperaciones.sumar(5, 6);
		ModelMap modelo = new ModelMap();
		modelo.put("titulo","Contacto");
		modelo.put("suma",resultado);
		return new ModelAndView("contacto",modelo);//nombre de la vista jsp
	}
	@RequestMapping(path="/mostrardatos", method = RequestMethod.GET)
	public ModelAndView datos() {
		ModelMap modelo = new ModelMap();//pone todos los datos ingresados de la vista
		modelo.put("materia","Taller Web 1");
		modelo.put("lenguaje","java");// primero nombre de variable, segundo valor
		modelo.put("titulo","Datos");
		return new ModelAndView("datos",modelo);//se ponen los datos que se van a pasar al modelo
	}
	@RequestMapping("/mostrarConfirmacion")
	public ModelAndView confirmacion(@RequestParam(value="nombre",required=false) String name,
			@RequestParam (value="apellido",required=false) String surname) {//parametros de un pedido de un http
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", name);
		modelo.put("apellido", surname);
		modelo.put("titulo","Confirmacion");
		return new ModelAndView("confirmacion",modelo);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
		@RequestMapping(path = "/", method = RequestMethod.GET)
		public ModelAndView inicial() {
			return new ModelAndView("redirect:/pantalla-inicial");
		}
		

}
