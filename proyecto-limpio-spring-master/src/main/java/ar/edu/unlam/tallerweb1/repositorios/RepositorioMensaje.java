package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;

public interface RepositorioMensaje {

	Long guardarMensaje(Mensaje mensaje);
	ArrayList<Mensaje> obtenerMensajesCliente(Long id);
	void actualizarMensaje(Mensaje mensaje);
}
