import java.util.Scanner;

public class OperacionesDeSuma {
	int numero;
	int resultado = 0;
	public void imprimirSumaAcumulada() {
		System.out.println("Introduzca un numero:");
		Scanner sc = new Scanner (System.in);
		numero = sc.nextInt();
		sc.nextInt();
		for (int i=0; i<=numero;i++)  {
			resultado = resultado+i;
			System.out.print(i );
			if (i<numero)
			{
				System.out.print("+");
			}
		}
		System.out.println("=" + resultado);
			
		}
	}


