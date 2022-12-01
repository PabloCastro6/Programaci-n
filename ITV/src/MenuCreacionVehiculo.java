import java.util.Scanner;

public class MenuCreacionVehiculo {
	private String matricula;
	private String modelo; 
	private String caballos; 
	private String combustible; 
	
	Scanner sc = new Scanner(System.in);
	
	public Vehiculo MenuCreacionVehiculo() {
		do {
			System.out.println("Por favor, introduzca la matricula del vehiculo");
			matricula = sc.nextLine();
			if (matricula.equals("")) {
				System.out.println("Error: La matricula no puede estar vacia");
			}
		}while (matricula.equals(""));
		
		do {
			System.out.println("Por favor, introduzca el modelo del vehiculo");
			modelo = sc.nextLine();
			if (modelo.equals("")) {
				System.out.println("Error: El modelo no puede estar vacio");
			}
		}while (modelo.equals(""));
		
		do {
			System.out.println("Por favor, introduzca los caballos del vehiculo");
			caballos = sc.nextLine();
			if (caballos.equals("")) {
				System.out.println("Error: Los caballos no puede estar vacio");
			}
		}while (caballos.equals(""));
		
		do {
			System.out.println("Por favor, introduzca el combustible del vehiculo");
			combustible = sc.nextLine();
			if (!combustible.equalsIgnoreCase("Diesel") && !combustible.equalsIgnoreCase ("Gasolina")) {
				System.out.println("Error: El combustible no puede estar vacio");
				}
		}while (!combustible.equalsIgnoreCase("Diesel") && !combustible.equalsIgnoreCase ("Gasolina"));
		
	Vehiculo v = new Vehiculo (matricula, modelo, caballos, combustible);
	return v ;
			
			
			
			
		}
	
	}
	


