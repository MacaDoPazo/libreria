package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cliente;
	private String asunto;
	private String cuerpo;
	private boolean leido;
	private Date fecha_leido;
	
	
	public Mensaje() {}
	
	public Mensaje(Long cliente,String asunto, String cuerpo, boolean leido) {
		this.cliente=cliente;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.leido	= leido;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Date getFecha_leido() {
		return fecha_leido;
	}

	public void setFecha_leido(Date fecha_leido) {
		this.fecha_leido = fecha_leido;
	}
}
