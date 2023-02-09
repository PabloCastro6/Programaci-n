import java.util.Scanner;

public class Principal {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("*****************************************************************");
		System.out.println("********************APLICACIÓN RESERVAS HOTEL********************");
		System.out.println("*****************************************************************");
		System.out.println("");
		System.out.println("Introduzca los datos para crear un cliente......");
		
		//Input the client's data
		System.out.println("Introduzca el dni: ");
		String dni = sc.nextLine();
		System.out.println("Introduzca el nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido: ");
		String apellido = sc.nextLine();
		Cliente clienteObj = new Cliente(dni, nombre, apellido);
		
		//Input data about the room
		System.out.println("");
		System.out.println("Introduzca los datos para crear una habitación...... ");
		System.out.println("Introduzca el número de habitación: ");
		int numeroHabitacion = sc.nextInt();
		System.out.println("Introduzca el número de planta: ");
		int numeroPlanta = sc.nextInt();
		Habitacion habitacionObj = new Habitacion(numeroHabitacion, numeroPlanta);
		System.out.println("");
		
		//Reservation or declaration
		Reservas reservasObj = new Reservas();
		int option = 0;
		do {
		System.out.println("¿Qué operación desea realizar ahora?");
		System.out.println("");
		System.out.println("1-Reservar la habitación al cliente: " + clienteObj.getNombre() + " en la habitación: " + habitacionObj.getNumeroHabitacion());
		System.out.println("2-Anular la reserva del cliente: " + clienteObj.getNombre() + " en la habitación: " + habitacionObj.getNumeroHabitacion());
		System.out.println("3-Salir de aplicación....");
		
		option = sc.nextInt();
		switch(option) {
		case 1:{
			reservasObj.reservarHabitacion(clienteObj, habitacionObj);
			break;
			}
		case 2:{
			reservasObj.anularReserva(clienteObj, habitacionObj);
			break;
		}
		case 3: {
			System.out.println("La aplicación de reservas ha terminado. Bye!");
			break;
		}
		default:{
			System.out.println("Debe elegir una opción entre 1 y 3 ");
		}
		}
		}while(option != 3);
	}
}
