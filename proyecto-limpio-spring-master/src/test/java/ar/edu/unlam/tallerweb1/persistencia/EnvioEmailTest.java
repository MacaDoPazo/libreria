package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.servicios.ServicioEmail;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmailImpl;
public class EnvioEmailTest {

	@Inject
	private ServicioEmail servicioEmail;
	
	
	private ServicioEmailImpl servicio;
	
	@Test
	public void enviar()throws Exception {
			/*this.servicio=new ServicioEmailImpl();
			String envio=this.servicio.enviarEmail("nahuelpierotti@gmail.com", "We Miss U", "<html><h3>Te extrañamos</h3><br><p>Prueba Envio Email</p></html>"); 
			*/
			String envio=servicioEmail.enviarEmail("nahuelpierotti@gmail.com", "We Miss U", "<html><h3>Te extrañamos</h3><br><p>Prueba Envio Email</p></html>");
			assertThat(envio).isEqualTo("ok");

	}
	
	public ServicioEmail getServicioEmail() {
		return servicioEmail;
	}
	public void setServicioEmail(ServicioEmail servicioEmail) {
		this.servicioEmail = servicioEmail;
	}
	public ServicioEmailImpl getServicio() {
		return servicio;
	}
	public void setServicio(ServicioEmailImpl servicio) {
		this.servicio = servicio;
	}
	
}
