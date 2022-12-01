import java.util.Scanner;

public class MenuCreacionPropietario {
	private String DNI;
	private String nombre;
	private String apellidos;

	Scanner sc = new Scanner(System.in);

	public Propietario muestraMenuCreacionPropietario() {
		do {
			System.out.println("Por favor, introduzca el dni del propietario");
			DNI = sc.nextLine();
			if (DNI.equals("")) {
				System.out.println("Error:El dni no puede estar vacio");
			}
		} while (DNI.equals(""));
		do {
			System.out.println("Por favor, introduzca el nombre del propietario");
			nombre = sc.nextLine();
			if (nombre.equals("")) {
				System.out.println("Error: El nombre no puede estar vacio");
			}
		} while (nombre.equals(""));
		do {
			System.out.println("Por favor, introduzca el apellido del propietario");
			apellidos = sc.nextLine();
			if (apellidos.equals("")) {
				System.out.println("Error:El apellido no puede estar vacio");
			}
		} while (apellidos.equals(""));
		Propietario p = new Propietario();
		return p;
	}
}
