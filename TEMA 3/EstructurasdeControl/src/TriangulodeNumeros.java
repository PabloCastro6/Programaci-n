import java.util.Scanner;

public class TriangulodeNumeros {
	int numero;
	
	public void imprimirTriangulo() {
		System.out.println("introducir un numero: ");
		Scanner sc= new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		for (int i= 1; i<= numero; i++) {
			for (int x=1; x<=i; x++) {
				System.out.println( x + " ");
			}
			System.out.println("");
		}
	}

	public void imprimirTrianguloInvertido() {
		System.out.println("introducir un numero: ");
		Scanner sc= new Scanner(System.in);
		numero = sc.nextInt();
		sc.nextLine();
		for (int i= 0; i <=1 ; i++) {
			for (int x = numero; x >=i; x--) {
				System.out.println( x + " ");
			}
			System.out.println("");
		}
	}
}

