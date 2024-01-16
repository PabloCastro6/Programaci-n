package com.paula.hospital.dtos;

public class FacturacionDTO {

	private int id;
	private String nombrePaciente;
	private String fecha;
	private double monto;
	private String estado;

	public FacturacionDTO(int id, String nombrePaciente, String fecha, double monto, String estado) {
		super();
		this.id = id;
		this.nombrePaciente = nombrePaciente;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
