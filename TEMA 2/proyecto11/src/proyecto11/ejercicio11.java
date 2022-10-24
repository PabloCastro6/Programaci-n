package proyecto11;

public class ejercicio11 {

	public static void main(String[] args) {
		float consumoReal = 100f;

		if (consumoReal < constantes.limiteUno) {
			System.out.println("El precio de la unidad correspondiente al consumo " + consumoReal + " es "
					+ constantes.precioUno + ".");
		} else if (consumoReal >= constantes.limiteUno && consumoReal <= constantes.limiteDos) {
			System.out.println("El precio de la unidad correspondiente al consumo " + consumoReal + " es "
					+ constantes.precioDos + ".");
		} else if (consumoReal > constantes.limiteDos && consumoReal <= constantes.limiteTres) {
			System.out.println("El precio de la unidad correspondiente al consumo " + consumoReal + " es "
					+ constantes.precioTres + ".");
		} else {
			System.out.println("El precio de la unidad correspondiente al consumo " + consumoReal + " es "
					+ constantes.precioCuatro + ".");
		}
	}

}
