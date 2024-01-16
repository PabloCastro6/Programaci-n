import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Persona> listaPersonas = new ArrayList<>();

		while (true) {
			System.out.print("Ingrese el nombre de la persona (deje en blanco para Anónimo): ");
			String nombre = sc.nextLine();

			System.out.print("Ingrese la edad de la persona (ingrese un número negativo para 99 años): ");
			int edad = sc.nextInt();
			sc.nextLine();

			Persona persona = new Persona(nombre, edad);
			listaPersonas.add(persona);

			System.out.print("¿Desea ingresar otra persona? (S/N): ");
			String respuesta = sc.nextLine();

			if (!respuesta.equals("S")) {
				break;
			}
		}

		System.out.println("Lista de personas ingresadas:");
		for (Persona persona : listaPersonas) {
			System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
		}
	}
}
