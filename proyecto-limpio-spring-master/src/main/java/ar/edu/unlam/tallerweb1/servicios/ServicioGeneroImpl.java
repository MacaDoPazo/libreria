package ar.edu.unlam.tallerweb1.servicios;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGenero;

@Service
@Transactional
public class ServicioGeneroImpl implements ServicioGenero {
	@Inject
	private RepositorioGenero repositorioGenero;
	
	@Override
	public void guardarGenero(Genero genero) {
		repositorioGenero.guardarGenero(genero);

	}

	@Override
	public Genero consultarGeneroPorId(Long id) {
		Genero genero = repositorioGenero.consultarGeneroPorId(id);
		return genero;
	}

	@Override
	public void eliminarGeneroPorId(Long idGenero) {
		repositorioGenero.eliminarGeneroPorId(idGenero);

	}

	@Override
	public List<Genero> listarGeneros() {
		return repositorioGenero.listarGeneros();
	}
	public Genero elegirGeneroRandom(List<Genero> generos) {
		Collections.shuffle(generos);
		return generos.get(0);
	}
}
