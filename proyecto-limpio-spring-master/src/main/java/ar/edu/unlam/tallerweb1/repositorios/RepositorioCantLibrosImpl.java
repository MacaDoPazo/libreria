package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
@Repository
public class RepositorioCantLibrosImpl implements RepositorioCantLibros {

	@Inject
	SessionFactory sesion;
	@Override
	public Long guardarCantidadLibros(CantidadLibros cantidadLibros) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().save(cantidadLibros);
	}

}
