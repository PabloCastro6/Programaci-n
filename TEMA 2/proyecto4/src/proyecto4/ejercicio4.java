package proyecto4;

public class ejercicio4 {

	public static void main(String[] args) {
		int año = 2004; 
		if (año % 400 == 0) {
		System.out.println("Es bisiesto");
		
	} else if (año % 4==0 && año % 1 != 0) { System.out.println("Es bisiesto");
	}System.out.println("No es bisiesto");
	
	}
}