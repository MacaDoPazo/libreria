package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface ServicioCantLibros {

	Long guardarCantidadLibros(CantidadLibros cantidadLibros);

	CantidadLibros buscarLibroEnPedidoArmado(Pedido pedidoArmando, Libro libroPedir);

	void actualizarCantidadLibros(CantidadLibros libroEncontrado);

	List<CantidadLibros> listarLibrosPedidoDelCliente(Long idCliente, String string);

	CantidadLibros buscarCantidadLibrosPorId(Long idCantidadLibros);

	Long subtotalDeTodosLosLibros(List<CantidadLibros> librosPedidos);

	List<CantidadLibros> listarLibrosComprados(Long pedidoId);

	

}
