import java.util.Scanner;

public class PiedraPapelTijera {
	int numero;
	public void jugarPiedraPapelTijera() {
		int numAleatorio = (int) (Math.random()*3 +1);
		System.out.println("¿Piedra,Papel o Tijera?");
		System.out.println("1. Piedra");
		System.out.println ("2. Papel");
		System.out.println ("3. Tijera");
		System.out.println("que se puede sacar??");
		
		numero = sc.nextInt();
		sc.nextInt();
		if {
			if(numero <= 3 && numero >=1) {
				switch (numero) {
				
				case 1:
					if (numAleatorio == 1);
				System.out.println("Empate, nadie gana");
				}else if (numAleatorio == 2) {
					System.out.println("Has elegido piedra, y yo papel, Has ganado!");
				}else {
					System.out.println("Has elegido piedra y yo tijera, Has perdido!");
					
				}
				break;
				case 2:
					if (numAleatorio == 1) {
						System.out.println ("Has elegido papel y yo piedra, Has ganado!");
					} else if (numAleatorio == 2) {
						System.out.println ("Has elegido papel y yo papel, Empate!");
					}else {
						System.out.println("Has elegido papel y yo tijera, Has perdido!");
					}
				break;
				case 3: 
					if (numAleatorio == 1) {
						System.out.println("Has elegido tijera y yo piedra, Has perdido!");
					}else if (numAleatorio == 2) {
						System.out.println("Has elegido tijera y yo papel, Has ganado!");
					}else {
						System.out.println("Has elegido tijera y yo tijera, Empate!");
					}
					break;
			}
		}else {
			System.out.println("Introduce un valor entre 1 y 3");
					
				}
			}
		}
	}

}
