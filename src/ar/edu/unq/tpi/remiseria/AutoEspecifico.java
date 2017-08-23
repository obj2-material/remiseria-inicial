package ar.edu.unq.tpi.remiseria;

public class AutoEspecifico implements Vehiculo {

	private int capacidad;
	private int velocidadMaxima;
	private int peso;
	private Color color;

	
	public AutoEspecifico(int capacidad, int velocidadMaxima, int peso, Color color) {
		super();
		this.capacidad = capacidad;
		this.velocidadMaxima = velocidadMaxima;
		this.peso = peso;
		this.color = color;
	}
	
	@Override
	public int getCapacidad() {return this.capacidad; }
	public void setCapacidad(int cuantos) {this.capacidad = cuantos; }

	@Override
	public int getVelocidadMaxima() {return this.velocidadMaxima; }
	public void setVelocidadMaxima(int velocidad) {this.velocidadMaxima = velocidad; }

	@Override
	public int getPeso() { return this.peso; }
	public void setPeso(int elPeso) { this.peso = elPeso; }

	@Override
	public Color getColor() { return this.color; }
	public void setColor(Color unColor) { this.color = unColor; }

}
