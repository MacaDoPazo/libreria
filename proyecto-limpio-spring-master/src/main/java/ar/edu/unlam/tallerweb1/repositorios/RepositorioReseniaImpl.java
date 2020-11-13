package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioReseniaImpl implements RepositorioResenia {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarResenia(Resenia resenia) {
		sessionFactory.getCurrentSession().save(resenia);

	}

	@Override
	public Resenia consultarReseniaPorId(Long id) {
		Resenia resenia = sessionFactory.getCurrentSession().get(Resenia.class, id);
		return resenia;
	}

	@Override
	public void eliminarReseniaPorId(Long idResenia) {
		Resenia resenia;
		resenia = sessionFactory.getCurrentSession().get(Resenia.class, idResenia);
		sessionFactory.getCurrentSession().delete(resenia);

	}

	@Override
	public List<Resenia> listarResenias() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Resenia.class)
				.list();
	}

	@Override
	public void guardarReseniaLibrosCliente(Resenia_Libros_Cliente reseniaLibroCliente) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(reseniaLibroCliente);
	}

	@Override
	public Resenia_Libros_Cliente consultarReseniaLibroCliente(Libro libro, Usuario usuario) {
		// TODO Auto-generated method stub
		return (Resenia_Libros_Cliente) sessionFactory.getCurrentSession().createCriteria(Resenia_Libros_Cliente.class)
				.add(Restrictions.and(Restrictions.eq("libro",libro),
						Restrictions.eq("usuario",usuario))).uniqueResult();
	}

	@Override
	public List<Resenia_Libros_Cliente> listarReseniasDelCliente(Long usuario) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Resenia_Libros_Cliente.class)
				.createAlias("usuario", "reseniaUsuario")
				.add(Restrictions.eq("reseniaUsuario.id",usuario))
				.list();
	}

}
