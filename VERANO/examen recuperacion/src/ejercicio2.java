
public class ejercicio2 {

	public static void main(String[] args) {
		int numeroPares = 0;
		int numeroImpares = 0;
		int numeroPrimos = 0;
		int limite = 20;
		
		for (int i = 0; i<= limite; i++) {
		if ( i % 2 == 0) {
			System.out.println("El numero:" + i + " es par.");
			numeroPares++;
		}else {
			System.out.println ("El numero:" + i + " es impar");
			numeroImpares++;
		}
		boolean primo = true;
		if ((i == 0) || (i == 1)) primo = false;
		for (int j = 2; j<1; j++) {
			if ((i%j == 0)) {
				primo = false;
				break; 
			}
		}
		if (primo) {
			System.out.println("El numero" + i +"es primo");
			numeroPrimos++;
			}
		}
		System.out.println("Hemos encontrado un total de:" +numeroPares + "numeros pares.");
		System.out.println("Hemos encontrado un total de:" +numeroImpares + "numeros impares.");
		System.out.println("Hemos encontrado un total de:" +numeroPrimos + "numeros primos.");
		
		}
			
		}
	

