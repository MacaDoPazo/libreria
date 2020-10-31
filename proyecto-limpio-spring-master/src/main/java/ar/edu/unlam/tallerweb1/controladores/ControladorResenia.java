package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;

@Controller
public class ControladorResenia {
	@Inject
	private ServicioResenia servicioResenia;
	
	@RequestMapping(path="/registrar-resenia", method= RequestMethod.POST)
	public ModelAndView IrAlRegistroDelaResenia() {
//			@RequestParam("listaLibrosDeLaVenta") List <Venta> listadoVentasRealizadasAlCliente){		
				return new ModelAndView("registrarResenia");		
	}

}
