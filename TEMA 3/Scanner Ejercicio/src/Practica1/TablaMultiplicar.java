package Practica1;

import java.util.Scanner;

public class TablaMultiplicar {
	public void imprimirTablaMultiplicar() {
		int numero;
		System.out.print("Introduce un número: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		
		System.out.println("La tabla de multiplicar del " + numero + " es: ");
		for (int i = 1; i <=10; i++) {
			System.out.println(numero + " * " + i + " = " + (numero * i));
		}		
	}
}
