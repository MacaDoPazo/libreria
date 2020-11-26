package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface servicioLibro {

	Libro consultarLibroPorId(Long id);
		
		

	  Long guardarlibro(Libro libro);



	List<Libro> listarLibros();



	void borrarLibro(Long idLibro);



	void actualizarMeGusta(Long idLibro, Integer suma);



	List<Libro> listarLibrosGenero(Genero genero);



	List<Libro> listarLibrosGeneroMayorPuntaje(Long id) throws Exception;


	List<Libro> listarLibrosDeUnAutor(Long autor_id);
	
	List<Libro> listarLibrosDeUnGenero(Long genero_id);
	
	List<Libro> listarLibrosConMismoGeneroOMismoAutor(Long idLibroAComparar);
	
	List<Integer> listarPromedioDeReseniaPorCadaLibro(List<Libro> listaLibros) ;


	
		
		

}
