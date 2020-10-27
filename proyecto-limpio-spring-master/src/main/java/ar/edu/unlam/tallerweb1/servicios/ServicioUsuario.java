package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Long guardarUsuario(Usuario usuario);
	public Usuario consultarUsuario(Usuario usuario);
	public Usuario consultarUsuarioPorId(Long id);

}
