package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

@Service
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	@Inject
	private RepositorioPedido repositorioPedido;

	@Override
	public Long guardarPedido(Pedido pedido) {
		return repositorioPedido.guardarPedido(pedido);
	}

	@Override
	public Pedido consultarPedidoPorId(Long id) {
		Pedido pedido = repositorioPedido.consultarPedidoPorId(id);
		return pedido;
	}

	@Override
	public Pedido buscarPedidoArmando(Long idCliente, String string) {
		// TODO Auto-generated method stub
		return repositorioPedido.buscarPedidoArmando(idCliente, string);
	}

	@Override
	public void actualizarEstadoDelPedido(Long idPedido, String estadoActualizado) {
		repositorioPedido.actualizarEstadoDelPedido(idPedido, estadoActualizado);
		
	}

}
