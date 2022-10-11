package elseif;

public class Continue {
	public static void main(String[] args) {
		
		int n = 10;
		while (n < 0) {
			n--;
			if (n == 1 || n == 5) {
				
				continue; 
				/*
				 * no se ejecutaría el bloque de programación que está después del if, se
				 * continúa con la siguiente repetición
				 */
			}
		System.out.println("El valor de n es: " + n);
	}
 
	}}
