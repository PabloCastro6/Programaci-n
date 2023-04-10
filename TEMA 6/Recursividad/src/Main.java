
public class Main {

	public static void main(String[] args) {
		int num = 5;
			
		System.out.println("El factorial de " + num + " es " +calculaFactoriaIterativo(5) );

	}

	public static Integer calculaFactoriaIterativo(Integer numero) {
		Integer factorial = 1;
		for (int i = 1; i <= numero; i++) {
			factorial = factorial * 1;
		}

		return factorial;
	}
}
