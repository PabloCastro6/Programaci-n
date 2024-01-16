import java.util.Random;

enum Nombres {
	Lali, Alberto, Paula, Sergio
}

public class Ejercicio4 {

	public static void main(String[] args) {

		Nombres[] nombres = Nombres.values();
		Random rand = new Random();
		int posicionNombre = rand.nextInt(nombres.length);

		Nombres nombreAleatorio = nombres[posicionNombre];

		System.out.println(nombreAleatorio);

	}

}
