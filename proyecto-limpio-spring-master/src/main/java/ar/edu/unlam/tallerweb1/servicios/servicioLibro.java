package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface servicioLibro {

	Libro consultarLibroPorId(Long id);
		
		

	  Long guardarlibro(Libro libro);



	List<Libro> listarLibros();



	void borrarLibro(Long idLibro);



	void actualizarMeGusta(Long idLibro, Integer suma);



	List<Libro> listarLibrosGenero(Long idGenero);



	



	
		
		

}
