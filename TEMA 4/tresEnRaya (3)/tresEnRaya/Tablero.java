package tresEnRaya;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero.
 */
public class Tablero {

	/** The sc. */
	Scanner sc = new Scanner(System.in);

	/** The jugador actual. */
	private char jugadorActual;

	/** The columnas. */
	private int filas = 3, columnas = 3;

	/** The matriz. */
	private char matriz[][] = new char[filas][columnas];

	/** The tablero L leno. */
	boolean tableroLLeno = false;

	/** The victoria. */
	boolean victoria = false;

	/**
	 * Instantiates a new tablero.
	 */
	public Tablero() {

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = '-';
			}
		}
		jugadorActual = 'X';

	}

	/**
	 * Cambia jugador.
	 */
	public void cambiaJugador() {
		// System.out.println("Cambiando de jugador, jugador actual: " + this.jugadorActual);
		if (this.jugadorActual == 'X') {
			this.jugadorActual = 'O';
		} else {
			this.jugadorActual = 'X';
		}
	}

	/**
	 * Imprime tablero.
	 */
	public void imprimeTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (j + 1 == columnas) {
					System.out.print("| " + matriz[i][j] + " | ");
				} else {
					System.out.print("| " + matriz[i][j] + " ");
				}

			}
			System.out.println(" ");
		}
	}

	/**
	 * Actualiza tablero.
	 */
	public void actualizaTablero() {
		int fila_jugador = -1;
		int columna_jugador = -1;
		boolean casillaVacia = false;

		do {
			System.out.println();
			System.out.println("Introduzca la fila jugador:" + jugadorActual + " : ");
			int fila = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduzca la columna del jugador:" + jugadorActual + " : ");
			int columna = sc.nextInt();
			sc.nextLine();

			if (fila > 3 || fila <= 0 || columna <= 0 || columna > 3) {
				System.out.println("No puede introducir casilla " + fila + " , " + columna);
				continue;

			} else {
				if (matriz[fila - 1][columna - 1] != '-') {
					System.out.println("Posicion ocupada");
					System.out.println();
					imprimeTablero();
				} else {
					matriz[fila - 1][columna - 1] = jugadorActual;
					casillaVacia = true;
				}
			}
		} while (!casillaVacia);
	}

	// while (!casillaVacia) {
	// while (fila_jugador < 0 || fila_jugador > filas || columna_jugador < 0 ||
	// columna_jugador > columnas) {
	// System.out.println("Jugador actual: "+this.jugadorActual);
	// System.out.println("Introduzca el numero de fila [ENTER]: ");
	// fila_jugador = entrada.nextInt() - 1;
	// System.out.println("Introduzca el numero de columna: ");
	// columna_jugador = entrada.nextInt() - 1;

	// if (fila_jugador < 0 || fila_jugador > filas || columna_jugador < 0 ||
	// columna_jugador > columnas) {
	// System.out.println("La fila o la columna esta fuera de rango");
	// }
	// }
	// if (matriz[fila_jugador][columna_jugador] == '-') {
	// matriz[fila_jugador][columna_jugador] = jugadorActual;
	// casillaVacia = true;

	// } else {

	// System.out.println("La casilla para esta fila y columna est� ocupada");
	// }
	// break;
	// }

	// }

	/**
	 * Hay ganador.
	 *
	 * @return true, if successful
	 */
	public boolean hayGanador() {

		boolean hayGanador = false;
		if (hayGanadorEnFila() || hayGanadorEnColumna() || hayGanadorEnDiagonal()) {
			hayGanador = true;
			System.out.println("Ha ganado el jugador: " + this.jugadorActual);

		}
		if (!hayGanador) {
			cambiaJugador();
		}
		return hayGanador;

	}

	/**
	 * Hay ganador en fila.
	 *
	 * @return true, if successful
	 */
	public boolean hayGanadorEnFila() {

		 boolean coincide = true;
		 for ( int i = 0; i < filas; i++) {

		 if ( matriz [i][0] != '-') {
		 if (matriz [i][0] == matriz [i][1] && matriz[i][0] == matriz[i][2]) {
		 return coincide;
		 }

		 }
	 }
	 return !coincide;
	}
		
		
		
		
	/* boolean filaIguales = true;

		int contadorFila = 0;
		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				if (matriz[i][j] == this.jugadorActual) {
					contadorFila++;

				}
			}
			// System.out.println("Cuenta de la fila "+i+": "+contadorFila);
			if (contadorFila == 3) {
				// System.out.println("Hay ganador en fila");
				return true;
			}
			if (i + 1 == filas) {
				filaIguales = false;
			}

			contadorFila = 0;
		}
		return filaIguales;
	}
*/
		
		
		
	/**
	 * Hay ganador en columna.
	 *
	 * @return true, if successful
	 */
	public boolean hayGanadorEnColumna() {
		 boolean coincide = true;
		 for ( int i = 0; i < filas; i++) {

		 if ( matriz [0][i] != '-') {
		 if (matriz [0][i] == matriz [1][i] && matriz[0][i] == matriz[2][i]) {
		 return coincide;
		 }

		 }
	 }
	 return !coincide;
	}

	// if (matriz[0][0] == this.jugadorActual && matriz[1][0] == this.jugadorActual
	// && matriz[2][0] == this.jugadorActual) {
	// return true;
	// }
	// if (matriz[0][1] == this.jugadorActual && matriz[1][1] == this.jugadorActual
	// && matriz[2][1] == this.jugadorActual) {
	// return true;
	// }
	// if (matriz[0][2] == this.jugadorActual && matriz[1][2] == this.jugadorActual
	// && matriz[2][2] == this.jugadorActual) {
	// return true;
	// }

	// return false;
	// }

	/**
	 * Hay ganador en diagonal.
	 *
	 * @return true, if successful
	 */
	public boolean hayGanadorEnDiagonal() {
		if (matriz[0][0] == this.jugadorActual && matriz[1][1] == this.jugadorActual
				&& matriz[2][2] == this.jugadorActual) {
			return true;
		}
		if (matriz[0][2] == this.jugadorActual && matriz[1][1] == this.jugadorActual
				&& matriz[2][0] == this.jugadorActual) {
			return true;
		}
		return false;

	}

	/**
	 * Esta tablero lleno.
	 *
	 * @return true, if successful
	 */
	public boolean estaTableroLleno() {
		boolean matrizLlena = true;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (matriz[i][j] == '-') {
					matrizLlena = false;
				}
			}
		}
		if (matrizLlena) {
			this.tableroLLeno = true;
		}
		return matrizLlena;
	}

}
