package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Repository
public class RepositorioFarmaciaImpl implements RepositorioFarmacia {
	
	@Inject
	 SessionFactory sessionFactory;
	@Override
	public void guardarFarmacia(Farmacia farmacia) {
		/*Session sesion = sessionFactory.getCurrentSession();
		sesion.save(farmacia);*/
		sessionFactory.getCurrentSession().save(farmacia);
	}

}
