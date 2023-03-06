
import java.util.Random;
import java.util.Scanner;

public class Correcion {

	public static void main(String[] args) {
		System.out.println("======================");
		System.out.println("Ejercicio 1");
		System.out.println("======================");

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, dígame un número:");
		int n = sc.nextInt();
		sc.nextLine();

		int[] numeros = new int[n];

		Random r = new Random();

		for (int i = 0; i < n; i++) {
			numeros[i] = r.nextInt(n + 1);
		}

		System.out.println("El contenido del array es: ");

		for (int i = 0; i < n; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
		int suma = 0;
		for (int numero : numeros) {
			suma += numero;
		}

		System.out.println("La suma es: " + suma);

		System.out.println("======================");
		System.out.println("Ejercicio 2");
		System.out.println("======================");

		System.out.println("Por favor, dígame un número:");
		n = sc.nextInt();
		sc.nextLine();

		String[] nombres = new String[n];

		Faker faker = new Faker(new Locale("es"));

		for (int i = 0; i < n; i++) {
			nombres[i] = faker.name().fullName();
		}

		for (int i = 0; i < n; i++) {
			System.out.print(nombres[i] + "-");
		}

		int total = n;

		int aleatorio = 0;
		do {
			aleatorio = r.nextInt(n);
			if (!nombres[aleatorio].equals("")) {
				System.out.println("Se ha dado a: " + nombres[aleatorio]);
				nombres[aleatorio] = "";
				total--;
			} else {
				System.out.println("Se ha errado el tiro.");
			}
		} while (total > 0);

		System.out.println("Se han eliminado todos los nombres");

		System.out.println("======================");
		System.out.println("Ejercicio 3");
		System.out.println("======================");

		System.out.println("Por favor, dígame un número:");
		n = sc.nextInt();
		sc.nextLine();

		String tabla[][] = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (r.nextBoolean()) {
//					int numero = r.nextInt(n+1);
					tabla[i][j] = Integer.toString(r.nextInt(n + 1));
				} else {
					tabla[i][j] = "X";
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(tabla[i][j]);
			}
			System.out.println();
		}
		int sumaTotal = 0;
		for (int  i = 0; i<n; i++) {
			for (int j = 0; j <n; j++) {
				if (!tabla[i][j].equals("X")) {
					sumaTotal += Integer.parseInt(tabla[i][j]);
				}
			}
		}
		
		System.out.println("La suma total es: "+ sumaTotal);
	}

}