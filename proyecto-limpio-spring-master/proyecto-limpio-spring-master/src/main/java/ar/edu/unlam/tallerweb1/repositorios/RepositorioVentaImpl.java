package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Venta;

@Repository
@Transactional
public class RepositorioVentaImpl implements RepositorioVenta {
	@Inject
	private SessionFactory sessionFactory;
	
	
	@Override
	public void guardarVenta(Venta venta) {
		sessionFactory.getCurrentSession().save(venta);

	}

	@Override
	public Venta consultarVentaPorId(Long id) {
		Venta venta = sessionFactory.getCurrentSession().get(Venta.class, id);
		return venta;
	}

}
