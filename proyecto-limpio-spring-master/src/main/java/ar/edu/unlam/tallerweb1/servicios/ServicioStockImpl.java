package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.repositorios.LibroDao;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioStock;
@Service
@Transactional
public class ServicioStockImpl implements ServicioStock {

	@Inject
	private RepositorioStock respositorioStock;
	
	@Inject
	private LibroDao repositorioLibro;

	@Override
	public Long guardarStock(Stock stock) {
		// TODO Auto-generated method stub
		return respositorioStock.guardarStock(stock);
	}

	@Override
	public List<CantidadLibros> descontarStock(List<CantidadLibros> lista) {
		
		Libro libro;
		for(CantidadLibros cl : lista) {
			
			libro= cl.getLibro();
			libro.getStock().setCantidad(libro.getStock().getCantidad()-cl.getCantidad());
			
			repositorioLibro.actualizarLibro(libro);
		}
		
			
			
		return lista;
	}

}
