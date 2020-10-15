package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.servicioLibro;

@Controller
public class ControladorPedido {

//	@Inject
	
//	private ServicioPedido servicioPedido;
	
//	@Inject
//	private servicioLibro servicioLibro;

//	@Inject
//	private ServicioCantLibros servicioCantLibros;
	
/*	@RequestMapping("/agregar-al-carrito")
	public ModelAndView agregarAlCarrito (@RequestParam("idLibro") Long idLibro,
			@RequestParam("canitdad") Long cantidad,
			@RequestParam("precio") Long precio,@RequestParam("idCliente") Long idCliente)
	{
		Pedido pedidoArmando = servicioPedido.buscarPedidoArmando(idCliente,"armando");
		
		if(pedidoArmando == null)
		{
			Pedido pedido = new Pedido();
			pedido.setEstado("armando");
			pedido.setCliente(idCliente);
			Long idPedido =servicioPedido.guardarPedido(pedido);
			Pedido pedidoCliente = servicioPedido.consultarPedidoPorId(idPedido);
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibro);
			Long total = cantidad*precio;
			CantidadLibros cantidadLibros = new CantidadLibros();
			cantidadLibros.setLibro(libroPedir);
			cantidadLibros.setPedido(pedidoCliente);
			cantidadLibros.setCantidad(total);
			cantidadLibros.setPrecioTotal(total);
			Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			
			
		}
		else
		{
			Libro libroPedir = servicioLibro.consultarLibroPorId(idLibro);
			Long total = cantidad*precio;
			CantidadLibros cantidadLibros = new CantidadLibros();
			cantidadLibros.setLibro(libroPedir);
			cantidadLibros.setPedido(pedidoArmando);
			cantidadLibros.setCantidad(cantidad);
			cantidadLibros.setPrecioTotal(total);
			Long idCantLibros = servicioCantLibros.guardarCantidadLibros(cantidadLibros);
			
			
		}
		
		List<Libro> listalibros = servicioLibro.listarLibros();
		ModelMap modelo = new ModelMap();
		modelo.put("lista",listalibros);
		return new ModelAndView("pantallainicial",modelo);
	}*/
		
}
