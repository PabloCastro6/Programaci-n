package ejercicio23;

public class ejercicio23 {

	public static void main(String[] args) {
		char letra = 'a' ;
		
		switch (letra) {
		case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' :
			System.out.println("la" +letra+ "es vocal");
		break;
		default:
			System.out.println("la" +letra+ "es consonante");
		}

	}

}
