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
import ar.edu.unlam.tallerweb1.servicios.ServicioVenta;

@Controller
public class ControladorGenero {
	@Inject
	private ServicioGenero servicioGenero;
	@Inject
	private ServicioVenta servicioVenta;
	@RequestMapping(path="/registrar-genero")
	public ModelAndView IrAlRegistroDelGenero() {		
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		ModelMap modelo = new ModelMap();
		modelo.put("alertaFacturados",alertaFacturados);
		return new ModelAndView("registrarGenero");		
	}
	
	@RequestMapping("/guardar-genero")
	public ModelAndView registrarGenero(@RequestParam(value="nombre")String nombre)
	{
		Genero genero = new Genero();
		genero.setNombre(nombre);
		servicioGenero.guardarGenero(genero);
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		ModelMap modelo = new ModelMap();	
		modelo.put("alertaFacturados",alertaFacturados);
		return new ModelAndView("registrarGenero",modelo);		
	}
	
	@RequestMapping("/borrar-genero")
	public ModelAndView borrarGenero(@RequestParam(value="id")Long idGenero)
	{
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		servicioGenero.eliminarGeneroPorId(idGenero);
		ModelMap modelo = new ModelMap();	
		modelo.put("alertaFacturados",alertaFacturados);
		return new ModelAndView("listaGeneros");
	}
	
	@RequestMapping("/lista-generos")
	public ModelAndView listarGeneros() {
		List<Genero> listaGeneros = servicioGenero.listarGeneros();
		Integer alertaFacturados = servicioVenta.contarPedidosEstadoFacturado();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listaGeneros);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("listaGeneros");
		modelo.put("alertaFacturados",alertaFacturados);
		return mivista;
	}

}
