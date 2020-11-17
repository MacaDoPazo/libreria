package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import static org.mockito.Mockito.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia_Libros_Cliente;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.LibroDaoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioGenero;
import ar.edu.unlam.tallerweb1.servicios.ServicioGeneroImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioReseniaImpl;

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
	
	
	
	 
	
	@Test
    @Transactional @Rollback
    public void verficiarQueUnGeneroEste()
    {
		 ServicioGeneroImpl servicioGenero = new ServicioGeneroImpl(); 
		Genero genero = new Genero();
		genero.setId(1L);
		genero.setNombre("Terror");
		Genero genero2 = new Genero();
		genero2.setId(2L);
		genero2.setNombre("Humor");
		
		List<Genero>listaGenero = new ArrayList<Genero>() ;
		listaGenero.add(genero);
		listaGenero.add(genero2);
		
		
		Genero resultado = mock(Genero.class);
		when(resultado.getNombre()).thenReturn("Humor");
		 resultado = servicioGenero.elegirGeneroRandom(listaGenero);
		
		assertThat(resultado).isEqualTo(genero2);
    }

	@Test
    @Transactional @Rollback
    public void unClienteNoHizoNingunaResenia() throws Exception
    {
	
		Usuario cliente = new Usuario();
		cliente.setNombre("hola");
		Long idUsu = (Long) sesion.getCurrentSession().save(cliente);
		Genero genero = new Genero();
		genero.setNombre("Terror");
		Stock stock = new Stock();
		stock.setCantidad(500L);
		Autor autor = new Autor();
		autor.setNombre("Homero");
		autor.setApellido("Simpson");
		autor.setSexo("masculino");
		Libro libro = new Libro();
		//libro.setId(1L);
		libro.setNombre("Sr X");
		libro.setAutor(autor);
		libro.setGenero(genero);
		Long idLibro = (Long) sesion.getCurrentSession().save(libro);
		Resenia resenia = new Resenia();
		resenia.setComentario("bueno");
		resenia.setPuntuacion(4);
		resenia.setCliente(cliente);
		Long idResenia = (Long) sesion.getCurrentSession().save(resenia);
		
		Resenia_Libros_Cliente resenia_libro_Cliente = new Resenia_Libros_Cliente();
		Libro l = sesion.getCurrentSession().get(Libro.class,idLibro);
		Resenia r = sesion.getCurrentSession().get(Resenia.class, idResenia);
		Usuario u = sesion.getCurrentSession().get(Usuario.class, idUsu);
		resenia_libro_Cliente.setLibro(l);
		resenia_libro_Cliente.setResenia(r);
		resenia_libro_Cliente.setUsuario(u);
	
		sesion.getCurrentSession().save(resenia_libro_Cliente);
		
		LibroDaoImpl libroDao = new LibroDaoImpl();
		try {
		List<Resenia_Libros_Cliente>lista = libroDao.listarLibrosQueHizoReseniaElCliente(3L);
		assertNull(lista);
		}catch (Exception e) {
			e.getMessage();
			
		}

		
		
    }
}
