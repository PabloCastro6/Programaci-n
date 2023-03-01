package hundirLaFlota.versionPablo;

import java.util.Scanner;

public class Juego {

	private Tablero t;
	private Scanner entrada = new Scanner (System.in);
	private int filaUsuario,colmunaUsuario;
	private int partesBarcosRestantes = 16;
	private int oportunidades = 10;
	private boolean soyGanador = false;
	public Juego(Tablero t) {
		this.t=t;
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
			System.out.println("Posicion elegida: [F:"+filaUsuario+" - C:"+colmunaUsuario+"]");
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
				partesBarcosRestantes--;
			}
		}else {
			oportunidades--;
		}
		t.setMatrizTablero('X', f, c);
		System.out.println("Partes Barco Rest: "+partesBarcosRestantes);
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
