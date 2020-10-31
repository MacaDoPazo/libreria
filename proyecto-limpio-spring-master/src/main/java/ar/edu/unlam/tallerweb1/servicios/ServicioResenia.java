package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Resenia;

public interface ServicioResenia {
	
	public void guardarResenia(Resenia resenia);
	public Resenia consultarReseniaPorId(Long id);
	public void eliminarReseniaPorId(Long idResenia);
	List<Resenia> listarResenias();

}
