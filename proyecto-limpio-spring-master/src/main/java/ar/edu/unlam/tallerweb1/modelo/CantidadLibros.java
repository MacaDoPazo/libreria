package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class CantidadLibros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cantidad;
	//@Transient
	private Long precioTotal;
	@ManyToOne(cascade = CascadeType.ALL)
	private Libro libro;
	@ManyToOne(cascade = CascadeType.ALL)
	private Pedido pedido;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	public Long calcularPrecioTotal() {
		return this.libro.getPrecio()*this.cantidad;
	}
	
	public Long getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Long precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
