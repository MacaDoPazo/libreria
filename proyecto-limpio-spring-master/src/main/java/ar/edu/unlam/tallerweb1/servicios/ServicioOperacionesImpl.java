package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioOperacionesImpl implements ServicioOperaciones {

	@Override
	public Integer sumar(Integer num1, Integer num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}

	@Override
	public Integer restar(Integer num1, Integer num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}

	@Override
	public Double multiplicar(Double num1, Double num2) {
		// TODO Auto-generated method stub
		return num1*num2;
	}

	@Override

	 public Double dividir(Double num1, Double num2) throws Exception {

	 if(num2.equals(0.0)) {

	 throw new Exception("No se puede dividir por cero");

	 }

	 return num1/num2;

	 }

}
