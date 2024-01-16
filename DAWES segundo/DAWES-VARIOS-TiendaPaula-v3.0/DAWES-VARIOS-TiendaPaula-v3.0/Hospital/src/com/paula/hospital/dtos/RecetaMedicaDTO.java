package com.paula.hospital.dtos;

public class RecetaMedicaDTO {

	private int id;
	private int pacienteId;
	private int medicoId;
	private int medicamenteId;
	private String fecha;
	private int cantidadPrescrita;
	private String nombrePaciente;
	private String nombreMedico;
	private String nombreMedicamento;

	public RecetaMedicaDTO(int id, int pacienteId, int medicoId, int medicamenteId, String fecha,
			int cantidadPrescrita) {
		super();
		this.id = id;
		this.pacienteId = pacienteId;
		this.medicoId = medicoId;
		this.medicamenteId = medicamenteId;
		this.fecha = fecha;
		this.cantidadPrescrita = cantidadPrescrita;
	}

	public RecetaMedicaDTO(int id, String fecha, String nombrePaciente, String nombreMedico,
			String nombreMedicamento, int cantidadPrescrita) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cantidadPrescrita = cantidadPrescrita;
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
		this.nombreMedicamento = nombreMedicamento;
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

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public int getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}

	public int getMedicamenteId() {
		return medicamenteId;
	}

	public void setMedicamenteId(int medicamenteId) {
		this.medicamenteId = medicamenteId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidadPrescrita() {
		return cantidadPrescrita;
	}

	public void setCantidadPrescrita(int cantidadPrescrita) {
		this.cantidadPrescrita = cantidadPrescrita;
	}

}
