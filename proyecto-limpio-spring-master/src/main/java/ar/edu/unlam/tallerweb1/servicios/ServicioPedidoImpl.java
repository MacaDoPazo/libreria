package ar.edu.unlam.tallerweb1.servicios;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.CantidadLibros;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

@Service
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	@Inject
	private RepositorioPedido repositorioPedido;

	@Inject 
	private RepositorioMensaje repositorioMensaje;
	
	@Inject 
	private ServicioEmail servicioEmail;
	
	@Inject 
	private ServicioUsuario servicioUsuario;
	
	@Override
	public Long guardarPedido(Pedido pedido) {
		return repositorioPedido.guardarPedido(pedido);
	}

	@Override
	public Pedido consultarPedidoPorId(Long id) {
		Pedido pedido = repositorioPedido.consultarPedidoPorId(id);
		return pedido;
	}

	@Override
	public Pedido buscarPedidoArmando(Long idCliente, String string) {
		// TODO Auto-generated method stub
		return repositorioPedido.buscarPedidoArmando(idCliente, string);
	}

	@Override
	public void actualizarEstadoDelPedido(Long idPedido, String estadoActualizado) {
		repositorioPedido.actualizarEstadoDelPedido(idPedido, estadoActualizado);
		if(estadoActualizado.equals("entregado")) {
			String cuerpo="Podes Reseñar Los siguientes Titulos:\n";
			Pedido pedido=consultarPedidoPorId(idPedido);
			Iterator<CantidadLibros> it_lib=pedido.getCantidadLibros().iterator();
			while(it_lib.hasNext()) {
				CantidadLibros cl=it_lib.next();
				cuerpo+="-"+cl.getLibro().getNombre()+" \n";
			}
			Mensaje m=new Mensaje(pedido.getCliente(),"Reseña Disponible",cuerpo,false);
			repositorioMensaje.guardarMensaje(m);
			Usuario cliente=servicioUsuario.consultarUsuarioPorId(pedido.getCliente());
			String ret="";
			try{
				ret=servicioEmail.enviarEmail(cliente.getEmail(), m.getAsunto(), m.getCuerpo());
			}catch (Exception e) {
				e.getMessage();
			}
			
		}
		
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		repositorioPedido.actualizarPedido(pedido);
		
	}

	public ServicioEmail getServicioEmail() {
		return servicioEmail;
	}

	public void setServicioEmail(ServicioEmail servicioEmail) {
		this.servicioEmail = servicioEmail;
	}

	public ServicioUsuario getServicioUsuario() {
		return servicioUsuario;
	}

	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}


}
