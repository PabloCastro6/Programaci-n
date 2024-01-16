import java.util.Random;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		String[] nombres = {"Lali", "Alberto", "Paula", "Sergio"};
		
		Random rand = new Random();
		
		int posicionNombre = rand.nextInt(nombres.length);
		
		String nombreAleatorio = nombres[posicionNombre];
		
		System.out.println(nombreAleatorio);
	}

}
