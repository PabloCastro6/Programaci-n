package com.paula.hospital.dtos;

public class CitaDTO {

	private int id;
	private String fecha;
	private String hora;
	private String nombrePaciente;
	private String nombreMedico;
	private String estadoCita;

	public CitaDTO(int id, String fecha, String hora, String nombrePaciente, String nombreMedico, String estadoCita) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
		this.estadoCita = estadoCita;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
