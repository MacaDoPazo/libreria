package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioResenia;

@Service
@Transactional
public class ServicioReseniaImpl implements ServicioResenia {
	@Inject
	private RepositorioResenia repositorioResenia;

	@Override
	public void guardarResenia(Resenia resenia) {
		repositorioResenia.guardarResenia(resenia);

	}

	@Override
	public Resenia consultarReseniaPorId(Long id) {
		Resenia resenia = repositorioResenia.consultarReseniaPorId(id);
		return resenia;
	}

	@Override
	public void eliminarReseniaPorId(Long idResenia) {
		repositorioResenia.eliminarReseniaPorId(idResenia);
	}

	@Override
	public List<Resenia> listarResenias() {
		return repositorioResenia.listarResenias();
	}

	@Override
	public void guardarReseniaLibrosCliente(Resenia_Libros_Cliente reseniaLibroCliente) {
		// TODO Auto-generated method stub
		repositorioResenia.guardarReseniaLibrosCliente(reseniaLibroCliente);
	}

	@Override
	public Resenia_Libros_Cliente consultarReseniaLibroCliente(Libro libro, Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioResenia.consultarReseniaLibroCliente(libro,usuario);
	}

	@Override
	public List<Resenia_Libros_Cliente> listarReseniasDelCliente(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioResenia.listarReseniasDelCliente(usuario);
	}

}
