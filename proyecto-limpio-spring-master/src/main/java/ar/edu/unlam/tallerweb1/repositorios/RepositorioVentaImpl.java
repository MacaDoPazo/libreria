package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	

	@Override
	public List<Venta> listarPedidosFacturados() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Venta.class)
				.list();
	}

}
