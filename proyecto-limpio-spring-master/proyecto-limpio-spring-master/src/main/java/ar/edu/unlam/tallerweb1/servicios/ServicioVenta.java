package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Venta;

public interface ServicioVenta {
	public void guardarVenta(Venta venta);
	public Venta consultarVentaPorId(Long id);
}
