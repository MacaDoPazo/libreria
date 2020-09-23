package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioOperaciones {

	Integer sumar(Integer num1,Integer num2);
	Integer restar(Integer num1,Integer num2);
	Double multiplicar(Double num1,Double num2);
	Double dividir(Double num1, Double num2) throws Exception;
}
