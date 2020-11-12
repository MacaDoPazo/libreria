package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioPedido {
	
	public void guardarPedido(Pedido pedido);
	public Pedido consultarPedidoPorId(Long id);

}
