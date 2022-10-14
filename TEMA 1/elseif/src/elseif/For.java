package elseif;

public class For {
	public static void main(String[] args) {
		
		int semanas = 3;
		int dias = 7;
		
		//El for exterior imprimira las semanas
		for (int i = 1; i <= semanas; i++) {
			System.out.println("Semana: " +i);
			//El for interior imprimirá los días
			for (int j = 1; j <= dias; j++) {
				System.out.println(" Dia: " + j);
			}
		}
	}

}
