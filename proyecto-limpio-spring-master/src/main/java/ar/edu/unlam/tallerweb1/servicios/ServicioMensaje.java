package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;

public interface ServicioMensaje {

	ArrayList<Mensaje> consultarMensajesUsuario(Long id);
	int consultarMensajesNoLeidosUsuario(ArrayList<Mensaje> lista);
	void actualizarMensaje(Mensaje mensaje);
	void actualizarListaMensajes(ArrayList<Mensaje> lista);
}
