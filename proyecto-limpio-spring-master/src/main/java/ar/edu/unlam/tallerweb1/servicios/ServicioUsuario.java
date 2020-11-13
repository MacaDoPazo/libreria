package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Long guardarUsuario(Usuario usuario);
	Usuario consultarUsuario(Usuario usuario);
	Usuario consultarUsuarioPorId(Long id);
	void actualizarUsuario(Usuario usuario);
	ArrayList<Usuario> consultarUsuarios();
	void teExtraniamos() throws Exception;
}
