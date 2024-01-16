package com.paula.hospital.dtos;

public class HistorialMedicoDTO {

	private int id;
	private String fecha;
	private String diagnostico;
	private String tratamiento;
	private String nombrePaciente;
	private String nombreMedico;

	public HistorialMedicoDTO(int id, String fecha, String diagnostico, String tratamiento, String nombrePaciente,
			String nombreMedico) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
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

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
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

}
