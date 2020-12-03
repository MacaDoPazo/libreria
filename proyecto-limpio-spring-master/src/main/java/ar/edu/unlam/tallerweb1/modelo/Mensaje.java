package ar.edu.unlam.tallerweb1.modelo;

public class Mensaje {

	private String asunto;
	private String cuerpo;
	private boolean leido;
	
	public Mensaje() {}
	
	public Mensaje(String asunto, String cuerpo, boolean leido) {
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
}
