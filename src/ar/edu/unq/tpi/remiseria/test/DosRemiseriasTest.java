package ar.edu.unq.tpi.remiseria.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unq.tpi.remiseria.AutoEspecifico;
import ar.edu.unq.tpi.remiseria.AutoStandardAGas;
import ar.edu.unq.tpi.remiseria.ChevroletCorsaNaftero;
import ar.edu.unq.tpi.remiseria.Remiseria;
import ar.edu.unq.tpi.remiseria.Tonalidad;
import ar.edu.unq.tpi.remiseria.Vehiculo;

public class DosRemiseriasTest {

	@Test
	public void testDosRemiserias() {
		Vehiculo cachito = new ChevroletCorsaNaftero(Tonalidad.ROJO);
		
		Remiseria laMejor = new Remiseria();
		laMejor.agregarAFlota(cachito);
		laMejor.agregarAFlota(new ChevroletCorsaNaftero(Tonalidad.NEGRO));
		laMejor.agregarAFlota(new ChevroletCorsaNaftero(Tonalidad.VERDE));
		laMejor.agregarAFlota(new AutoStandardAGas(true));
		laMejor.agregarAFlota(new AutoEspecifico(5, 160, 1200, Tonalidad.BEIGE));
		
		Remiseria laPeor = new Remiseria();
		laPeor.agregarAFlota(cachito);
		laPeor.agregarAFlota(new AutoStandardAGas(true));
		laPeor.agregarAFlota(new AutoStandardAGas(true));
		laPeor.agregarAFlota(new AutoStandardAGas(false));
		laPeor.agregarAFlota(new AutoEspecifico(5, 80, 4500, Tonalidad.BLANCO));
		
		assertEquals(6450, laMejor.pesoTotalFlota());
		assertTrue(laMejor.esRecomendable());
		assertEquals(17, laMejor.capacidadTotalYendoA(140));
		assertEquals(Tonalidad.BEIGE, laMejor.colorDelAutoMasRapido());

		assertEquals(9700, laPeor.pesoTotalFlota());
		assertFalse(laPeor.esRecomendable());
		assertEquals(4, laPeor.capacidadTotalYendoA(140));
		assertEquals(Tonalidad.ROJO, laPeor.colorDelAutoMasRapido());
}

}
