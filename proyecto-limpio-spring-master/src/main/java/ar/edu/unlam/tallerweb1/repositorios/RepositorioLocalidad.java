package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Localidad;

public interface RepositorioLocalidad {

	Long guardarLocalidad(Localidad localidad);

	List<Localidad> listaLocalidades();

	Localidad buscarLocalidadPorCp(Integer cp);

}
