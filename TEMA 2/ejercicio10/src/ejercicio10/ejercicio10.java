package ejercicio10;

public class ejercicio10 {

	public static void main(String[] args) {
		float matematicas = 8f;
		float fisica = 9f;
		float quimica = 4.9f;
		float notaMedia;
		notaMedia = (matematicas + fisica + quimica) / 3;

		if ((matematicas >= 6.5 && fisica >= 6 && quimica >= 5) || notaMedia > 7) {
			System.out.println("El alumno es elegible para realizar los estudios.");
		} else {
			System.out.println("El alumno no es elegible para realizar los estudios.");
		}
	}

}
