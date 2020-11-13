package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.hsqldb.lib.Iterator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;

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
	public void teExtraniamos() throws Exception{
		Date hoy=Calendar.getInstance().getTime();
		ArrayList<Usuario>lista=consultarUsuarios();
		Iterator i=(Iterator) lista.iterator();
		ServicioEmailImpl servicio_email=new ServicioEmailImpl();
		String body="<html><h3>Te Extrañamos</h3><br>";
		while(i.hasNext()) {
			Usuario u=(Usuario)i.next();
			if(u.getFecha_ultimo_login().compareTo(hoy)>2) {
				body+="<p>No te vemos hace tiempo <strong>"+u.getNombre()+"</strong>"+
					" y creemos que tenemos nuevos titulos que te pueden interesar.</p><br>"+
					"</html>";	
				servicio_email.enviarEmail(u.getEmail(), "WE MISS U", body);
			}
		}

	}

}
