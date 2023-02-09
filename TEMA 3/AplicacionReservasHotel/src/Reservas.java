
public class Reservas {
	public void reservarHabitacion(Cliente clienteObj, Habitacion habitacionObj) {
		habitacionObj.setOcupada(true);
		clienteObj.setHabitacion(habitacionObj);
		System.out.println("La reserva de la habitación: " + habitacionObj.getNumeroHabitacion() + " ha quedado reservada por el cliente: " + clienteObj.getNombre() + "en la habitación: " + habitacionObj.getNumeroHabitacion());
	}
	
	public void anularReserva(Cliente clienteObj, Habitacion habitacionObj){
		clienteObj.setHabitacion(null);
		habitacionObj.setOcupada(false);
		System.out.println("La reserva de la habitación: " + habitacionObj.getNumeroHabitacion() + " al cliente " + clienteObj.getNombre() + " " + clienteObj.getApellido() + " ha quedado anulada.");
	}
}
