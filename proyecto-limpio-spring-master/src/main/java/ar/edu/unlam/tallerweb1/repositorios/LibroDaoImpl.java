package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
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
	
	
	@Override
	public List<Libro> listarLibros() {
		
		return (List<Libro>) sesion.getCurrentSession().createCriteria(Libro.class).list();
	}
	@Override
	public void borrarLibro(Long idLibro) {
		// TODO Auto-generated method stub
		Libro libro;
		libro = sesion.getCurrentSession().get(Libro.class, idLibro);
		sesion.getCurrentSession().delete(libro);
	}
	@Override
	public void actualizarMeGusta(Long idLibro, Integer suma) {
		// TODO Auto-generated method stub
		Libro libro;
		libro = sesion.getCurrentSession().get(Libro.class, idLibro);
		libro.setMegusta(suma);
		sesion.getCurrentSession().update(libro);
	}
	
	@Override
	public List<Libro> listarLibrosGenero(Genero genero) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(Libro.class)
				.createAlias("genero", "generoLibro")
				.add(Restrictions.eq("generoLibro.id",genero.getId())).list();
	}
	@Override
	public List<Resenia_Libros_Cliente> listarLibrosQueHizoReseniaElCliente(Long id) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(Resenia_Libros_Cliente.class)
				.createAlias("usuario", "cliente")
				.createAlias("resenia", "clienteResenia")
				.add(Restrictions.eq("cliente.id",id))
				.list();
	}
	@Override
	public void actualizarLibro(Libro libro) {
		// TODO Auto-generated method stub
		 sesion.getCurrentSession().update(libro);
	}
	@Override
	public List<Libro> listarLibrosDeUnAutor(Long autor_id) {
		return sesion.getCurrentSession().createCriteria(Libro.class)
				.createAlias("autor", "autorBuscado")
				.add(Restrictions.eq("autorBuscado.id", autor_id))
				.list();
	}

}
