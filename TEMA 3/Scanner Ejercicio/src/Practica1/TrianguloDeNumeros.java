package Practica1;

import java.util.Scanner;

public class TrianguloDeNumeros {
	int numero;
	public void imprimeTriangulo() {
	
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= numero; i++){
			for (int n = 1; n<=i; n++) {
				System.out.print(n+" ");
			}
		System.out.println("");
		}
	}
	public void imprimeTrianguloInvertido() {
		System.out.print("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i <= numero; i++){
			for (int n = numero; n >= i + 1 ; n--) {
				System.out.print(n+" ");
			}
		System.out.println("");
		}
	}
}
