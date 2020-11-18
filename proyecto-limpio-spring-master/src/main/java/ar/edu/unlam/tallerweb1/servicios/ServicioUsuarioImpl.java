package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import java.util.Iterator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Inject 
	private ServicioEmail servicioEmail;
	
	@Override
	public Long guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioUsuario.guardarUsuario(usuario);
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioUsuario.consultarUsuario(usuario);
	}

	@Override
	public Usuario consultarUsuarioPorId(Long id) {
		Usuario usuario = repositorioUsuario.consultarUsuarioPorId(id);
		return usuario;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		repositorioUsuario.actualizarUsuario(usuario);
	}

	@Override
	public ArrayList<Usuario> consultarUsuarios() {
		ArrayList<Usuario>lista=repositorioUsuario.consultarUsuarios();
		return lista;
	}

	@Override
	public ArrayList<Usuario> consultarUsuariosNoFrecuentes(){
		Date hoy=Calendar.getInstance().getTime();
		ArrayList<Usuario>lista=consultarUsuarios();
		ArrayList<Usuario>no_frecuentes=new ArrayList<Usuario>();
		Iterator<Usuario> i= lista.iterator();

		while(i.hasNext()) {
			Usuario u=i.next();
			int dias_sin_ingreso=0;
			if(u.getFecha_ultimo_login()!=null) {
				dias_sin_ingreso=(int) ((u.getFecha_ultimo_login().getTime()-
					hoy.getTime())/86400000)*(-1);
				
			}
			int dias_ultimo_recordatorio=0;
			if(u.getFecha_ultimo_recordatorio()!=null) {
				dias_ultimo_recordatorio=(int) ((u.getFecha_ultimo_recordatorio().getTime()-
					hoy.getTime())/86400000)*(-1);
			}
			
			if(dias_sin_ingreso > 2 && dias_ultimo_recordatorio > 4 
					&& u.getRol().equals("Cliente")) {
				no_frecuentes.add(u);

			}
		}
		return no_frecuentes;

	}
	
	

	@Override
	public Integer calcularEdad(Usuario usuario) {
		Date fechaActual = Calendar.getInstance().getTime();
		Date fechaNacimiento = usuario.getFechaNac();
		
		Integer edad = fechaActual.getYear() - fechaNacimiento.getYear();
		
		return edad;
	}

	@Override
	public String enviarEmailUsuariosNoFrecuentes(ArrayList<Usuario> lista_usuarios) throws Exception{
		String ret="ok";
		String subject="WE MISS U";
		String body="Hace mucho no te vemos ";
		Date hoy=Calendar.getInstance().getTime();
		Iterator<Usuario> i= lista_usuarios.iterator();
		while(i.hasNext()) {
			Usuario u=(Usuario)i.next();
			body+=u.getNombre()+", y creemos que nuestros nuevos titulos pueden interesarte.";
			ret=servicioEmail.enviarEmail(u.getEmail(), subject, body);
			u.setFecha_ultimo_recordatorio(hoy);
			actualizarUsuario(u);
			
		}
		
		return ret;
	}
	
	
	

}
