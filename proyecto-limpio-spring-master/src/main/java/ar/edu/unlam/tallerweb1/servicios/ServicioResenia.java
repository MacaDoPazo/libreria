package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioResenia {
	
	public void guardarResenia(Resenia resenia);
	public Resenia consultarReseniaPorId(Long id);
	public void eliminarReseniaPorId(Long idResenia);
	List<Resenia> listarResenias();
	public void guardarReseniaLibrosCliente(Resenia_Libros_Cliente reseniaLibroCliente);
	public Resenia_Libros_Cliente consultarReseniaLibroCliente(Libro libro, Usuario usuario);
	public List<Resenia_Libros_Cliente> listarReseniasDelCliente(Long usuario);
	public List<Resenia> listarReseniasDelLibro(Long libro_id);

}
