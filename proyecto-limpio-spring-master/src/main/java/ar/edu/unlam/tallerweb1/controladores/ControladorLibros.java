package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioGenero;
import ar.edu.unlam.tallerweb1.servicios.ServicioStock;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorLibros {

	@Inject
	private servicioLibro servicioLibro;
	@Inject
	private ServicioAutor servicioAutor;
	@Inject
	private ServicioStock servicioStock;
	@Inject
	private ServicioGenero servicioGenero;
	
	@RequestMapping("/registrar-libro")
	public ModelAndView mostrarCatalogoLibros() {
		List<Autor> listaAutores = servicioAutor.listarAutores();
		List<Genero> listaGeneros = servicioGenero.listarGeneros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listaAutores);
		modelo.put("listaGeneros", listaGeneros);
		return new ModelAndView("registrarLibro",modelo);
	}
	
	@RequestMapping(path="/buscarLibroPorId",method = RequestMethod.GET)
	public ModelAndView buscarLibroPorId(@RequestParam(value="id")Long id)
	{
		ModelMap model = new ModelMap();

		Libro libroEncontrado = servicioLibro.consultarLibroPorId(id);

		model.put("libro", libroEncontrado);
		return new ModelAndView("catalogolibros",model);
	}
	@RequestMapping("/guardar-libro")
	public ModelAndView guardarLibro(@RequestParam(value="nombre")String nombre,@RequestParam(value="idAutor")Long idAutor,
			@RequestParam(value="idGenero")Long idGenero,
			@RequestParam(value="paginas")Long paginas,@RequestParam(value="precio") Long precio,
			@RequestParam(value="cantidad")Long cantidad)
	{
		Libro libro = new Libro();
		libro.setNombre(nombre);
		libro.setPaginas(paginas);
		libro.setPrecio(precio);
		Stock stock = new Stock();
		stock.setCantidad(cantidad);
		stock.setDisponibilidad(true);
		Long idStock = servicioStock.guardarStock(stock);
		libro.setStock(stock);
		libro.setMegusta(0);
		Autor autorEncontrado = servicioAutor.consultarAutorPorId(idAutor);
		libro.setAutor(autorEncontrado);
		Genero generoEncontrado = servicioGenero.consultarGeneroPorId(idGenero);
		libro.setGenero(generoEncontrado);
		Long idLibro = servicioLibro.guardarlibro(libro);
		ModelMap modelo = new ModelMap();
		modelo.put("id",idLibro);
		modelo.put("nombre",nombre);
		modelo.put("paginas",paginas);
		modelo.put("precio",precio);
		modelo.put("stock",stock);
		modelo.put("autorLibro", autorEncontrado);
		modelo.put("generoLibro", generoEncontrado);
		
		
		return new ModelAndView("registrarLibro",modelo);
	}
	
    @RequestMapping("/catalogo-libros")
	public ModelAndView listarLibros() {
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("catalogoLibros");
		return mivista;
	}
    
    @RequestMapping("/borrar-libro")
    public ModelAndView borrarLibro(@RequestParam(value="idLibro")Long idLibro)
	{
		servicioLibro.borrarLibro(idLibro);
		return new ModelAndView("registrarLibro");
	}
    @RequestMapping(path="/sumar-megusta", method=RequestMethod.GET)
    public ModelAndView sumarMeGusta (@RequestParam(value="idLibro")Long idLibro)
    {
    	Libro libro=servicioLibro.consultarLibroPorId(idLibro);
    	Integer suma = libro.getMegusta()+1;
    	servicioLibro.actualizarMeGusta(idLibro,suma);
    	List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		return new ModelAndView("pantallainicial",modelo);
    }
    
    
    @RequestMapping(path="/listar-libros-autor", method=RequestMethod.GET)
    public ModelAndView listaLibrosDelAutor (@RequestParam(value="autor_id")Long autor_id)
    {

    	List<Libro> listalibros = servicioLibro.listarLibrosDeUnAutor(autor_id);
    	Autor autor = servicioAutor.consultarAutorPorId(autor_id);
    	String nombreYApellidoDelAutor= autor.getNombre() + " " + autor.getApellido();
    	
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		modelo.put("nombreYApellidoDelAutor", nombreYApellidoDelAutor);
		return new ModelAndView("listaLibrosDelAutor",modelo);
    }
    
    @RequestMapping(path="/listar-libros-genero", method=RequestMethod.GET)
    public ModelAndView listaLibrosDelGenero (@RequestParam(value="genero_id")Long genero_id)
    {

    	List<Libro> listalibros = servicioLibro.listarLibrosDeUnGenero(genero_id);
    	Genero genero = servicioGenero.consultarGeneroPorId(genero_id);
    	String nombreDelGenero= genero.getNombre();
    	
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		modelo.put("nombreDelGenero", nombreDelGenero);
		return new ModelAndView("listaLibrosDelGenero",modelo);
    }
    
}
