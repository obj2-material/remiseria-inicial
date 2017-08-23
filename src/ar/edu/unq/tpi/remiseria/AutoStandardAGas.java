package ar.edu.unq.tpi.remiseria;

public class AutoStandardAGas implements Vehiculo {
	private boolean tieneTanqueAdicional;
	
	@Override
	public int getCapacidad() {
		return this.tieneTanqueAdicional ? 3 : 4;
	}

	@Override
	public int getVelocidadMaxima() {
		return this.tieneTanqueAdicional ? 110 : 120;
	}

	@Override
	public int getPeso() {
		return this.tieneTanqueAdicional ? 1350 : 1200;
	}

	@Override
	public Color getColor() { return Color.AZUL; }

}
