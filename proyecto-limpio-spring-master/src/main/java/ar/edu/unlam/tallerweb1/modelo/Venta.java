package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
//	private String formaDePago;
	private Long idCliente;
	private Long montoTotal;
	private Integer localidadEnvio;
	private String nombreTitularTarjeta;
	private String apellidoTitularTarjeta;
	private Long numeroTarjeta;
	private String fechaCaducidadTarjeta;
	private Integer codigoSeguridadTarjeta;
	
	@OneToOne
	private Pedido pedido;
	
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Long montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Integer getLocalidadEnvio() {
		return localidadEnvio;
	}
	public void setLocalidadEnvio(Integer localidadEnvio) {
		this.localidadEnvio = localidadEnvio;
	}
	public String getNombreTitularTarjeta() {
		return nombreTitularTarjeta;
	}
	public void setNombreTitularTarjeta(String nombreTitularTarjeta) {
		this.nombreTitularTarjeta = nombreTitularTarjeta;
	}
	public String getApellidoTitularTarjeta() {
		return apellidoTitularTarjeta;
	}
	public void setApellidoTitularTarjeta(String apellidoTitularTarjeta) {
		this.apellidoTitularTarjeta = apellidoTitularTarjeta;
	}
	public Long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getFechaCaducidadTarjeta() {
		return fechaCaducidadTarjeta;
	}
	public void setFechaCaducidadTarjeta(String fechaCaducidadTarjeta) {
		this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
	}
	public Integer getCodigoSeguridadTarjeta() {
		return codigoSeguridadTarjeta;
	}
	public void setCodigoSeguridadTarjeta(Integer codigoSeguridadTarjeta) {
		this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
	}
	
	

//	public String getFormaDePago() {
//		return formaDePago;
//	}
//	public void setFormaDePago(String formaDePago) {
//		this.formaDePago = formaDePago;
//	}

	

}
