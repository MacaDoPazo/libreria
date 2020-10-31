package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.servicios.ServicioGenero;

@Controller
public class ControladorGenero {
	@Inject
	private ServicioGenero servicioGenero;
	
	@RequestMapping(path="/registrar-genero")
	public ModelAndView IrAlRegistroDelGenero() {		
				return new ModelAndView("registrarGenero");		
	}
	
	@RequestMapping("/guardar-genero")
	public ModelAndView registrarGenero(@RequestParam(value="nombre")String nombre)
	{
		Genero genero = new Genero();
		genero.setNombre(nombre);
		servicioGenero.guardarGenero(genero);
		
		ModelMap modelo = new ModelMap();		
		return new ModelAndView("registrarGenero",modelo);		
	}
	
	@RequestMapping("/borrar-genero")
	public ModelAndView borrarGenero(@RequestParam(value="id")Long idGenero)
	{
		servicioGenero.eliminarGeneroPorId(idGenero);
		return new ModelAndView("listaGeneros");
	}
	
	@RequestMapping("/lista-generos")
	public ModelAndView listarGeneros() {
		List<Genero> listaGeneros = servicioGenero.listarGeneros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listaGeneros);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("listaGeneros");
		return mivista;
	}

}
