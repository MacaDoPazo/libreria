package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado;
//	@ManyToOne(cascade = CascadeType.ALL)
	private Long cliente;
	@ManyToOne(cascade = CascadeType.ALL)
	private Localidad localidad;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy= "pedido")
	private List <CantidadLibros> cantidadLibros;
	@OneToOne
	private Venta venta;
	

	public List<CantidadLibros> getCantidadLibros() {
		return cantidadLibros;
	}
	public void setCantidadLibros(List<CantidadLibros> cantidadLibros) {
		this.cantidadLibros = cantidadLibros;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
