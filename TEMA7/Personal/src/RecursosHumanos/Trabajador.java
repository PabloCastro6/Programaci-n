package RecursosHumanos;

public class Trabajador {
 private String nombre;
 private Integer id;
 private double salario;
 private double impuestos;
 
 
 public Trabajador(String nombre, Integer id, double salario, double impuestos) {
	 
	 super();
	 this.nombre = nombre;
	 this.id = id;
	 this.salario = salario;
	 this.impuestos = impuestos;
 }
 
 
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}
public double getImpuestos() {
	return impuestos;
}
public void setImpuestos(double impuestos) {
	this.impuestos = impuestos;
}
 
public double calculoSalario() {
	return this.salario - impuestos;
	
}

public void guardar() {
	System.out.println("Guardando en la BBDD el empleado" + this.getNombre());
}

public void  actualizar() {
	System.out.println("Actualizando en la BBDD el empleado" + this.getNombre());
}

public void borrar() {
	System.out.println("Borrando en la BBDD el empleado" + this.getSalario());
}
public void crear() {
	System.out.println("Actualizando en la BBDD el empleado" + this.());
}
