package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmacia;

@Controller
public class ControladorFarmacia {

	private ServicioFarmacia servicioFarmacia;

	@RequestMapping(path="/registrar-farmacia")
	public ModelAndView registrarFarmacia()
	{
		Farmacia farmacia = new Farmacia();
		farmacia.setDireccion("fv 1900");
		farmacia.setNombre("Unlam");
		
		servicioFarmacia.guardarFarmacia(farmacia);
		return new ModelAndView("farmacia");
	}
}
