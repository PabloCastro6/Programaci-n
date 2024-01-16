package com.paula.hospital.dtos;

public class HabitacionDTO {

	private int id;
	private String tipo;
	private String estado;
	private double costoPorDia;

	public HabitacionDTO(int id, String tipo, String estado, double costoPorDia) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.estado = estado;
		this.costoPorDia = costoPorDia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCostoPorDia() {
		return costoPorDia;
	}

	public void setCostoPorDia(double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

}
