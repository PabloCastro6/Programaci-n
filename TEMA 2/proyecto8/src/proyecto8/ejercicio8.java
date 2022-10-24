package proyecto8;

public class ejercicio8 {

	public static void main(String[] args) {
		int primero = 27;
		int segundo = 9;
		int tercero = 12;

		if (primero > segundo && primero > tercero) {
			System.out.println("La primera variable es la mayor.");
		} else if (segundo > tercero && segundo > primero) {
			System.out.println("La segunda variable es la mayor.");
		} else {
			System.out.println("La tercera variable es la mayor.");
		}
	}

}
