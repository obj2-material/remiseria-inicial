package ar.edu.unq.tpi.remiseria.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import ar.edu.unq.tpi.remiseria.AutoEspecifico;
import ar.edu.unq.tpi.remiseria.AutoStandardAGas;
import ar.edu.unq.tpi.remiseria.ChevroletCorsaGasolero;
import ar.edu.unq.tpi.remiseria.ChevroletCorsaNaftero;
import ar.edu.unq.tpi.remiseria.Tonalidad;
import ar.edu.unq.tpi.remiseria.Vehiculo;

public class JuegosConColecciones {

	@Test
	public void testColeccionDeVehiculos() {
		Set<Vehiculo> misAutitos = new HashSet<>();

		Vehiculo corsa1 = new ChevroletCorsaNaftero(Tonalidad.ROJO);
		AutoEspecifico autoSport = new AutoEspecifico(5, 180, 950, Tonalidad.NEGRO);
		misAutitos.add(corsa1);
		misAutitos.add(new ChevroletCorsaGasolero(Tonalidad.VERDE));
		misAutitos.add(new AutoStandardAGas(false));
		misAutitos.add(autoSport);
		
		// cosas que se pueden hacer sin "saltar" al Stream
		assertEquals(4, misAutitos.size()); 			// tamaño
		assertTrue(misAutitos.contains(corsa1));		// si tiene o no un elemento
		
		
		// cosas con Stream
		
		// Caso 1: Filter
		// ********************************
		
		// los autos rapidos son estos
		Set<Vehiculo> autosRapidosQueTieneQueDar = new HashSet<>();
		autosRapidosQueTieneQueDar.add(corsa1);
		autosRapidosQueTieneQueDar.add(autoSport);
		
		// en Wollok es asi de facil
		// misAutitos.filter(veh -> veh.getVelocidadMaxima() >= 145);
		// en Java hay que escribir mas ...
		Set<Vehiculo> autosRapidos;
		
		// "a la Java 8"
		autosRapidos = misAutitos
			.stream()                       // convierto de coleccion a Stream
			.filter(veh -> veh.getVelocidadMaxima() >= 145)  // hago la operacion con Stream
			.collect(Collectors.toSet());   // vuelvo a transformar, de Stream a coleccion
		assertEquals(autosRapidosQueTieneQueDar, autosRapidos);
		
		// "a la Java 7"
		autosRapidos = new HashSet<>();
		for (Vehiculo veh : misAutitos) {
			if (veh.getVelocidadMaxima() >= 145) {
				autosRapidos.add(veh);
			}
		}
		assertEquals(autosRapidosQueTieneQueDar, autosRapidos);
		
		// con listas
//		List<Vehiculo> autitosListados = new ArrayList<>(misAutitos);
//		List<Vehiculo> autosRapidosListados = autitosListados
//				.stream()                       // convierto de coleccion a Stream
//				.filter(veh -> veh.getVelocidadMaxima() >= 145)  // hago la operacion con Stream
//				.collect(Collectors.toList());   // vuelvo a transformar, de Stream a coleccion
		
		

		// Caso 2: sum
		// ********************************
		
		// otro desafio: cantidad total de pasajeros
		// en Wollok: dos formas
		//   1. misAutitos.sum({veh => veh.getCapacidad()})          en Java no esta 
		//   2. misAutitos.map({veh => veh.getCapacidad()}).sum()    en Java si esta
		//   no anda  misAutitos.sum()
		
		int capacidadTotal;
		
		// a la Java 8
		capacidadTotal = misAutitos.stream()
				.mapToInt(veh -> veh.getCapacidad()).sum();
		assertEquals(17, capacidadTotal);
		
		// a la Java 7
		capacidadTotal = 0;
		for (Vehiculo veh : misAutitos) {
			capacidadTotal += veh.getCapacidad();
		}
		assertEquals(17, capacidadTotal);
		
		
		// Caso 3: all
		// ********************************
		// en Wollok: misAutitos.all({veh => veh.getCapacidad() >= 3})
		
		boolean todosGrandes;
		
		// a la Java 8
		todosGrandes = misAutitos.stream()
				.allMatch(veh -> veh.getCapacidad() >= 3);
		assertTrue(todosGrandes);
		
		// a la Java 7
		todosGrandes = true;
		for (Vehiculo veh : misAutitos) {
			if (veh.getCapacidad() < 3) {
				todosGrandes = false;
			}
		}
		assertTrue(todosGrandes);

		
		
		// adicional a pedido de Valeria
		Set<AutoStandardAGas>aGas = new HashSet<>();
		aGas.add(new AutoStandardAGas(true));
		Set<AutoStandardAGas> conTanque = aGas.stream()
				.filter(veh -> !veh.isConTanqueAdicional())
				.collect(Collectors.toSet());
		assertEquals(0, conTanque.size());
	}
	
	
	/**
	 * De yapa: un ejemplo de casteo numerico
	 */
	public void testCasteoNumerico() {
		double equis = 2.0;
		int ygriega = (int) equis;
		assertEquals(2, ygriega);
	}

}













