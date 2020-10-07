package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Localidad;

public interface ServicioLocalidad {

	Long guardarLocalidad(Localidad localidad);

	List<Localidad> listarLocalidades();

	Localidad consultarLocalidadPorCP(Integer cp);

}
