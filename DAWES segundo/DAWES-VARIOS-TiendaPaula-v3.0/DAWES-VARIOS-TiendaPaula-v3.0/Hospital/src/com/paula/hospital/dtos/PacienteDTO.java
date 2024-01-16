package com.paula.hospital.dtos;

public class PacienteDTO {

	private int id;
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;
	private String dni;
	private String direccion;
	private String telefono;
	private String correo;
	private String historiaMedica;
	private String descripcionAlergia;

	public PacienteDTO(int id, String nombre, String apellido, String fechaDeNacimiento, String dni, String direccion,
			String telefono, String correo, String historiaMedica, String descripcionAlergia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.historiaMedica = historiaMedica;
		this.descripcionAlergia = descripcionAlergia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getHistoriaMedica() {
		return historiaMedica;
	}

	public void setHistoriaMedica(String historiaMedica) {
		this.historiaMedica = historiaMedica;
	}

	public String getDescripcionAlergia() {
		return descripcionAlergia;
	}

	public void setDescripcionAlergia(String descripcionAlergia) {
		this.descripcionAlergia = descripcionAlergia;
	}

}