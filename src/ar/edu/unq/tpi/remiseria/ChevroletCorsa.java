package ar.edu.unq.tpi.remiseria;

public abstract class ChevroletCorsa implements Vehiculo {

	private Tonalidad color;
	
	public ChevroletCorsa(Tonalidad color) {
		super();
		this.color = color;
	}

	@Override
	public int getCapacidad() { return 4; }

	@Override
	public int getPeso() { return 1300; }

	@Override
	public Tonalidad getColor() { return this.color; }
	public void setColor(Tonalidad unColor) { this.color = unColor; }	

}
