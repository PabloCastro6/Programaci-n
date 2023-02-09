import java.util.Scanner;

public class Habitacion {
	private int numeroHabitacion;
	private int numeroPlanta;
	private boolean ocupada;
	
	//Encapsulación
	//Getters
	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	public int getNumeroPlanta() {
		return numeroPlanta;
	}
	public boolean getOcupada() {
		return ocupada;
	}
	
	//Setters
	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	public void setNumeroPlanta(int numeroPlanta) {
		this.numeroPlanta = numeroPlanta;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	//Constructor
	public Habitacion(int numeroHabitacion, int numeroPlanta) {
		this.numeroHabitacion = numeroHabitacion;
		this.numeroPlanta = numeroPlanta;
		this.ocupada = false;
		System.out.println("La habitación con numero: " + this.numeroHabitacion + " en planta: " + this.numeroPlanta + " ha sido creada.");
	}
}
