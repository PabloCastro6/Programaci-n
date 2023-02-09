import java.util.Scanner;

public class TablaMultiplicar {
	int resultado;

	public void imprimirTablaMultiplicar() {
		System.out.println("introduzca un numero:");
		Scanner sc = new Scanner(System.in);
		resultado = sc.nextInt();
		sc.nextLine();
		System.out.println(" Tabla del " + resultado);
		for (int x = 1; x < 9; x++) {

			for (int i = 1; i < 10; i++) {
				resultado = x * i;
				System.out.println(x + "x" + i + " = " + resultado + "|");
			}

		}
	}
}