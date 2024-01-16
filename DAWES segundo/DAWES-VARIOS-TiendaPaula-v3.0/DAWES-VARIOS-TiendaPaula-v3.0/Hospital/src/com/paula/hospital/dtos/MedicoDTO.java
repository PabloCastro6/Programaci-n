package com.paula.hospital.dtos;

public class MedicoDTO {

	private int medicoId;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String licenciaMedica;
	private String telefono;
	private String correo;

	public MedicoDTO(int medicoId, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correo) {
		super();
		this.medicoId = medicoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.licenciaMedica = licenciaMedica;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getLicenciaMedica() {
		return licenciaMedica;
	}

	public void setLicenciaMedica(String licenciaMedica) {
		this.licenciaMedica = licenciaMedica;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
