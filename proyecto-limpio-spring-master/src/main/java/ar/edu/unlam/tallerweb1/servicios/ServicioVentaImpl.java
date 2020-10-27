package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVenta;

@Service
@Transactional
public class ServicioVentaImpl implements ServicioVenta {
	@Inject
	private RepositorioVenta repositorioVenta;

	@Override
	public void guardarVenta(Venta venta) {
		repositorioVenta.guardarVenta(venta);
	}

	@Override
	public Venta consultarVentaPorId(Long id) {
		Venta venta= repositorioVenta.consultarVentaPorId(id);
		return venta;
	}

	
	@Override
	public List<Venta> listarPedidosFacturados() {
		// TODO Auto-generated method stub
		return repositorioVenta.listarPedidosFacturados();
	}

	@Override
	public List<Venta> listarVentasAlCliente(Long idCliente) {
		return repositorioVenta.listarVentasAlCliente(idCliente);
	}

}
