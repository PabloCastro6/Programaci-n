
public class HundirLaFlota {
	public static void main(String[] args) {
			boolean modoDebug = false;
			if(args.length>0) {
				if(args[0].equals("--debug")) {
					modoDebug = true;
				}
			}
			Juego j = new Juego(modoDebug);
			
		}
	}
		

