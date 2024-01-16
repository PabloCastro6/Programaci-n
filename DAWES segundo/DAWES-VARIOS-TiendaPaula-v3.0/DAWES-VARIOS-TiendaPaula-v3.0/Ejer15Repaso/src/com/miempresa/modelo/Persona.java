package com.miempresa.modelo;

import com.miempresa.utilidades.Calculadora;

public class Persona {
	private String nombre;
	private double estatura;
	private double peso;

	public Persona(String nombre, double estatura, double peso) {
		this.nombre = nombre;
		this.estatura = estatura;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double calcularIGC() {
		return Calculadora.calcularIGC(estatura, peso);
	}
}