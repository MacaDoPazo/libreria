package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Venta;

public interface RepositorioVenta {
	
	public void guardarVenta(Venta venta);
	public Venta consultarVentaPorId(Long id);

}
