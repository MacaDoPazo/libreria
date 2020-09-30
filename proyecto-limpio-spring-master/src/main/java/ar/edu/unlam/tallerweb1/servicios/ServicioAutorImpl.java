package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;
@Service
@Transactional
public class ServicioAutorImpl implements ServicioAutor {

	@Inject
	private RepositorioAutor repositorioAutor;

	
	public Long guardarAutor(Autor autor) {
			
		
		return repositorioAutor.guardarAutor(autor);

	}

}
