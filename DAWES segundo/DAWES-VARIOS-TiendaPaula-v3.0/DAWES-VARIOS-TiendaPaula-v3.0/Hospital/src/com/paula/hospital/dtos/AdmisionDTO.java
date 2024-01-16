package com.paula.hospital.dtos;

public class AdmisionDTO {

	private int id;
	private int pacienteId;
	private int habitacionId;
	private String fechaDeIngreso;
	private String fechaDeSalida;
	private String motivo;
	private String tipoHabitacion;
	private String nombrePaciente;

	public AdmisionDTO(int id, int pacienteId, int habitacionId, String fechaDeIngreso, String fechaDeSalida,
			String motivo) {
		super();
		this.id = id;
		this.pacienteId = pacienteId;
		this.habitacionId = habitacionId;
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.motivo = motivo;
	}

	public AdmisionDTO(int id, String fechaDeIngreso, String fechaDeSalida, String motivo, String tipoHabitacion,
			String nombrePaciente) {
		super();
		this.id = id;
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.motivo = motivo;
		this.tipoHabitacion = tipoHabitacion;
		this.nombrePaciente = nombrePaciente;
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

	public int getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(int habitacionId) {
		this.habitacionId = habitacionId;
	}

	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(String fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

}
