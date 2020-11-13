package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.servicios.ServicioEmail;
public class EnvioEmailTest {

	private ServicioEmail servicioEmail;
	
	@Test
	public void enviar()throws Exception {

			String envio=servicioEmail.enviarEmail("npierotti@alumno.unlam.edu.ar", "We Miss U", "<html><h3>Te extrañamos</h3><br><p>Prueba Envio Email</p></html>"); 
			assertThat(envio).isEqualTo("ok");

	}
	
	
	
}
