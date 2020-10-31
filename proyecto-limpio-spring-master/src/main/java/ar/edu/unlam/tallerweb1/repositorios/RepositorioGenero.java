package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Genero;

public interface RepositorioGenero {
	public void guardarGenero(Genero genero);
	public Genero consultarGeneroPorId(Long id);
	public void eliminarGeneroPorId(Long idGenero);
	List<Genero> listarGeneros();

}
