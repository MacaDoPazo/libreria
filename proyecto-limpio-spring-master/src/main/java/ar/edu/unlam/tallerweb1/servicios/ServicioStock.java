package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Stock;

public interface ServicioStock {

	Long guardarStock(Stock stock);
	
	List <CantidadLibros> descontarStock (List<CantidadLibros> lista);

}
