package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmailImpl;
import static org.mockito.Mockito.*;


public class EnvioEmailTest {
	
	@Test
	public void enviar()throws Exception {
		ServicioEmailImpl servicioEmail=mock(ServicioEmailImpl.class);
		when(servicioEmail.
				enviarEmail("nahuelpierotti@gmail.com", "We Miss U", "Te extrañamos.")).
		thenReturn("ok");
		
	}
	
}
