package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
@Repository
public class RepositorioLocalidadImpl implements RepositorioLocalidad {
	@Inject
	private SessionFactory sesion;
	@Override
	public Long guardarLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().save(localidad);
	}
	@Override
	public List<Localidad> listaLocalidades() {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(Localidad.class).list();
	}
	@Override
	public Localidad buscarLocalidadPorCp(Integer cp) {
		// TODO Auto-generated method stub
		return (Localidad)sesion.getCurrentSession().createCriteria(Localidad.class)
				.add(Restrictions.eq("cp", cp))
				
				.uniqueResult();
	}

}
