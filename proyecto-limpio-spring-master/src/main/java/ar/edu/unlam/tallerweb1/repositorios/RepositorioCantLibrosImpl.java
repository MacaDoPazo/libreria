package ar.edu.unlam.tallerweb1.repositorios;

import java.nio.file.attribute.GroupPrincipal;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
@Repository
public class RepositorioCantLibrosImpl implements RepositorioCantLibros {

	@Inject
	SessionFactory sesion;
	@Override
	public Long guardarCantidadLibros(CantidadLibros cantidadLibros) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().save(cantidadLibros);
	}
	@Override
	public List<CantidadLibros> listarLibrosPedidoDelCliente(Long idCliente,String armado) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(CantidadLibros.class)
				.createAlias("pedido", "pedidocliente")
				.add(Restrictions.and(Restrictions.eq("pedidocliente.cliente",idCliente),
						Restrictions.eq("pedidocliente.estado",armado))).list();
	}
	
	@Override
	public CantidadLibros buscarLibroEnPedidoArmado(Pedido pedidoArmando, Libro libroPedir) {
		// TODO Auto-generated method stub
		
		return (CantidadLibros) sesion.getCurrentSession().createCriteria(CantidadLibros.class)
				.add(Restrictions.eq("pedido",pedidoArmando))
				.add(Restrictions.eq("libro",libroPedir))
				.uniqueResult();
	}
	@Override
	public void actualizarCantidadLibros(CantidadLibros libroEncontrado) {
		// TODO Auto-generated method stub
		sesion.getCurrentSession().update(libroEncontrado);
	}
	@Override
	public CantidadLibros buscarCantidadLibrosPorId(Long idCantidadLibros) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().get(CantidadLibros.class,idCantidadLibros);
	}
	@Override
	public Long subtotalDeTodosLosLibros(List<CantidadLibros> librosPedidos) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().createCriteria(CantidadLibros.class)
				.setProjection(Projections.sum("precioTotal")).uniqueResult();
	}
	@Override
	public List<CantidadLibros> listarLibrosComprados(Long pedidoId) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(CantidadLibros.class)
				.add(Restrictions.eq("pedido.id",pedidoId)).list();
	}

}
