package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;

@Repository
@Transactional
public class RepositorioMensajeImpl implements RepositorioMensaje {

	@Inject
	 SessionFactory sesion;
	
	@Override
	public Long guardarMensaje(Mensaje mensaje) {
		return (Long) sesion.getCurrentSession().save(mensaje);
	}

	@Override
	public ArrayList<Mensaje> obtenerMensajesCliente(Long id) {
		return (ArrayList<Mensaje>) sesion.getCurrentSession().createCriteria(Mensaje.class)
				.add(Restrictions.eq("cliente",id))
				.list();
	}

	@Override
	public void actualizarMensaje(Mensaje mensaje) {
		sesion.getCurrentSession().update(mensaje);
		
	}

}
