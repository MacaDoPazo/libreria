package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioCantLibros;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;

@Controller
public class ControladorLocalidad {
	@Inject
	private ServicioLocalidad servicioLocalidad;
	@Inject
	private ServicioCantLibros servicioCantLibros;

	@RequestMapping(path="/registrar-localidad")
	
	public ModelAndView irAregistrarLocalidad()
	{
			return new ModelAndView("registrarLocalidad");
	}
	@RequestMapping("/guardar-localidad")
	public ModelAndView guardarLocalidad(@RequestParam("cp")Integer cp,@RequestParam("nombre") String nombre,@RequestParam("precio")Long precio)
	{
		Localidad localidad= new Localidad();
		localidad.setCp(cp);
		localidad.setNombre(nombre);
		localidad.setPrecio(precio);
		Long idLocalidad= servicioLocalidad.guardarLocalidad(localidad);
		ModelMap model=new ModelMap();
		return new ModelAndView("registrarLocalidad");
	}
	@RequestMapping("/lista-localidades")
	public ModelAndView listarLibros() {
		List<Localidad> listalocalidad = servicioLocalidad.listarLocalidades();
		ModelMap modelo = new ModelMap();
		modelo.put("listaLocalidades",listalocalidad);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("listaLocalidades");
		return mivista;
	}
	@RequestMapping(path="/buscar-localidad")
	public ModelAndView buscarLibroPorId(@RequestParam(value="cp")Integer cp,
			HttpServletRequest request)
	{
		Long idUsuario = (Long) request.getSession().getAttribute("usuario_id");
		List<CantidadLibros> librosPedidos=servicioCantLibros.listarLibrosPedidoDelCliente(idUsuario,"armando");
		Long subtotal = servicioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
		Localidad localidadEncontrada = servicioLocalidad.consultarLocalidadPorCP(cp);
		Date fecha_entrega = servicioLocalidad.calcularTiempoDeEntrega(localidadEncontrada);
		Long total=localidadEncontrada.getPrecio()+subtotal;
		ModelMap model = new ModelMap();
		model.put("localidad", localidadEncontrada);
		model.put("fechaEntrega", fecha_entrega);
		model.put("total",total);
		model.put("subtotal",subtotal);
		model.put("librosPedidos",librosPedidos);
		return new ModelAndView("carrito",model);
	}
}
