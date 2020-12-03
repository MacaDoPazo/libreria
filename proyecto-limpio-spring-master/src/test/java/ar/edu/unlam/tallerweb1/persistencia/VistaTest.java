package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorInicio;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Stock;

public class VistaTest extends SpringTest {

	@Inject
	SessionFactory sesion;
	@Test
	@Transactional @Rollback
   public void cargarVistaDetalleDelLibro()
    {
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
		ControladorInicio inicio = new ControladorInicio();
		ModelAndView model = new ModelAndView();// inicio.irADetalleProducto(idLibro);
		
		 Assert.assertEquals("detalleproducto", model.getViewName());
    }
}
