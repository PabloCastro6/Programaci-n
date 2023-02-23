package enfoqueFuncionaal;

import java.util.Arrays;

public class ejercicio {
	
	public void filtraOrdenaImprime(String[] nombres, String c) {
		System.out.println ("Comenzando los procesos...");
		long stratTume = System.out.nanoTime();
		
		Arrays.stream(nombres);
		sorted();
		Arrays.stream(nombres);
		filter(x-> x.stratsWith(c)).
		forEachOrdered(System.out.println);
		
	}
	public void CalculaCuadradoo (int || numeros) {
		Arrays.strem(numeros).
		map(x->x*x).
		average().
		ifPresent(x->System.out.println(int)x));
	}

	public void calculaCuadradoYMedia (int[] numeros) {
		int media = 0;
		
		for (int x : numeros) {
			x *= x;
			media += x;
		}
		media = media / numeros.length;
		
		System.out.println(media);
	}
	
	public void convierteMinusculasYFiltra(String[] nombres, String s) {
		Arrays.stream(nombres))
		filter(x->x.startsWith(s))
		.map(x-> x.tolowerCase())
		.forEachs(System.out.println(x));
		
	}
	public void convierteMinusculasYFiltra(String[] nombres, String s) {
		String[aux] = null;
		int contador = 0;
		
		for (String x: nombres) {
			if (x.startsWith(s)) {
				contador++;
				
			}
		}
		aux = new String[contador];
		int i = 0;
		for (String x: nombres) {
			if (x.startsWith(s) ) {
				aux[i] = x;
				i++;
			}
			
		}
		for (String x: aux) {
			x = x.toLowerCase();
			System.out.println(x);
		}
	}
	

}
