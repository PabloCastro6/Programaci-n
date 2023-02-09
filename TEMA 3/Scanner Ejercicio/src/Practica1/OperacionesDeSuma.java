package Practica1;

import java.util.Scanner;

public class OperacionesDeSuma {
	int numero;
	public void imprimeSumaAcumulada() {
		int resultado = 0;
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i <= numero; i++) {
			System.out.print(i);
			resultado = resultado + i;
			if(i<numero) {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " + resultado);
	}
}
