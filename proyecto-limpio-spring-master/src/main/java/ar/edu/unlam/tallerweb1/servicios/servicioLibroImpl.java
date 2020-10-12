package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.repositorios.LibroDao;

@Service
@Transactional
public class servicioLibroImpl implements servicioLibro {
	@Inject
	private LibroDao libroDao;
	public Libro consultarLibroPorId(Long id) {
		
		// TODO Auto-generated method stub
		return libroDao.consultarLibroPorId(id);
	}
	public Long guardarlibro(Libro libro) {
		// TODO Auto-generated method stub
		return libroDao.guardarLibro(libro);
	}
	@Override
	public List<Libro> listarLibros() {
		// TODO Auto-generated method stub
		return libroDao.listarLibros();
	}
	@Override
	public void borrarLibro(Long idLibro) {
		libroDao.borrarLibro(idLibro);
		
	}
	@Override
	public void actualizarMeGusta(Long idLibro, Integer suma) {
		// TODO Auto-generated method stub
		libroDao.actualizarMeGusta(idLibro,suma);
	}

}
