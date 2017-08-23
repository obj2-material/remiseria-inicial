package ar.edu.unq.tpi.remiseria;

public class ChevroletCorsaFamiliar extends ChevroletCorsa {

	public ChevroletCorsaFamiliar(Color color) { super(color); }

	@Override
	public int getVelocidadMaxima() { return 130; }

	@Override
	public int getCapacidad() { return super.getCapacidad() + 1; }
}
