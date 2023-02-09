import javax.print.attribute.SetOfIntegerSyntax;

import java.util.Scanner;

public class Propietario {
	Scanner sc = new Scanner(System.in);
	private String dni;
	private String nombre;
	private String apellidos;

public void Propietario(String dni, String nombre, String apellidos) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	System.out.println("Cliente con DNI" +dni+ "nombre;" +nombre+  "y apellidos" +apellidos+ " CREADO," );
}
public void setDNI(String dni) {
	this.dni = dni;

}

public String getdni() {
	return dni;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getapellidos() {
	return apellidos;
}
}

