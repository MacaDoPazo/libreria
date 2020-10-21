package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Repository
@Transactional
public class RepositorioPedidoImpl implements RepositorioPedido {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long guardarPedido(Pedido pedido) {
		return (Long) sessionFactory.getCurrentSession().save(pedido);
	}

	@Override
	public Pedido consultarPedidoPorId(Long id) {
		Pedido pedido = sessionFactory.getCurrentSession().get(Pedido.class,id);
		return pedido;
	}

	@Override
	public Pedido buscarPedidoArmando(Long idCliente,String armando) {
		// TODO Auto-generated method stub
		return (Pedido) sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				//.createAlias("cliente","clienteBuscado")
				
				.add(Restrictions.and(Restrictions.eq("cliente",idCliente),Restrictions.eq("estado",armando))).uniqueResult();
	}

	@Override
	public void actualizarEstadoDelPedido(Long idPedido, String estadoActualizado) {
		Pedido pedido;
		pedido = sessionFactory.getCurrentSession().get(Pedido.class, idPedido);
		pedido.setEstado(estadoActualizado);
		sessionFactory.getCurrentSession().update(pedido);
		
	}

}
