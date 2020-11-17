package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Venta;

public interface ServicioVenta {
	public void guardarVenta(Venta venta);
	public Venta consultarVentaPorId(Long id);
	public List<Venta> listarPedidosFacturados();
	public List<Venta> listarVentasAlCliente(Long idCliente);
	public List<Venta> listarVentasSinEntregarATiempo(List<Venta> listadoVentasRealizadasAlCliente);
	
}
