package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface ServicioAutor {

	Long guardarAutor(Autor autor);

	List<Autor> listarAutores();

	Autor consultarAutorPorId(Long idAutor);

	void borrarAutor(Long idAutor);

}
