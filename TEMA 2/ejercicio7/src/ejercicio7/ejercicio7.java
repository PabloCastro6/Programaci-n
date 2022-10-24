package ejercicio7;

public class ejercicio7 {

	public static void main(String[] args) {
		int primerLado = 8;
		int segundoLado = 8;
		int tercerLado = 8;

		if (primerLado == segundoLado && primerLado == tercerLado) {
			System.out.println("Es un triangulo equilatero.");
		} else if (primerLado == segundoLado || primerLado == tercerLado || segundoLado == tercerLado) {
			System.out.println("Es un triangulo isosceles.");
		} else {
			System.out.println("Es un triangulo escaleno.");
		}
	}

}
