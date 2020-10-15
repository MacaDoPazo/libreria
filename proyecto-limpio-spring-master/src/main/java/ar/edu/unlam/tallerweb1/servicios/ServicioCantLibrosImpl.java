package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCantLibros;
@Service
@Transactional
public class ServicioCantLibrosImpl implements ServicioCantLibros {

	@Inject
	private RepositorioCantLibros respositorioCantLibros;

	
	public Long guardarCantidadLibros(CantidadLibros cantidadLibros) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.guardarCantidadLibros(cantidadLibros);
	}

}
