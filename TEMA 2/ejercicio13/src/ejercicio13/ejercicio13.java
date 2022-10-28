package ejercicio13;

public class ejercicio13 {

	public static void main(String[] args) {
		int numero = 4;
		int resultado;

		System.out.println("La tabla de multiplicar del " + numero + " es :");
		System.out.println("==============================================");

		for (int i = 1; i < 10; i++) {

			resultado = numero * i;
			System.out.println(numero + " x " + i + " = " + resultado);
		}

	}

}
