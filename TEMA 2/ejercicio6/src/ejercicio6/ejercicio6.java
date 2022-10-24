package ejercicio6;

public class ejercicio6 {

	public static void main(String[] args) {
		char letra = '1';

		if ('a' <= letra && letra <= 'z') {
			System.out.println("La letra " + letra + " es minuscula.");
		} else if ('A' <= letra && letra <= 'Z') {
			System.out.println("El letra " + letra + " es mayuscula.");
		} else {
			System.out.println("El caracter " + letra + " no es una letra.");
		}
	}

}
