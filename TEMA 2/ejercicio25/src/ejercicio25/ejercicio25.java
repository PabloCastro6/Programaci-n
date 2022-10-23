package ejercicio25;



public class ejercicio25 {

	public static void main(String[] args) {
		int ocular = 2;
		int verbal = 6;
		int motora = 2;
		int resultado = (ocular + verbal + motora);
		if (resultado >= 13 && resultado <= 15) {
			System.out.println("es  un traumatismo craneoencefalico leve");
		}else if (resultado >=9 && resultado <= 12) {
			System.out.println("traumatismo craneoencefalico moderado con" + resultado + "puntos");
		}else if (resultado < 9) {
			System.out.println("traumatismo craneoencefalico severo con" + resultado + "puntos");
		}else {
			System.out.println("los datos estan mal introducidos con" + resultado + "puntos");
		}
		}

	}
