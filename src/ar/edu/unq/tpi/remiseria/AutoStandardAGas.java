package ar.edu.unq.tpi.remiseria;

public class AutoStandardAGas implements Vehiculo {
	private boolean tieneTanqueAdicional;
	
	
	public AutoStandardAGas(boolean tieneTanqueAdicional) {
		super();
		this.tieneTanqueAdicional = tieneTanqueAdicional;
	}

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
	public Tonalidad getColor() { return Tonalidad.AZUL; }
	
	public boolean isConTanqueAdicional() { return this.tieneTanqueAdicional; }

}
