package RecursosHumanos;

import java.nio.IntBuffer;

public class Freelance extends Trabajador {

	private Double tarifa;
	private Double horasTrabajadas;
	public Freelance(String nombre, Integer id, double salario, double impuestos) {
		super(nombre, id, salario, impuestos);
		// TODO Auto-generated constructor stub
	}
	public Freelance (String nombre, Integer id, Double tarifa, Double horasTrabajadas) {
		super(nombre, id,tarifa,horasTrabajadas);
		
		this.tarifa = tarifa;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public double calculoSalario() {
	return this.horasTrabajadas * this.tarifa;	
	}

}
