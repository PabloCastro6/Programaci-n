import java.util.Random;

public class Ejercicio9 {

	public static void main(String[] args) {

		int numeroLanzamientos = 1000000;
		int cara = 0;
		int cruz = 0;

		Random rand = new Random();

		for (int i = 0; i < numeroLanzamientos; i++) {

			int resultado = rand.nextInt(2);

			if (resultado == 0) {
				cara++;
			}else {
				cruz++;
			}
		}
		System.out.println("El resultado de caras es " + cara);
		System.out.println("El resultado de cruces es " + cruz);
	}
}
