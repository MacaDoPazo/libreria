package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioResenia {
	
	public void guardarResenia(Resenia resenia);
	public Resenia consultarReseniaPorId(Long id);
	public void eliminarReseniaPorId(Long idResenia);
	List<Resenia> listarResenias();
	public void guardarReseniaLibrosCliente(Resenia_Libros_Cliente reseniaLibroCliente);
	public Resenia_Libros_Cliente consultarReseniaLibroCliente(Libro libro, Usuario usuario);


}
