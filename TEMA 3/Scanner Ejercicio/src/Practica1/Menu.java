package Practica1;

import java.util.Scanner;

public class Menu {
	int menuElegido;

	public void imprimirMenu() {
		do {
			System.out.println("********************Menu**********************");
			System.out.println("1.- Imprimir los numeros naturales");
			System.out.println("2.- Imprimir un triangulo rectangulo con numeros");
			System.out.println("3.- Imprimir un triangulo rectangulo invertido con numeros");
			System.out.println("4.- Suma acumulada");
			System.out.println("5.- Imprimir tabla de multiplicar");
			System.out.println("6.- Numeros pares");
			System.out.println("7.- Numeros primos");
			System.out.println("8.- Jugar piedra, papel o tijera");
			System.out.println("9.- Salir");
			System.out.println("*********************************************");
			System.out.print("Selecciona una opción del Menú: ");
			Scanner sc = new Scanner(System.in);
			menuElegido = sc.nextInt();
			sc.nextLine();
			switch (menuElegido) {
			case 1: {
				Numeros numero = new Numeros();
				numero.imprimeNumerosNaturales();
				break;
			}
			case 2: {
				TrianguloDeNumeros numero = new TrianguloDeNumeros();
				numero.imprimeTriangulo();
				break;
			}
			case 3: {
				TrianguloDeNumeros numero = new TrianguloDeNumeros();
				numero.imprimeTrianguloInvertido();
				break;
			}
			case 4: {
				OperacionesDeSuma numero = new OperacionesDeSuma();
				numero.imprimeSumaAcumulada();
				break;
			}
			case 5: {
				TablaMultiplicar numero = new TablaMultiplicar();
				numero.imprimirTablaMultiplicar();
				break;
			}
			case 6: {
				Numeros numero = new Numeros();
				numero.imprimirNumerosPares();
				break;
			}
			case 7: {
				Numeros numero = new Numeros();
				numero.imprimirNumerosPrimos();
				break;
			}
			case 8: {
				PiedraPapelTijera numero = new PiedraPapelTijera();
				numero.imprimirPiedraPapelTijera();
				break;
			}
			case 9: {
				System.out.println("Aplicación cerrada");
				break;
			}
			default: {
				System.out.println("La opción no es correcta, debes escribir un número entre 1 y 9");
				break;
			}
			}
		} while (menuElegido != 9);
	}
}
