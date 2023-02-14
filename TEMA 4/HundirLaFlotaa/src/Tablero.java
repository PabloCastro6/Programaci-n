

import java.util.Scanner;

public class Tablero {

	Scanner sc = new Scanner(System.in);
	 int filas = 16;
     int columnas = 16;
	char tablero[][] = new char [filas][columnas];
	
	public Tablero() {
		System.out.println("Dentro");
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = '~' ;
			}
		}
//		colocaBarcos();
	}
		/*int filaBarco = 1,columnaBarco= 1;   //Obtener aleatoriamente
		int posicion = 1;   //1 Vertical, 0 Horizontal  Obtener aleatoriamente
		int barcoTresPosiciones [] = {1,1,1};
		for(int i = 0 ; i<barcoTresPosiciones.length;i++) {
			if(posicion==0) {
				tablero[filaBarco][columnaBarco] = barcoTresPosiciones[i];cha
				columnaBarco++;		
			}else {
				tablero[filaBarco][columnaBarco] = barcoTresPosiciones[i];
				filaBarco++;	
			}
		}
		}*/
		public void imprimeTablero() {
			System.out.println("Dentro de imprime tablero");
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					if (j + 1 == columnas) {
						System.out.print("| " + tablero[i][j] + " | ");
					} else {
						System.out.print("| " + tablero[i][j] + " ");
					}
				}
				System.out.println(" ");
			}
			
			
	
	}
	
		public void colocaBarcos() {
			//TODO: Crear tres bucles para colocar barcos
			colocaBarco(1);
			
			colocaBarco(2);
			
			colocaBarco(3);
		}
		
		public void colocaBarco(int tamanoBarco) {
			
//			TODO: Calcular una fila y una columna de manera random
			//TODO: Calcular un número que nos indicará la dirección de crecimiento
			
			
			
		}
		
		
	}

