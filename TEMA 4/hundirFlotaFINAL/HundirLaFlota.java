package hundirLaFlota.versionPablo;
public class HundirLaFlota {
	public static void main(String[] args) {
		Tablero t1 = new Tablero();
		t1.imprimeTablero();
		Juego j = new Juego(t1);
		
		do {
			j.solicitarCasilla();
			t1.imprimeTablero();
		}while(!j.juegoTerminado());
		
		if(j.esGanador()) {
			System.out.println("Has ganado!");
		}else {
			System.out.println("Has perdido!");
		}
		System.out.println("Juego terminado");
		
		
	}
}
