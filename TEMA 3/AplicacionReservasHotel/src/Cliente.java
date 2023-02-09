import java.util.Scanner;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private Habitacion habitacion;
	
	//Encapsulación (getters, setters)
	public String getDni(){
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Habitacion habitacion(){
	 return habitacion;
	 }
	
	public void setDni(String dni){
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	//Constructor
	public Cliente(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		System.out.println("Cliente con dni: " + this.dni + ", nombre: " + this.nombre + " y apellido: " + this.apellido + " CREADO.");
	}
}
