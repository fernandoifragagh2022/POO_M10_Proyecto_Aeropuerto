
public class AeropuertoPrivado extends Aeropuerto {
	private String listaEmpresas[] = new String[10];
	private int numEmpresas;
	
	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		// TODO Auto-generated constructor stub
	}

	public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia[] listaCompañias, String listaEmpresas[]) {
		super(nombre, ciudad, pais, listaCompañias);
		this.listaEmpresas = listaEmpresas;
		this.numEmpresas = listaEmpresas.length;
		// TODO Auto-generated constructor stub
	}
	
	public void insertarEmpresas(String listaEmpresas[]) {
		this.listaEmpresas = listaEmpresas;
		this.numEmpresas = listaEmpresas.length;
	}
	
	public void insertarEmpresa(String empresa) {
		listaEmpresas[numEmpresas]= empresa;
		numEmpresas++;
	}

	public String[] getListaEmpresas() {
		return listaEmpresas;
	}

	public int getNumEmpresas() {
		return numEmpresas;
	}
	
	
}
