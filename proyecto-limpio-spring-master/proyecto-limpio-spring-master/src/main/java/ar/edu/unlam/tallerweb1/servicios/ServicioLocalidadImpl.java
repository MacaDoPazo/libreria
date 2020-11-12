package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocalidad;
@Service
@Transactional
public class ServicioLocalidadImpl implements ServicioLocalidad {
	@Inject
	private RepositorioLocalidad repositorioLocalidad;

	@Override
	public Long guardarLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
		return repositorioLocalidad.guardarLocalidad(localidad);
	}

	@Override
	public List<Localidad> listarLocalidades() {
		// TODO Auto-generated method stub
		return repositorioLocalidad.listaLocalidades();
	}

	@Override
	public Localidad consultarLocalidadPorCP(Integer cp) {
		// TODO Auto-generated method stub
		return repositorioLocalidad.buscarLocalidadPorCp(cp);
	}

}
