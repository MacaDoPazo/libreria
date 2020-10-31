package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Genero;

@Repository
@Transactional
public class RepositorioGeneroImpl implements RepositorioGenero {
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarGenero(Genero genero) {
		sessionFactory.getCurrentSession().save(genero);

	}

	@Override
	public Genero consultarGeneroPorId(Long id) {
		Genero genero = sessionFactory.getCurrentSession().get(Genero.class, id);
		return genero;
	}

	@Override
	public void eliminarGeneroPorId(Long idGenero) {
		Genero genero;
		genero = sessionFactory.getCurrentSession().get(Genero.class, idGenero);
		sessionFactory.getCurrentSession().delete(genero);
	}

	@Override
	public List<Genero> listarGeneros() {
		return (List<Genero>) sessionFactory.getCurrentSession().createCriteria(Genero.class).list();
	}

	

}
