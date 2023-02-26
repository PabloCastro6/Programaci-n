
public class Juego {
	public Juego(boolean debug) {
	//	Tablero jugar = new Tablero();
		//do {
		//	jugar.imprimirTablero(debug);
		//	jugar.actualizarTablero();
		//} while (!jugar.todosHundidos()&&jugar.quedaMunicion());
	//	if(jugar.todosHundidos()) {
	//		System.out.println("Hundiste todos los barcos");
	//	}
//	}
//}
		Tablero jugar = new Tablero();
	do {
		jugar.imprimeTablero();
		//jugar.actualizarTablero(); 
	} while(!jugar.todosHundidos()&&jugar.quedaMunicion());
	if(jugar.todosHundidos()) {
		System.out.println("Hundiste todos los barcos.");
	}
	}
}  

