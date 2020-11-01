package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Long guardarUsuario(Usuario usuario);
	Usuario consultarUsuario(Usuario usuario);
	Usuario consultarUsuarioPorId(Long id);

}
