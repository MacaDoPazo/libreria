package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);

	Long guardarUsuario(Usuario usuario);
	
	Usuario consultarUsuarioPorId(Long id);

	void actualizarUsuario(Usuario usuario);

	ArrayList<Usuario> consultarUsuarios();


}
