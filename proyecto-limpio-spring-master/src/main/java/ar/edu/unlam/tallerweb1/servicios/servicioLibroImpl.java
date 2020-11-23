package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.repositorios.LibroDao;

@Service
@Transactional
public class servicioLibroImpl implements servicioLibro {
	@Inject
	private LibroDao libroDao;
	@Inject
	private ServicioGenero servicioGenero;
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
	public List<Libro> listarLibrosGeneroMayorPuntaje(Long id) throws Exception {
		List<Resenia_Libros_Cliente> lista = libroDao.listarLibrosQueHizoReseniaElCliente(id);
		if (lista.size() == 0)
		{
			throw new Exception("Queremos saber tu opnion y suma puntos!");
		}
		
		List <Genero> generos = new ArrayList<Genero>();
		for (Resenia_Libros_Cliente resenia_Libros_Cliente : lista) {
			if(resenia_Libros_Cliente.getResenia().getPuntuacion() >= 4)
			{
				generos.add(resenia_Libros_Cliente.getLibro().getGenero());
			}
			
		}
		Genero random = servicioGenero.elegirGeneroRandom(generos);
//		Integer ban = 0;
//		Integer maximaCantidad = 0;
//		Genero maximoGenero = new Genero();
//		for (Genero genero : generos) {
//			while(ban == 0)
//			{
//				maximaCantidad = Collections.frequency(generos, genero);
//				maximoGenero = genero;
//				ban = 1;
//			}
//			if (maximaCantidad <= Collections.frequency(generos, genero))
//			{
//				maximoGenero = genero;
//			}
//		}
		
		return libroDao.listarLibrosGenero(random);
	}
	@Override
	public List<Libro> listarLibrosDeUnAutor(Long autor_id) {
		
		return libroDao.listarLibrosDeUnAutor(autor_id);
	}
	@Override
	public List<Libro> listarLibrosDeUnGenero(Long genero_id) {
		return libroDao.listarLibrosDeUnGenero(genero_id);
	}
	
	@Override
	public List<Libro> listarLibrosConMismoGeneroOMismoAutor(Long idLibroAComparar) {
		return libroDao.listarLibrosConMismoGeneroOMismoAutor(idLibroAComparar);
	}
	

}
