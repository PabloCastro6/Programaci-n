
public class HundirLaFlota {
	public static void main(String[] args) {
	
			Tablero t1 = null; 
			Juego j = null;
			if(args.length>0) {
				if(args[0].equals("--debug")) {
					 t1 = new Tablero();
					 t1.imprimeTablero();
						
					 j = new Juego(t1);
				}
			}else {
				 t1 = new Tablero();
				 t1.imprimeTablero();
				 j = new Juego(t1);
			}

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


