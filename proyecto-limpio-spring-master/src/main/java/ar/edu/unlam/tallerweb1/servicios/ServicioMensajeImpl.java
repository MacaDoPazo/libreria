package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensaje;
@Service
public class ServicioMensajeImpl implements ServicioMensaje {

	@Inject
	private RepositorioMensaje repositorioMensaje;
	
	@Override
	public ArrayList<Mensaje> consultarMensajesUsuario(Long id) {
		ArrayList<Mensaje> lista=repositorioMensaje.obtenerMensajesCliente(id);
		if(lista==null) {
			lista=new ArrayList<Mensaje>();
		}
		return lista;
	}

	@Override
	public void actualizarMensaje(Mensaje mensaje) {
		repositorioMensaje.actualizarMensaje(mensaje);
		
	}

	@Override
	public int consultarMensajesNoLeidosUsuario(ArrayList<Mensaje> lista) {
		Iterator<Mensaje> i=lista.iterator();
		int cant_sin_leer=0;
		
		while(i.hasNext()) {
			Mensaje m=i.next();
			if(!m.isLeido()) {
				cant_sin_leer++;
			}
		}
		return cant_sin_leer;
	}

	@Override
	public void actualizarListaMensajes(ArrayList<Mensaje> lista) {
		Iterator <Mensaje> i=lista.iterator();
		while(i.hasNext()) {
			Mensaje msg=i.next();
			if(msg.isLeido()==true) {
				actualizarMensaje(msg);
			}
			
		}
		
	}
	
	

}
