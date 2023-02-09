import java.util.*;
public class Principal {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Scanner line = new Scanner(System.in);
		String titulo, titulo2, autor, autor2;
		int numEjemplares, numEjemplaresPrestados, numEjemplares2, numEjemplaresPrestados2;
		
		System.out.println("El libro uno.");
		System.out.println("El título del libro: ");
		titulo = sc.nextLine();
		System.out.println("El autor del libro: ");
		autor = sc.nextLine();
		System.out.println("Número de ejemplares del libro: ");
		numEjemplares = sc.nextInt();
		System.out.println("Número de ejemplares prestados: ");
		numEjemplaresPrestados = sc.nextInt();
		Libro libroUno = new Libro(titulo, autor, numEjemplares, numEjemplaresPrestados);
		libroUno.prestamo();
		libroUno.devolucion();
		
		System.out.println("");
		System.out.println("El libro dos.");
		System.out.println("El título del libro: ");
		titulo2 = line.nextLine();
		System.out.println("El autor del libro: ");
		autor2 = line.nextLine();
		System.out.println("Número de ejemplares del libro: ");
		numEjemplares2 = sc.nextInt();
		System.out.println("Número de ejemplares prestados: ");
		numEjemplaresPrestados2 = sc.nextInt();
		Libro libroDos = new Libro();
			libroDos.setTitulo(titulo2);
			libroDos.setAutor(autor2);
			libroDos.setNumEjemplares(numEjemplares2);
			libroDos.setNumEjemplaresPrestados(numEjemplaresPrestados2);
			libroDos.prestamo();
			
		System.out.println("First book(constructor with parameters):");
		libroUno.toString(libroUno);
		System.out.println("");
		System.out.println("Second book(default constructor):");
		libroDos.toString(libroDos);
	}
}
