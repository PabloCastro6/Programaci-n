package com.paula.coches.dtos;

import java.io.Serializable;

public class CochesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private Integer numCoches;

	public CochesDTO(String nombre, Integer numCoches) {
		super();
		this.nombre = nombre;
		this.numCoches = numCoches;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumCoches() {
		return numCoches;
	}

	public void setNumCoches(Integer numCoches) {
		this.numCoches = numCoches;
	}
	
	
}
