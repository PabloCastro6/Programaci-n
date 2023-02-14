
public class HundirLaFlota {
	public static void main(String[] args) {
	//	Tablero t1 = new Tablero();
	//	t1.imprimeTablero();
		
		boolean modoDebug = false;
		if(args.length>0) {
			if (args[0].equals("--debug")) {
				System.out.println("Ejecucion Debug");
				modoDebug = true;
				Juego Hundir = new Juego(modoDebug);
			}
		}else {
			
			Juego Hundir = new Juego(modoDebug);
		}
	}
	
}

