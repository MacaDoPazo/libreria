package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Repository
@Transactional
public class RepositorioPedidoImpl implements RepositorioPedido {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarPedido(Pedido pedido) {
		sessionFactory.getCurrentSession().save(pedido);
	}

	@Override
	public Pedido consultarPedidoPorId(Long id) {
		Pedido pedido = sessionFactory.getCurrentSession().get(Pedido.class,id);
		return pedido;
	}

}
