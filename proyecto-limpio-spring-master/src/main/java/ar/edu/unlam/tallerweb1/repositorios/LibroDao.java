package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface LibroDao {

	Libro consultarLibroPorId(Long id);

	Long guardarLibro(Libro libro);

	//List<Libro> listarLibros();

	

	
}
