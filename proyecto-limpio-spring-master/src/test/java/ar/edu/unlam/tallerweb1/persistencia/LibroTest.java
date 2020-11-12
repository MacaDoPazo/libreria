package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Stock;

public class LibroTest extends SpringTest {
	@Inject
	SessionFactory sesion;
	
	@Test
    @Transactional @Rollback
    public void guardarLibroEnBaseDeDatos(){
		Genero genero = new Genero();
		genero.setNombre("Terror");
		Stock stock = new Stock();
		stock.setCantidad(500L);
		Autor autor = new Autor();
		autor.setNombre("Homero");
		autor.setApellido("Simpson");
		autor.setSexo("masculino");
		Libro libro = new Libro();
		libro.setId(1L);
		libro.setNombre("Sr X");
		libro.setAutor(autor);
		libro.setGenero(genero);
		Long idLibro = (Long) sesion.getCurrentSession().save(libro);
		
        assertThat(idLibro).isEqualTo(1L);
    }
}
