import java.util.Scanner;

public class Main {
	
	static Scanner entrada = new Scanner(System.in);
	
	final static int numeroAeropuertos = 4;
	static Aeropuerto aeropuertos[] = new Aeropuerto[numeroAeropuertos];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertarDatosAeropuertos(aeropuertos);
		
		menu();
	}
	
	public static void insertarDatosAeropuertos(Aeropuerto aero[]) {
		aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Peru", 8000000);		
		aero[0].insertarCompañia(new Compañia("Aero Peru"));
		aero[0].insertarCompañia(new Compañia("LATAM"));
		aero[0].getCompañia("Aero Peru").insertarVuelo(new Vuelo("A2S5", "Peru", "México", 2200, 150));
		aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("O34W", "Lima", "Londres", 5800, 300));
		aero[0].getCompañia("Aero Peru").getVuelo("A2S5").insertarPasajero(new Pasajero("Fernando Fraga", "12345", "Mexicana"));
		aero[0].getCompañia("Aero Peru").getVuelo("A2S5").insertarPasajero(new Pasajero("Ivan Avila", "45437", "Mexicana"));		
		aero[0].getCompañia("LATAM").getVuelo("O34W").insertarPasajero(new Pasajero("Raul Perez", "2087", "Peruana"));
		
		aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");		
		aero[1].insertarCompañia(new Compañia("Ole fly"));
		aero[1].getCompañia("Ole fly").insertarVuelo(new Vuelo("OYT8", "Lima", "Londres", 2200, 50));
		aero[1].getCompañia("Ole fly").getVuelo("OYT8").insertarPasajero(new Pasajero("Ignacio Allende", "45437", "Colombiano"));		
		((AeropuertoPrivado)aero[1]).insertarEmpresa("Empresa 1");
		((AeropuertoPrivado)aero[1]).insertarEmpresa("Empresa 2");
		
		aero[2] = new AeropuertoPublico("Aeropuerto Bogota", "Bogota", "Colombia", 9000000);
		aero[2].insertarCompañia(new Compañia("Cielo"));
		aero[2].getCompañia("Cielo").insertarVuelo(new Vuelo("GVH7", "Lima", "Londres", 3000, 100));		
		aero[2].getCompañia("Cielo").getVuelo("GVH7").insertarPasajero(new Pasajero("Fermin Solar", "2047", "Español"));
		
		aero[3] = new AeropuertoPublico("Aeropuerto México", "México", "México", 1000000);
		aero[3].insertarCompañia(new Compañia("Volaris"));
		aero[3].insertarCompañia(new Compañia("Viva aero bus"));
		aero[3].getCompañia("Volaris").insertarVuelo(new Vuelo("DF34", "Lima", "Buenos Aires", 1100, 100));
		aero[3].getCompañia("Viva aero bus").insertarVuelo(new Vuelo("OI86", "Lima", "Londres", 5800, 300));
		aero[3].getCompañia("Volaris").getVuelo("DF34").insertarPasajero(new Pasajero("Fernando", "12345", "Mexicana"));
		aero[3].getCompañia("Volaris").getVuelo("DF34").insertarPasajero(new Pasajero("Ivan", "45437", "Mexicana"));		
		aero[3].getCompañia("Viva aero bus").getVuelo("OI86").insertarPasajero(new Pasajero("Raul", "2087", "Peruana"));
	}
	
	public static void menu() {
		
		int opcion;
		String nombreAeropuerto, nombreCompañia, origen, destino;
		Aeropuerto aeropuerto;
		Compañia compañia;
		
		do {
			System.out.println("\t.:Menu:.");
			System.out.println("1. Aeropuertos gestionados (Publicos o privados)");
			System.out.println("2. Empresas (Privados) o Subvencion (Publicos)");
			System.out.println("3. Listas de compañias");
			System.out.println("4. Lista de vuelos por compañia");
			System.out.println("5. Listar posibles vuelos de origen a destino");
			System.out.println("6. Salir");
			System.out.println("Opcion: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println(".:Aeropuertos gestionados (Publicos o privados):.");
				mostrarDatosAeropuertos(aeropuertos);
				break;
			case 2:
				System.out.println(".:Empresas (Privados) o Subvencion (Publicos):.");
				mostrarPatrocinio(aeropuertos);
				break;
			case 3:
				entrada.nextLine();
				System.out.println(".:Listas de compañias:.");
				System.out.println("\nDigite el nombre del aeropuerto");
				nombreAeropuerto = entrada.nextLine();
				//System.out.print(nombreAeropuerto);
				//nombreAeropuerto = "Jorge Chavez";
				aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if(aeropuerto == null) {
					System.out.println("El aeropuerto no existe");
				} else {
					mostrarCompañias(aeropuerto);
				}
				break;
			case 4:
				entrada.nextLine();
				System.out.println(".:Lista de vuelos por compañia:.");
				System.out.println("\nDigite el nombre del aeropuerto");
				nombreAeropuerto = entrada.nextLine();
				aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if(aeropuerto == null) {
					System.out.println("El aeropuerto no existe");
				} else {
					System.out.println("\nDigite el nombre de la compañia");
					nombreCompañia = entrada.nextLine();
					compañia = aeropuerto.getCompañia(nombreCompañia);
					mostrarVuelos(compañia);
				}
				break;
			case 5:
				entrada.nextLine();
				System.out.println(".:Listar posibles vuelos de origen a destino:.");
				System.out.println("\nDigite la ciudad de origen");
				origen = entrada.nextLine();
				System.out.println("\nDigite la ciudad de destino");
				destino = entrada.nextLine();
				mostrarVueloOrigenDestino(origen, destino, aeropuertos);
				break;
			case 6:
				System.out.println(".:Salir:.");
				break;
				
			default:
				System.out.println("Opcion invalida");				
			}
			System.out.println();
			
		}while(opcion != 6);
	}
	
	public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]) {
		for(int i=0; i<aeropuertos.length; i++) {
			if(aeropuertos[i] instanceof AeropuertoPrivado) {
				System.out.println("Aeropuerto Privado");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pais: " + aeropuertos[i].getPais());				
			} else {
				System.out.println("Aeropuerto Publico");
				System.out.println("Nombre: " + aeropuertos[i].getNombre());
				System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
				System.out.println("Pais: " + aeropuertos[i].getPais());
			}
			System.out.println();
		}
	}
	
	public static void mostrarPatrocinio(Aeropuerto aeropuertos[]) {
		String empresas[];
		for(int i=0; i<aeropuertos.length; i++) {
			if(aeropuertos[i] instanceof AeropuertoPrivado) {
				System.out.println("Aeropuerto Privado: " + aeropuertos[i].getNombre());
				empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas(); //down casting para obtener el metodo de AeropuertoPrivado
				
				System.out.println("Empresas: ");
				
				for(int j=0; j<empresas.length; j++) {
					if(empresas[j] != null) {
						System.out.println(empresas[j]);
					}					
				}
			} else {
				System.out.println("Aeropuerto Publico: " + aeropuertos[i].getNombre());
				System.out.println("Subvencion: " + ((AeropuertoPublico)aeropuertos[i]).getSubvencion());
			}
		}
	}
	
	public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
		boolean encontrado = false;
		int i=0;
		Aeropuerto aero = null;
		
		while((!encontrado)&&(i<aeropuertos.length)) {
			if(nombre.equals(aeropuertos[i].getNombre())) {
				encontrado = true;
				aero = aeropuertos[i];
			}
			i++;
		}		
		return aero;
	}
	
	public static void mostrarCompañias(Aeropuerto aeropuerto) {		
		System.out.println("Las compañias del aeropuerto: " + aeropuerto.getNombre());
		for(int i=0; i<aeropuerto.getNumCompañias(); i++) {
			System.out.println(aeropuerto.getCompañia(i).getNombreCompañia());
		}		
	}
	
	public static void mostrarVuelos(Compañia compañia) {
		Vuelo vuelo;
		System.out.print("Los vuelos de la compañia: " + compañia.getNombreCompañia());
		for(int i=0; i<compañia.getNumVuelo(); i++) {
			vuelo = compañia.getVuelo(i);
			System.out.println("Identificado: "+vuelo.getIdentificador());
			System.out.println("Ciudad de origen: "+vuelo.getCiudadOrigen());
			System.out.println("Ciudad destino: "+vuelo.getCiudadDestino());
			System.out.println("Precio: "+vuelo.getPrecio());
			System.out.println("");
			
		}		
		
	}
	
	public static Vuelo[] buscarBuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[] ) {
		Vuelo vuelo;
		int contador = 0;
		Vuelo listaVuelos[];
		for(int i=0; i<aeropuertos.length;i++) {
			for(int j=0; j<aeropuertos[i].getNumCompañias(); j++) {
				for(int k=0; k<aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
					vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
					if(origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())) {
						contador++;
					}
				}
			}
		}
		
		listaVuelos = new Vuelo[contador];
		int q=0;
		
		for(int i=0; i<aeropuertos.length;i++) {
			for(int j=0; j<aeropuertos[i].getNumCompañias(); j++) {
				for(int k=0; k<aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
					vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
					if(origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())) {
						listaVuelos[q] = vuelo;
						q++;
					}
				}
			}
		}
		
		return listaVuelos;
	}
	
	public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
		Vuelo vuelos[];
		vuelos = buscarBuelosOrigenDestino(origen, destino, aeropuertos);
		if(vuelos.length==0) {
			System.out.println("No hay vuelos disponibles");
		} else {
			System.out.println("\nVuelos disponibles\n");
			for(int i=0; i<vuelos.length; i++) {
				System.out.println("Identificador: " + vuelos[i].getIdentificador());
				System.out.println("Ciudad origen: " + vuelos[i].getCiudadOrigen());
				System.out.println("Ciudad destino: " + vuelos[i].getCiudadDestino());
				System.out.println("Precio: $" + vuelos[i].getPrecio());
				System.out.println("");
			}
		}
	}
}
