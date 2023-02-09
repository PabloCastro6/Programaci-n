import java.util.Random;
import java.util.Scanner;

import Calculos.calculosArrays;

public class ejercicio6 {

	public static void main(String[] args) {
Scanner scanner = new Scanner (System.in);
		
		System.out.println("Ingrese el numero de filas");
		int filas = scanner.nextInt();
		System.out.println("Ingrese el numero de columnas");
		int columnas = scanner.nextInt();
		
		int [][] array = new int [filas] [columnas];
		Random rand = new Random();
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				array[i][j] = rand.nextInt(100);
			}
		}
		System.out.println("Bidimensional array:");
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		calculosArrays obj = new calculosArrays();
		System.out.println("La suma de los numeros es: " + obj.calculaSuma(array, filas, columnas));
		System.out.println("El producto de los numeros es: " + obj.calculaProducto(array, filas, columnas));
		System.out.println("La media de los numeros es: " + obj.calculaMedia(array, filas, columnas));
		System.out.println("La cantidad de números negativos es: " + obj.encuentraNumNegativos(array, filas, columnas));
		System.out.println("La cantidad de números positivos es: " + obj.encuentraNumPositivos(array, filas, columnas));
		System.out.println("La cantidad de 0 es: " + obj.encuentraNull(array, filas, columnas));
	}
	

	
	}

		

