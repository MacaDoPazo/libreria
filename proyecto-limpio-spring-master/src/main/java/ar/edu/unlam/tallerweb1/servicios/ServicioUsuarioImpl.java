package ar.edu.unlam.tallerweb1.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import java.util.Iterator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;
		
	@Inject 
	private ServicioEmail servicioEmail;
	
	@Inject 
	private ServicioMensaje servicioMensaje;
	
	@Override
	public Long guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		String passwordHardcodeada=hardcodearCadena(usuario.getPassword());
		usuario.setPassword(passwordHardcodeada);
		return repositorioUsuario.guardarUsuario(usuario);
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		String passwordHardcodeada=hardcodearCadena(usuario.getPassword());
		usuario.setPassword(passwordHardcodeada);
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
		ArrayList<Usuario>lista=consultarUsuarios();
		ArrayList<Usuario>no_frecuentes=new ArrayList<Usuario>();
		Iterator<Usuario> i= lista.iterator();

		while(i.hasNext()) {
			Usuario u=i.next();
			if(esUsuarioNoFrecuente(u)) {
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

	@Override
	public Date transformarFechaDeStringADate(String fechaComoString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fechaComoString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getTime();
	}

	@Override
	public Boolean esUsuarioNoFrecuente(Usuario usuario) {
		
		Boolean esNoFrecuente=false;
		Date hoy=Calendar.getInstance().getTime();
		int dias_sin_ingreso=0;
		if(usuario.getFecha_ultimo_login()!=null) {
			dias_sin_ingreso=(int) ((usuario.getFecha_ultimo_login().getTime()-
				hoy.getTime())/86400000)*(-1);
			
		}
		int dias_ultimo_recordatorio=0;
		if(usuario.getFecha_ultimo_recordatorio()!=null) {
			dias_ultimo_recordatorio=(int) ((usuario.getFecha_ultimo_recordatorio().getTime()-
				hoy.getTime())/86400000)*(-1);
		}
		
		if(dias_sin_ingreso > 2 && dias_ultimo_recordatorio > 4 
				&& usuario.getRol().equals("Cliente")) {
			esNoFrecuente=true;

		}
		
		return esNoFrecuente;
	}

	@Override
	public String hardcodearCadena(String cadena) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(cadena);	
	}

	@Override
	public ArrayList<Mensaje> obtenerMensajesUsuario(Long id) {
		ArrayList<Mensaje> lista_mensajes=servicioMensaje.consultarMensajesUsuario(id);
		
		return lista_mensajes;
	}
	
	

}
