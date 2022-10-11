
public class Ejercicio28 {
	public static void main(String[] args) {
		float altura = (float) 1.77;
		int edad = 22;
		float peso = (float) 81.3;
		
		float resultado;
		
		resultado = (float) (2.447 - (0.09156 * edad)+ (0.1074 * altura) + (0.3362 * peso));
		
		System.out.println("El BTW del paciente con " + edad + " y altura de " + altura + " metros es de: " + resultado);
		
		
	}

}
