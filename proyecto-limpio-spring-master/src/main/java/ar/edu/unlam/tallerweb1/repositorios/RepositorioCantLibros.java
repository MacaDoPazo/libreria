package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioCantLibros {

	Long guardarCantidadLibros(CantidadLibros cantidadLibros);

	List<CantidadLibros> listarLibrosPedidoDelCliente(Long idCliente,String armado);

	CantidadLibros buscarLibroEnPedidoArmado(Pedido pedidoArmando, Libro libroPedir);

	void actualizarCantidadLibros(CantidadLibros libroEncontrado);

	CantidadLibros buscarCantidadLibrosPorId(Long idCantidadLibros);

	Long subtotalDeTodosLosLibros(List<CantidadLibros> librosPedidos);

}
