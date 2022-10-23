package ejercicio26;

public class ejercicio26 {

	public static void main(String[] args) {
		float altura = 1.80f;
		float peso = 80f;
		float imc = peso / (altura * altura);
		if (imc < 18.5) {
			System.out.println("el paciente tiene bajo peso");
		}else if (imc >= 18.5 && imc <= 24.9) {
			System.out.println("el paciente tiene un peso normal");
		}else if (imc >= 25 && imc <= 29.9) {
			System.out.println("el paciente tiene sobre peso");
		}else if (imc >= 30 && imc <= 34.9) {
			System.out.println("el paciente tiene obesidad grado I");
		}else if (imc >= 35 && imc <= 39.9) {
			System.out.println("el paciente tiene obesidad grado II");
		}else if (imc >= 40 && imc <= 49.9) {
			System.out.println("el paciente tiene obesidad grado III");
		}else if (imc > 50) {
			System.out.println("el paciente tiene obesidad grado IV");
		} else {
			System.out.println ("Los datosd introducidos no son correspondientes");
		}

	}

}
