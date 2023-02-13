
package src;
// TODO: Auto-generated Javadoc

/**
 * The Class juego.
 */
public class juego {

	/**
	 * Instantiates a new juego.
	 */
	public juego() {
		Tablero tablero = new Tablero();
		tablero.imprimeTablero();
		do {
			tablero.actualizaTablero();
			tablero.imprimeTablero();
		
			if (tablero.estaTableroLleno() && !tablero.victoria) {
				System.out.println("¡Ha habido empate!");
			}	
			
		}while(!tablero.hayGanador() && !tablero.estaTableroLleno());
		
		System.out.println("Juego terminado");
	
	}
	
}

