package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import ar.edu.unlam.tallerweb1.modelo.Libro;
@Repository
@Transactional
public class LibroDaoImpl implements LibroDao {
	@Inject
	SessionFactory sesion;
	@Override
	public Libro consultarLibroPorId(Long id) {
		
		return sesion.getCurrentSession().get(Libro.class, id);
	}
	@Override
	public Long guardarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().save(libro);
	}
	/*@Override
	public List<Libro> listarLibros() {
		
		return (List<Libro>) sesion.getCurrentSession().createCriteria(Libro.class).createAlias("libro", "libro.id").add(Restrictions.eq("libro.id",id)).list();
	}*/

}
