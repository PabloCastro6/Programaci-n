import java.util.Scanner;
public class ejercicio5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Ingrese el numero de filas");
		int filas = scanner.nextInt();
		System.out.println("Ingrese el numero de columnas");
		int columnas = scanner.nextInt();
		
		int [][] array = new int [filas] [columnas];
		
		for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el número en la posición (" + i + ", " + j + "): ");
                array[i][j] = scanner.nextInt();
            }
        }
System.out.println ("El array bidimensional creado es: ");
for (int i = 0; i < filas; i++) {
    for (int j = 0; j < columnas; j++) {
        System.out.print(array[i][j] + " ");
    }
    System.out.println();
}
scanner.close();  

	}
}


