package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
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
	
	@Override
	public List<Libro> listarLibrosGenero(Genero genero) {
		// TODO Auto-generated method stub
		return libroDao.listarLibrosGenero(genero);
	}
	@Override
	public List<Libro> listarLibrosGeneroMayorPuntaje(Long id) {
		List<Resenia_Libros_Cliente> lista = libroDao.listarLibrosQueHizoReseniaElCliente(id);
		List <Genero> generos = new ArrayList<Genero>();
		for (Resenia_Libros_Cliente resenia_Libros_Cliente : lista) {
			generos.add(resenia_Libros_Cliente.getLibro().getGenero());
		}
		Set<Genero> totalGenero = new HashSet<Genero>(generos);
		Integer ban = 0;
		Integer maximaCantidad = 0;
		Genero maximoGenero = new Genero();
		for (Genero genero : totalGenero) {
			while(ban == 0)
			{
				maximaCantidad = Collections.frequency(totalGenero, genero);
				maximoGenero = genero;
				ban = 1;
			}
			if (maximaCantidad < Collections.frequency(totalGenero, genero))
			{
				maximoGenero = genero;
			}
		}
		
		return libroDao.listarLibrosGenero(maximoGenero);
	}

}
