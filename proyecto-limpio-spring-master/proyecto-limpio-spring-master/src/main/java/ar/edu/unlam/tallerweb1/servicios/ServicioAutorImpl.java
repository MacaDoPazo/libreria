package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;
@Service
@Transactional
public class ServicioAutorImpl implements ServicioAutor {

	@Inject
	private RepositorioAutor repositorioAutor;

	
	public Long guardarAutor(Autor autor) {
			
		
		return repositorioAutor.guardarAutor(autor);

	}


	@Override
	public List<Autor> listarAutores() {
		// TODO Auto-generated method stub
		return repositorioAutor.listarAutores();
	}


	@Override
	public Autor consultarAutorPorId(Long idAutor) {
		// TODO Auto-generated method stub
		return repositorioAutor.buscarAutorPorId(idAutor);
	}


	@Override
	public void borrarAutor(Long idAutor) {
		// TODO Auto-generated method stub
		 repositorioAutor.borrarAutor(idAutor);
	}

}
