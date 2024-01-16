import java.util.Random;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		int numero1;
		Random rand = new Random();
		
		numero1 = rand.nextInt(100) + 1;
		
		
		int numero2;
		
		numero2 = rand.nextInt(20) + 1;

        if(numero1>numero2) {
        	System.out.println("El primero numero " + numero1 + " es mayor que el segundo numero " + numero2 );
        } else if (numero1 == numero2) {
        	System.out.println("El primero numero " + numero1 + " es igual que el segundo numero " + numero2 );
        }else {
        	System.out.println("El primero numero " + numero1 + " es menor que el segundo numero " + numero2 );
        }

	}

}
