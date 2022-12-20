
public class AeropuertoPublico extends Aeropuerto {
	private double subvencion;
	
	public AeropuertoPublico(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		// TODO Auto-generated constructor stub
	}

	public AeropuertoPublico(String nombre, String ciudad, String pais, double subvencion) {
		super(nombre, ciudad, pais);		
		// TODO Auto-generated constructor stub
		this.subvencion = subvencion;
	}

	
	public AeropuertoPublico(String nombre, String ciudad, String pais, Compañia[] listaCompañias, double subvencion) {
		super(nombre, ciudad, pais, listaCompañias);
		// TODO Auto-generated constructor stub
		this.subvencion = subvencion;
	}

	public double getSubvencion() {
		return subvencion;
	}	
		
}
