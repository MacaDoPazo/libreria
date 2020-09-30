package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Autor;
@Repository
public class RepositorioAutorImpl implements RepositorioAutor {

	@Inject
	 SessionFactory sesion;
	@Override
	public Long guardarAutor(Autor autor) {
		return (Long) sesion.getCurrentSession().save(autor);

	}

}
