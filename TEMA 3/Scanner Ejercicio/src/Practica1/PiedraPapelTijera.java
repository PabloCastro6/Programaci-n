package Practica1;

import java.util.Scanner;

public class PiedraPapelTijera {
	int numero;
	public void imprimirPiedraPapelTijera() {
		int seleccionCompu = (int)(Math.random()*3 +1);	
		System.out.println("¿Piedra, papel o tijera?");
		System.out.println("1.- Piedra");
		System.out.println("2.- Papel");
		System.out.println("3.- Tijera");	
		System.out.print("elige una opción: ");
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		if (numero <= 3 && numero >=1) {
			switch (numero) {
			case 1:
				if (seleccionCompu == 1) {
					System.out.println("Has elegido piedra y yo piedra ¡Empate!");
				} else if (seleccionCompu == 2) {
					System.out.println("Has elegido piedra y yo papel ¡Has perdido, tontito!");				
				} else {
					System.out.println("Has elegido piedra y yo tijera ¡Has ganado!");
				}
				break;
			case 2:
				if (seleccionCompu == 1) {
					System.out.println("Has elegido papel y yo piedra ¡Has ganado!");
				} else if (seleccionCompu == 2) {
					System.out.println("Has elegido papel y yo papel ¡Empate!");				
				} else {
					System.out.println("Has elegido papel y yo tijera ¡Has perdido, tontito!");
				}
				break;
			case 3:
				if (seleccionCompu == 1) {
					System.out.println("Has elegido tijera y yo piedra ¡Has perdido, tontito!");
				} else if (seleccionCompu == 2) {
					System.out.println("Has elegido tijera y yo papel ¡Has ganado!");				
				} else {
					System.out.println("Has elegido tijera y yo tijera ¡Empate!");
				}
				break;
			}
		} else {
		System.out.println("Introduce un valor entre 1 y 3");	
		}		
	}
}
