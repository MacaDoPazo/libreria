package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface ServicioPedido {
	
	public Long guardarPedido(Pedido pedido);
	public Pedido consultarPedidoPorId(Long id);
	public Pedido buscarPedidoArmando(Long idCliente, String armando);
	public void actualizarEstadoDelPedido(Long idPedido, String estadoActualizado);
	public void actualizarPedido(Pedido pedido);
	

}
