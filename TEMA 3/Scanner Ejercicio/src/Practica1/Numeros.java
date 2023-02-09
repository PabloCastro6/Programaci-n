package Practica1;

import java.util.Scanner;

public class Numeros {
	int numero;
	public void imprimeNumerosNaturales() {
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i <= numero; i++) {
			System.out.println(i);
		}
	}
	public void imprimirNumerosPares() {
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner (System.in);
		numero = sc.nextInt();
		sc.nextLine();
		int contador=0;
		
		for (int i = 0; i <= numero; i+=2) {
			if (i==0) {
				continue;
			}
			System.out.print(i + " ");
			contador++;
		}
		System.out.println();
		System.out.println("La cantidad total de números pares es: " + contador);
	}
	public void imprimirNumerosPrimos() {
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner (System.in);
		numero = sc.nextInt();
		sc.nextLine();
		boolean esPrimo = false;
		int contador = 0;

			System.out.print("Los números primos desde 0 hasta " + numero + " son: ");
			for (int i = 0; i <= numero; i++) {
				if (i == 1 || i == 0 || i == 4)
					continue;

				esPrimo = true;
				for (int x = 2; x <= i / 2; ++x) {
					if (i % x == 0) {
						esPrimo = false;
						continue;
					}
				}
				if ((esPrimo == true) && (i <= numero )) {
					System.out.print(i + ", ");
					contador++;
				} 			
			}
			System.out.println("");
			System.out.println("la cantidad de números primos es: " + contador);			
	}
}
