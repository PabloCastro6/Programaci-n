package ejercicio16;

public class ejercicio16 {

	public static void main(String[] args) {
		
		int diaSemana = 3;
		String dia;

		switch (diaSemana) {

		case 1:
			dia = "Lunes";
			break;
		case 2:
			dia = "Martes";
			break;
		case 3:
			dia = "Miercoles";
			break;
		case 4:
			dia = "Jueves";
			break;
		case 5:
			dia = "Viernes";
			break;
		case 6:
			dia = "Sabado";
			break;
		case 7:
			dia = "Domingo";
			break;
		default:
			dia = "El número no es válido, debe estar entre el 1 y 7";
		}
		System.out.print("El día de la semana correspondiente al número " + diaSemana + " es: " + dia + ".");

	}

}
