import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] respuestaMaquina = { "piedra", "papel", "tijera" };

		Random rand = new Random();

		int posicionEleccion = rand.nextInt(respuestaMaquina.length);

		String eleccionAleatoria = respuestaMaquina[posicionEleccion];

		System.out.println("¿Piedra, Papel o Tijera?");
		String respuesta = sc.nextLine();

		System.out.println("La máquina eligió: " + eleccionAleatoria);

		if (respuesta.equalsIgnoreCase(eleccionAleatoria)) {
			System.out.println("Es un empate.");
		} else if (respuesta.equalsIgnoreCase("piedra") && eleccionAleatoria.equals("tijera")
				|| respuesta.equalsIgnoreCase("papel") && eleccionAleatoria.equals("piedra")
				|| respuesta.equalsIgnoreCase("tijera") && eleccionAleatoria.equals("papel")) {
			System.out.println("¡Ganaste!");
		} else {
			System.out.println("La máquina gana.");
		}

		sc.close();
	}

}
