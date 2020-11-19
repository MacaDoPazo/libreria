package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioImpl;

import static org.mockito.Mockito.*;


public class ClienteNoFrecuenteTest {

	
	@Test
	public void DetectarClienteNoFrecuente() {
		
		Usuario u1=mock(Usuario.class);
		Usuario u2=mock(Usuario.class);
		String hoy="2020-11-18";
		ServicioUsuarioImpl servicioUsuario=mock(ServicioUsuarioImpl.class);
		String fechaUltimoLogin="2020-10-01";
		String fechaUltimoRecordatorio="2020-11-10";
		u1.setFecha_ultimo_login(servicioUsuario.transformarFechaDeStringADate(fechaUltimoLogin));
		u1.setFecha_ultimo_recordatorio(servicioUsuario.transformarFechaDeStringADate(fechaUltimoRecordatorio));
		u1.setRol("Cliente");
		u2.setFecha_ultimo_login(servicioUsuario.transformarFechaDeStringADate(hoy));
		u2.setFecha_ultimo_recordatorio(servicioUsuario.transformarFechaDeStringADate(hoy));
		u2.setRol("Cliente");
		
		when(servicioUsuario.esUsuarioNoFrecuente(u1)).thenReturn(true);
		when(servicioUsuario.esUsuarioNoFrecuente(u2)).thenReturn(false);
	}
}
