package com.Pablo.Hospital;

public class PacienteDTO implements Comparable<PacienteDTO> {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Integer edad;
	
	
	
	
	
	public PacienteDTO() {
		super();
	}
	public PacienteDTO(String nombre, String apellido1, String apellido2, Integer edad) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(PacienteDTO o) {
		// TODO Auto-generated method stub
		return this.edad.compareTo(o.getEdad());
	}
	@Override
	public String toString() {
		return "PacienteDTO [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad="
				+ edad + "]";
	}

}
