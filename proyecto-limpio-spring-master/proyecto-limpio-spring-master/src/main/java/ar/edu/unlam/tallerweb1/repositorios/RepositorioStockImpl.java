package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Stock;
@Repository
public class RepositorioStockImpl implements RepositorioStock {

	@Inject
	SessionFactory sesion;
	@Override
	public Long guardarStock(Stock stock) {
		// TODO Auto-generated method stub
		return (Long) sesion.getCurrentSession().save(stock);
	}

}
