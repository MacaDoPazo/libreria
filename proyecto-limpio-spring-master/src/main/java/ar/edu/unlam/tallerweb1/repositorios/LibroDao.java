package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;

public interface LibroDao {

	Libro consultarLibroPorId(Long id);

	Long guardarLibro(Libro libro);
	
	void actualizarLibro(Libro libro);

	List<Libro> listarLibros();

	void borrarLibro(Long idLibro);

	void actualizarMeGusta(Long idLibro, Integer suma);

	List<Libro> listarLibrosGenero(Genero genero);

	List<Resenia_Libros_Cliente> listarLibrosQueHizoReseniaElCliente(Long id);

	List<Libro> listarLibrosDeUnAutor(Long autor_id);
	

	
}
