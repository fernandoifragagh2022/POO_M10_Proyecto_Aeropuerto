
public class Compañia {
	private String nombreCompañia;
	private Vuelo listaVuelos[] = new Vuelo[10];
	private int numVuelo = 0;
	
	public Compañia(String nombreCompañia) {
		this.nombreCompañia = nombreCompañia;
	}
	
	public Compañia(String nombreCompañia, Vuelo vuelos[]) {
		this.nombreCompañia = nombreCompañia;
		listaVuelos = vuelos;
		numVuelo = vuelos.length;
	}
	
	public void insertarVuelo(Vuelo vuelo) {
		listaVuelos[numVuelo] = vuelo;
		numVuelo++;
	}

	public String getNombreCompañia() {
		return nombreCompañia;
	}

	public int getNumVuelo() {
		return numVuelo;
	}
	
	public Vuelo getVuelo(int i) {
		return listaVuelos[i];
	}
	
	public Vuelo getVuelo(String identificador) {
		boolean encontrado = false;
		int i = 0;		
		Vuelo v = null;
		
		while((!encontrado)&&(i<listaVuelos.length)) {
			if(identificador.equals(listaVuelos[i].getIdentificador())) {
				encontrado = true;
				v = listaVuelos[i];
			}
			i++;
		}
		
		
		return v;
	}
}
