package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFarmacia;

@Service
@Transactional
public class ServicioFarmaciaImpl implements ServicioFarmacia {

	@Inject
	private RepositorioFarmacia repositorioFarmacia;

	@Override
	public void guardarFarmacia(Farmacia farmacia) {
		repositorioFarmacia.guardarFarmacia(farmacia);
	}

}
