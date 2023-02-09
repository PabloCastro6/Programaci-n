package pianista;

import java.lang.Object;
import java.util.Scanner;
import java.util.Random;

public class ejercicio {

	public static void main(String[] args) {
		int n;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero entero:");
		n = entrada.nextInt();
		entrada.nextLine();
		String array[][] = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int numeroAleatorio = (int) (Math.random()*(n+1));
				array[i][j] = String.valueOf(numeroAleatorio); 
				System.out.print(" | " + array[i][j] + " | ");
			}
			System.out.println(" ");
		}

			System.out.println("Dispara al pianista");
			System.out.println("Dime fila");
			int coordenada1,coordenada2;
			coordenada1 = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Dime columna");
			coordenada2= entrada.nextInt();
			entrada.nextLine();
			System.out.println("Tienes 2 puntos acumulados");
			
			
			array[coordenada1][coordenada2] = "X"; //cambiar valor a X
			//ahora imprimimos array
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" | " + array[i][j] + " | ");
				}
				System.out.println(" ");
			}
			
		}
	}

