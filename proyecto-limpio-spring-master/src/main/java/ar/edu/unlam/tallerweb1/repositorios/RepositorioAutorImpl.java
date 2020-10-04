package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Libro;
@Repository
public class RepositorioAutorImpl implements RepositorioAutor {

	@Inject
	 SessionFactory sesion;
	@Override
	public Long guardarAutor(Autor autor) {
		return (Long) sesion.getCurrentSession().save(autor);

	}
	@Override
	public List<Autor> listarAutores() {
		// TODO Auto-generated method stub
		return (List<Autor>) sesion.getCurrentSession().createCriteria(Autor.class).list();
	}
	@Override
	public Autor buscarAutorPorId(Long idAutor) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().get(Autor.class, idAutor);
	}
	@Override
	public void borrarAutor(Long idAutor) {
		Autor autor;
		autor = sesion.getCurrentSession().get(Autor.class, idAutor);
		sesion.getCurrentSession().delete(autor);
	}

}
