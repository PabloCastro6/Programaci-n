package elseif;

public class Break {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("El valor del índice es: "+ i);
			if (i == 3) {
				break;
			}
		}
	}

}
