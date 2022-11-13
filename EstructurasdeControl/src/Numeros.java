import java.util.Scanner;

public class Numeros {
	int numero;
	boolean esPrimo = true;
	int contador;
	
public void imprimirNumerosNaturales() {
	System.out.println("introducir numerosEnteros");
	Scanner sc = new Scanner(System.in);
	numero = sc.nextInt();
	for (int i = 0; i <= numero; i++) {
		System.out.println(i);
	}
}
public void imprimirNumerosPares() {
	System.out.println("introducir numeros");
	Scanner sc = new Scanner(System.in);
	numero = sc.nextInt();
	for (int i = 0; i <= numero; i++) {
		if ( i == 0)
			continue;
		if (i % 2 == 0)
			System.out.print(i + " " );
		else {
			continue;
		}
		contador++;
		
	}
	System.out.println( " ");
	System.out.println("Total" + contador + " pares entre el 0 y el " + numero);
}
public void imprimirNumerosPrimos() {
	System.out.println("introducir numeros");
	Scanner sc = new Scanner(System.in);
	numero = sc.nextInt();
	System.out.println("Los numeros primos entre 0 y" + numero + " son ");
	if (0<numero);
	
	for (int i = 0; i <= numero; i++) {
		if(i == 1 || i == 0 || i==4)
		continue;
		
		esPrimo= true;
		for (int x = 2; x<= 1 / 2; ++x) {
			if ( 1 % x == 0) {
				esPrimo= false;
				continue;
				
			}
		}
		if (esPrimo == true) {
			contador++;
			System.out.print(i + " ");
			}
		}

		
	}

	
	
}



	

