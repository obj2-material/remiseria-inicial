package ar.edu.unq.tpi.remiseria;

public class ChevroletCorsaGasolero extends ChevroletCorsa {

	public ChevroletCorsaGasolero(Tonalidad color) { super(color); }

	@Override
	public int getVelocidadMaxima() { return 140; }

}
