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
	public void guardarPedido(Pedido pedido) {
		repositorioPedido.guardarPedido(pedido);
	}

	@Override
	public Pedido consultarPedidoPorId(Long id) {
		Pedido pedido = repositorioPedido.consultarPedidoPorId(id);
		return pedido;
	}

}
