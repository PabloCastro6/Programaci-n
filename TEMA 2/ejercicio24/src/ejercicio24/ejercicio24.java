package ejercicio24;

public class ejercicio24 {

	public static void main(String[] args) {
char letra = 'c' ;
if (('a' <= letra) && (letra >='z') || ('A' <= letra)&& (letra >='z')) {
		
		switch (letra) {
		case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' :
			System.out.println("la" +letra+ "es vocal");
		break;
		default:
			System.out.println("la" +letra+ "es consonante");
		}
}else {
	System.out.println("el caracter introducido no pertenece al abecedario");
}

	}

}
