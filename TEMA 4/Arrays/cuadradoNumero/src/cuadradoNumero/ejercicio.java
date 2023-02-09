package cuadradoNumero;

import java.util.Scanner;

public class ejercicio {

	public static void main(String[] args) {
		int n,aleatorio;
		Scanner entrada = new Scanner (System.in);
		System.out.println("Introduce un numero entero:");
		n = entrada.nextInt();
		
		int [][] numero = new int [n] [n];
		for (int i=0; i< n; i++) {
			for (int j=0; j< n ;j++) {
				numero [i][j]=n;
		System.out.print(numero [i][j] + " ");
	}
System.out.println(" ");
}
	}
}
