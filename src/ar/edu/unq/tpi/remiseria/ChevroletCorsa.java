package ar.edu.unq.tpi.remiseria;

public abstract class ChevroletCorsa implements Vehiculo {

	private Color color;
	
	public ChevroletCorsa(Color color) {
		super();
		this.color = color;
	}

	@Override
	public int getCapacidad() { return 4; }

	@Override
	public int getPeso() { return 1300; }

	@Override
	public Color getColor() { return this.color; }
	public void setColor(Color unColor) { this.color = unColor; }	

}
