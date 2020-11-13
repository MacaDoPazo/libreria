package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioEmail {
	
	public String enviarEmail(String to, String subject, String body)throws Exception;
	
	
}
