package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long paginas;
	private Long precio;
	private Integer megusta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Autor autor;
	@ManyToOne(cascade = CascadeType.ALL)
	private Stock stock;
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getPaginas() {
		return paginas;
	}
	public void setPaginas(Long paginas) {
		this.paginas = paginas;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Stock getStock() {
		return stock;
	}
	
	public Integer getMegusta() {
		return megusta;
	}
	public void setMegusta(Integer megusta) {
		this.megusta = megusta;
	}
	
	
}
