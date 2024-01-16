package com.paula.IMC.dtos;

import java.io.Serializable;

public class imcDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private double imc;

	public imcDTO(String nombre, double imc) {
		super();
		this.nombre = nombre;

		this.imc = imc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

}
