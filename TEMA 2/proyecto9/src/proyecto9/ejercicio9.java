package proyecto9;

public class ejercicio9 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;

		if (x > 0 && y > 0) {
			System.out.println("El punto x=" + x + ", y=" + y + " pertenece al cuadrante I.");
		} else if (x < 0 && y > 0) {
			System.out.println("El punto x=" + x + ", y=" + y + " pertenece al cuadrante II.");
		} else if (x < 0 && y < 0) {
			System.out.println("el punto x=" + x + ", y=" + y + " pertenece al cuadrante III.");
		} else if (x == 0 && y == 0) {
			System.out.println("el punto x=" + x + ", y=" + y + " pertenece al origen.");
		} else {
			System.out.println("el punto x=" + x + ", y=" + y + " pertenece al cuadrante IV.");
		}
	}

}
