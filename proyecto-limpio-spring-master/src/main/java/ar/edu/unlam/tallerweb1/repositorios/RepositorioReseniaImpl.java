package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Resenia;

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

}
