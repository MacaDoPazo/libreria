package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Stock;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioStock;
@Service
@Transactional
public class ServicioStockImpl implements ServicioStock {

	@Inject
	private RepositorioStock respositorioStock;

	@Override
	public Long guardarStock(Stock stock) {
		// TODO Auto-generated method stub
		return respositorioStock.guardarStock(stock);
	}

}
