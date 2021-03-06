package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	// Como todo repositorio maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}

	@Override
	public Long guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Long id_usuario = null;
		try {
		id_usuario=(Long) sessionFactory.getCurrentSession().save(usuario);
		}catch (Exception e) {
			Logger logger = Logger.getLogger(RepositorioUsuarioImpl.class.getName());
			logger.log(Level.WARNING, "Guardar Usuario Lanzo la siguiente Excepcion: "+e.getMessage());
		}
		return id_usuario;
	}

	@Override
	public Usuario consultarUsuarioPorId(Long id) {
		Usuario usuario = sessionFactory.getCurrentSession().get(Usuario.class,id);
		return usuario;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);

	}

	@Override
	public ArrayList<Usuario> consultarUsuarios() {
		
		final Session session = sessionFactory.getCurrentSession();
		ArrayList<Usuario> lista=(ArrayList<Usuario>)session.createCriteria(Usuario.class).list();
		return lista;		
	}
}