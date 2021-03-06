package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Date;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Long guardarUsuario(Usuario usuario);
	Usuario consultarUsuario(Usuario usuario);
	Usuario consultarUsuarioPorId(Long id);
	void actualizarUsuario(Usuario usuario);
	ArrayList<Usuario> consultarUsuarios();
	ArrayList<Usuario> consultarUsuariosNoFrecuentes();
	String enviarEmailUsuariosNoFrecuentes(ArrayList<Usuario> lista_usuarios) throws Exception;
	Integer calcularEdad(Usuario usuario);
	Date transformarFechaDeStringADate(String fechaComoString); // formato yyyy-MM-dd
	Boolean esUsuarioNoFrecuente(Usuario usuario);
	String hardcodearCadena(String cadena);
	ArrayList<Mensaje> obtenerMensajesUsuario(Long id);
}
