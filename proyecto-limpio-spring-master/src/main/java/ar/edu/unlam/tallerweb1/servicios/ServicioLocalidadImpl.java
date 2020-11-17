package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.util.Calendar;
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
		
		return repositorioLocalidad.buscarLocalidadPorCp(cp);
	}

	@Override
	public Date calcularTiempoDeEntrega(Localidad localidadEncontrada) {
		java.sql.Date fechaVenta = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaVenta);
		calendario.add(Calendar.DAY_OF_YEAR,localidadEncontrada.getDiasAEntregar());
		
		return new java.sql.Date(calendario.getTimeInMillis());
	}

}
