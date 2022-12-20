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
		aero[1].getCompañia("Ole fly").insertarVuelo(new Vuelo("OYT8", "Ciudad Real", "Londres", 2200, 50));
		aero[1].getCompañia("Ole fly").getVuelo("OYT8").insertarPasajero(new Pasajero("Ignacio Allende", "45437", "Colombiano"));		

		
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
				mostrarDatosAeropuertos(aeropuertos);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
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

}
