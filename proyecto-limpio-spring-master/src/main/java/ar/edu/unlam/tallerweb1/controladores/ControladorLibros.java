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
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorLibros {

	@Inject
	private servicioLibro servicioLibro;
	@Inject
	private ServicioAutor servicioAutor;
	@RequestMapping("/registrar-libro")
	public ModelAndView mostrarCatalogoLibros() {
		List<Autor> listaAutores = servicioAutor.listarAutores();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listaAutores);
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
			@RequestParam(value="paginas")Long paginas,@RequestParam(value="precio") Long precio,
			@RequestParam(value="stock")Long stock)
	{
		Libro libro = new Libro();
		libro.setNombre(nombre);
		libro.setPaginas(paginas);
		libro.setPrecio(precio);
		libro.setStock(stock);
		Autor autorEncontrado = servicioAutor.consultarAutorPorId(idAutor);
		libro.setAutor(autorEncontrado);
		Long idLibro = servicioLibro.guardarlibro(libro);
		ModelMap modelo = new ModelMap();
		modelo.put("id",idLibro);
		modelo.put("nombre",nombre);
		modelo.put("paginas",paginas);
		modelo.put("precio",precio);
		modelo.put("stock",stock);
		modelo.put("autorLibro", autorEncontrado);
		
		
		return new ModelAndView("catalogoLibros",modelo);
	}
	
    @RequestMapping("/listar-libros")
	public ModelAndView listarLibros() {
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		ModelAndView mivista =new ModelAndView();
		mivista.addAllObjects(modelo);
		mivista.setViewName("catalogoLibros");
		return mivista;
	}
}
