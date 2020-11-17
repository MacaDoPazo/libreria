package ar.edu.unlam.tallerweb1.persistencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Venta;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidadImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioVentaImpl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
public class VentasTest extends SpringTest {

	@Test
	@Transactional @Rollback
	public void verificarUnaEntregaAtrasada()
	{
		Localidad localidad = new Localidad();
				localidad.setNombre("Merlo");
				localidad.setPrecio(300L);
				localidad.setDiasAEntregar(5);
				ServicioLocalidadImpl servicioLocalidad = new ServicioLocalidadImpl();
				Calendar c = Calendar.getInstance();
				 c.add(Calendar.DATE, -1);
				 Date fechaHarcodeada = c.getTime();
				Date fecha = servicioLocalidad.calcularTiempoDeEntrega(localidad);
				Venta venta = new Venta();
				venta.setMontoTotal(3000L);
				Pedido pedido = mock(Pedido.class);
				when(pedido.getFechaEntrega()).thenReturn(fechaHarcodeada);
				pedido.setFechaEntrega(fecha);
				pedido.setLocalidad(localidad);
				pedido.setVenta(venta);
				venta.setPedido(pedido);
				List<Venta> lista = new ArrayList<Venta>();
				lista.add(venta);
				ServicioVentaImpl servicioVenta = new ServicioVentaImpl();
				List<Venta> listaSinEntregar = servicioVenta.listarVentasSinEntregarATiempo(lista);
				assertNotNull(listaSinEntregar);
	}
}
