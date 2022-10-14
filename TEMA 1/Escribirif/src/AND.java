
public class AND {
	
	public static void main(String[] args) {
		
		int numeroHijos = 1;
		boolean familiaMonoparental;
		familiaMonoparental = false; 
		
		if (numeroHijos > 2 && familiaMonoparental) {
			System.out.println("La matrícula sale gratis");
		} else if (numeroHijos > 3 && !familiaMonoparental) {
			System.out.println("Tienes un descuento en la matrícula de un 10%");
		} else {
			System.out.println("Pagas como tol mundo");
		}
	}}
 