package ejercicio17;

public class ejercicio17 {

	public static void main(String[] args) {

		int variableUno = 7, variableDos = 19, resultado = 0;
		char operacion = '¡';
		boolean operacionCorrecta = true;

		switch (operacion) {

		case '+':
			resultado = variableUno + variableDos;
			break;

		case '-':
			resultado = variableUno - variableDos;
			break;

		case 'x':
			resultado = variableUno * variableDos;
			break;

		case 'X':
			resultado = variableUno * variableDos;
			break;

		case '/':
			resultado = variableUno / variableDos;
			break;

		case '%':
			resultado = variableUno % variableDos;
			break;

		default:
			operacionCorrecta = false;
			break;
		}

		if (operacionCorrecta) {
			System.out.println("El resultado de la operación es: " + resultado + ".");
		}
	}

}
