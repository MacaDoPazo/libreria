package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;


public interface RepositorioAutor {

	Long guardarAutor(Autor autor);

	List<Autor> listarAutores();

	Autor buscarAutorPorId(Long idAutor);

}
