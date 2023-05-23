package com.Pablo.classicmodels.dtos;

public class ClienteDTO {
	
	private String nombre;
	private String telefono;
	
	public ClienteDTO (String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
	
	

}
