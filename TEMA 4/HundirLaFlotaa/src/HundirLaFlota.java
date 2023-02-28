
public class HundirLaFlota {
	public static void main(String[] args) {
	//	Tablero t1 = new Tablero();
	//	t1.imprimeTablero();
		
		//boolean modoDebug = false;
	//	if(args.length>0) {
		//	if (args[0].equals("--debug")) {
		//		System.out.println("Ejecucion Debug");
			//	modoDebug = true;
		//		Juego Hundir = new Juego(modoDebug);
		//	}
	//	}else {
			
	//		Juego Hundir = new Juego(modoDebug);
//		}
	//}
	
//}
		
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

