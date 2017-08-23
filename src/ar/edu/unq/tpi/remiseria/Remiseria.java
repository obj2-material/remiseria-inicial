package ar.edu.unq.tpi.remiseria;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Remiseria {
	private Collection<Vehiculo> flota = new HashSet<>();
	
	public void agregarAFlota(Vehiculo veh) { flota.add(veh); }
	
	public void quitarDeFlota(Vehiculo veh) { flota.remove(veh); }

	/**
	 * Indica si esta remiseria es o no recomendable 
	 */
	public boolean esRecomendable() {
		return (this.flota.size() >= 3) && 
				this.flota.stream().allMatch(veh -> veh.getVelocidadMaxima() >= 100);
	}

	/**
	 * Devuelve la cantidad total de pasajeros que puede transportar esta remiseria
	 * viajando a la velocidad indicada. 
	 */
	public int capacidadTotalYendoA(int velocidad) {
		return this.vehiculosQuePuedenIrA(velocidad).stream()
				.mapToInt(veh -> veh.getCapacidad()).sum();
	}
	
	/**
	 * Devuelve la cantidad total de pasajeros que puede transportar esta remiseria
	 * viajando a la velocidad indicada - implementacion al estilo Java 7. 
	 */
	public int capacidadTotalYendoA_Java7(int velocidad) {
		int capacidadTotal = 0;
		for (Vehiculo vehiculo : this.vehiculosQuePuedenIrA_Java7(velocidad)) {
			capacidadTotal += vehiculo.getCapacidad();
		}
		return capacidadTotal;
	}

	private Collection<Vehiculo> vehiculosQuePuedenIrA(int velocidad) {
		return this.flota.stream()
				.filter(veh -> veh.getVelocidadMaxima() >= velocidad)
				.collect(Collectors.toList());
	}

	private Collection<Vehiculo> vehiculosQuePuedenIrA_Java7(int velocidad) {
		Collection<Vehiculo> losRapiditos = new HashSet<>();
		for (Vehiculo vehiculo : this.flota) {
			if (vehiculo.getVelocidadMaxima() >= velocidad) {
				losRapiditos.add(vehiculo);
			}
		}
		return losRapiditos;
	}
	
	/**
	 * Devuelve el color del auto más rápido de esta remisería.
	 */
	public Color colorDelAutoMasRapido() {
		Vehiculo autoMasRapido = this.getAutoMasRapido();
		return autoMasRapido.getColor();
	}

	/**
	 * Devuelve el auto más rápido de esta remisería.
	 */
	protected Vehiculo getAutoMasRapido() {
		return this.flota.stream().max(Comparator.comparing(Vehiculo::getVelocidadMaxima)).get();
	}
	
	/**
	 * Devuelve el auto más rápido de esta remisería.
	 */
	protected Vehiculo getAutoMasRapido_Java7() {
		Vehiculo autoMasRapido = null;
		for (Vehiculo vehiculo : this.flota) {
			if ((autoMasRapido == null) 
					|| (autoMasRapido.getVelocidadMaxima() < vehiculo.getVelocidadMaxima())) 
			{
				autoMasRapido = vehiculo;
			}
		}
		return autoMasRapido;
	}
}


















