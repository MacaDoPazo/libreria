package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioImpl;

public class UsuarioTest extends SpringTest{
	@Inject
	SessionFactory sesion;
	
	@Test
    @Transactional @Rollback
    public void testDeQueUnUsuarioSeRegistra() {
		ServicioUsuarioImpl servicioUsuario = new ServicioUsuarioImpl();
		Usuario usuario = new Usuario();
			usuario.setNombre("JUAN");
			usuario.setApellido("CITO");
			usuario.setSexo('m');
			usuario.setEmail("juan_cito@gmail.com");
			String fechaNac="1994-05-14";
			usuario.setFechaNac(servicioUsuario.transformarFechaDeStringADate(fechaNac));
			usuario.setPassword("1234");
			usuario.setRol("Cliente");
			Date hoy = Calendar.getInstance().getTime();
			usuario.setFecha_ultimo_login(hoy);
			Long idUsuarioRegistrado = (Long) sesion.getCurrentSession().save(usuario);
			
			 assertThat(idUsuarioRegistrado).isEqualTo(1L);

	}
    
		
	@Test
    @Transactional @Rollback
    public void testDeQueUnUsuarioEsMayorDeEdad() {
		ServicioUsuarioImpl servicioUsuario = new ServicioUsuarioImpl();
		
		Usuario usuario = new Usuario();
			Integer edadRequeridaParaSerMayorDeEdad = 18;
			String fechaNacDelusuario="1994-05-14";
			usuario.setFechaNac(servicioUsuario.transformarFechaDeStringADate(fechaNacDelusuario));
			
			Integer edad = servicioUsuario.calcularEdad(usuario);
			assertThat(edad).isGreaterThanOrEqualTo(edadRequeridaParaSerMayorDeEdad);

	}
	
	
	@Test
  @Transactional @Rollback
  public void testQueVerificaSiDosUsuariosTienenLaMismaEdad() {
	ServicioUsuarioImpl servicioUsuario = new ServicioUsuarioImpl();
		Usuario usuario1 = mock(Usuario.class);
			String fechaNacDelusuario1="1994-05-14";
			usuario1.setFechaNac(servicioUsuario.transformarFechaDeStringADate(fechaNacDelusuario1));
		Usuario usuario2 = mock(Usuario.class);
			String fechaNacDelusuario2="1990-05-14";
			usuario2.setFechaNac(servicioUsuario.transformarFechaDeStringADate(fechaNacDelusuario2));
		
			
		Date fechaActual = Calendar.getInstance().getTime();		
		when(usuario1.getFechaNac()).thenReturn(fechaActual);
		when(usuario2.getFechaNac()).thenReturn(fechaActual);
		
			
			assertThat(usuario1.getFechaNac()).isEqualTo(usuario2.getFechaNac());
				
	}
	
}
