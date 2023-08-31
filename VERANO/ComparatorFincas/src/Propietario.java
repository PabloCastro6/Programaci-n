import java.util.ArrayList;
import java.util.List;

public class Propietario implements Comparable<Propietario> {
private String nombre;
private Integer edad;
private String localidad;
private List<Finca> fincas = new ArrayList<>();

public Integer getNumeroFincas() {
	return fincas.size();
}



public Propietario(String nombre, Integer edad, String localidad) {
	super();
	this.nombre = nombre;
	this.edad = edad;
	this.localidad = localidad;
}



public Propietario(String nombre, Integer edad, String localidad, List<Finca> fincas) {
	super();
	this.nombre = nombre;
	this.edad = edad;
	this.localidad = localidad;
	this.fincas = fincas;
}



public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Integer getEdad() {
	return edad;
}

public void setEdad(Integer edad) {
	this.edad = edad;
}

public String getLocalidad() {
	return localidad;
}

public void setLocalidad(String localidad) {
	this.localidad = localidad;
}

public List<Finca> getFincas() {
	return fincas;
}

public void setFincas(List<Finca> fincas) {
	this.fincas = fincas;
}



@Override
public String toString() {
	return "Propietario [nombre=" + nombre + ", edad=" + edad + ", localidad=" + localidad + ", fincas=" + fincas + "]";
}

public int compareTo(Propietario o) {
	return -getNumeroFincas().compareTo(o.getNumeroFincas());
}

}
