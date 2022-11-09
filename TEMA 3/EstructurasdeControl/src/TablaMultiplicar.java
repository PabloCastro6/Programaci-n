import java.util.Scanner;

public class TablaMultiplicar {
	int numeroTabla = 5;
	public void imprimirTablaMultiplicar() {
		System.out.println("introduzca un numero:");
		Scanner sc = new Scanner (System.in);
		numeroTabla = sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		System.out.println(" Tabla del " + numeroTabla);
		for (int i = 1; i <= 10; i++);
		System.out.println();
	}

}
	