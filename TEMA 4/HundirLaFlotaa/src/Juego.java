
import java.util.Scanner;

public class Juego {
	
	

	private Tablero t;
	private Scanner entrada = new Scanner (System.in);
	private int filaUsuario,colmunaUsuario;
	private int partesBarcosRestantes = Constantes.PARTES_BARCOS_RESTANTES;
	private int oportunidades = Constantes.OPORTUNIDADES_DISPARO;
	private boolean soyGanador = false;
	public Juego(boolean debug) {
		t = new Tablero(debug);
		t.imprimeTablero();
			
		do {
			solicitarCasilla();
			t.imprimeTablero();
		}while(!juegoTerminado());
		
		if(esGanador()) {
			System.out.println("Has ganado!");
		}else {
			System.out.println("Has perdido!");
		}
		System.out.println("Juego terminado");

	}
	

	public Tablero getTablero() {
		return t;
	}
	public void solicitarCasilla() {
		do {
			System.out.println("Inserta una fila: ");
			filaUsuario = entrada.nextInt();
			System.out.println("Inserta una columna: ");
			colmunaUsuario = entrada.nextInt();
			//System.out.println("Posicion elegida: [F:"+filaUsuario+" - C:"+colmunaUsuario+"]");
			if(filaUsuario>=t.getFilas() || colmunaUsuario>=t.getColumnas()) {
				System.out.println("Coordenadas invalidas");
			}	
		}while(filaUsuario>=t.getFilas() || colmunaUsuario>=t.getColumnas());
		consultarCasilla(filaUsuario,colmunaUsuario);
		
	}
	
	public void consultarCasilla(int f,int c) {
		if(t.getMatrizTablero()[f][c]!='~') {
			if(t.getMatrizTablero()[f][c]=='X') {
				System.out.println("En esta casilla ya hay una parte hundida");
				oportunidades--;
			}else {
				System.out.println("�Tocado!");
				partesBarcosRestantes--;
				t.setMatrizTableros('X', f, c);
			}
		}else {
			oportunidades--;
			System.out.println("�Agua!");
			t.setMatrizTableros('~', f, c);
		}
		
		//System.out.println("Partes Barco Rest: "+partesBarcosRestantes);
		System.out.println("Oportunidades: "+oportunidades);
	}
	
	public boolean juegoTerminado() {
		if(partesBarcosRestantes==0 || oportunidades==0) {
			if(partesBarcosRestantes==0 && oportunidades>0) {
				soyGanador = true;
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esGanador() {
		return soyGanador;
	}
	

}