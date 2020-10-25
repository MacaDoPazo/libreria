package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCantLibros;
@Service
@Transactional
public class ServicioCantLibrosImpl implements ServicioCantLibros {

	@Inject
	private RepositorioCantLibros respositorioCantLibros;

	
	public Long guardarCantidadLibros(CantidadLibros cantidadLibros) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.guardarCantidadLibros(cantidadLibros);
		
	}


	
	@Override
	public CantidadLibros buscarLibroEnPedidoArmado(Pedido pedidoArmando, Libro libroPedir) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.buscarLibroEnPedidoArmado(pedidoArmando, libroPedir);
	}



	@Override
	public void actualizarCantidadLibros(CantidadLibros libroEncontrado) {
		// TODO Auto-generated method stub
		respositorioCantLibros.actualizarCantidadLibros(libroEncontrado);
	}



	@Override
	public List<CantidadLibros> listarLibrosPedidoDelCliente(Long idCliente, String string) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.listarLibrosPedidoDelCliente(idCliente, string);
	}



	@Override
	public CantidadLibros buscarCantidadLibrosPorId(Long idCantidadLibros) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.buscarCantidadLibrosPorId(idCantidadLibros);
	}



	@Override
	public Long subtotalDeTodosLosLibros(List<CantidadLibros> librosPedidos) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.subtotalDeTodosLosLibros(librosPedidos);
	}



	@Override
	public List<CantidadLibros> listarLibrosComprados(Long pedidoId) {
		// TODO Auto-generated method stub
		return respositorioCantLibros.listarLibrosComprados(pedidoId);
	}

}
