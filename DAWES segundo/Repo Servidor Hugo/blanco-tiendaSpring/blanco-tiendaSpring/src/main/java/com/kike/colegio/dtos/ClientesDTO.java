package com.kike.colegio.dtos;

public class ClientesDTO {
	private String id;
	private String nombre;
	private String correo;
	private String poblacion;
	private String activo;
	private String nombrePoblacion;

	public ClientesDTO(String id, String nombre, String correo, String poblacion, String nombrePoblacion,
			String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.poblacion = poblacion;
		this.nombrePoblacion = nombrePoblacion;
		this.activo = activo;
	}

	public ClientesDTO(String id, String nombre, String correo, String poblacion, String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.poblacion = poblacion;
		this.activo = activo;
	}

	public String getNombrePoblacion() {
		return nombrePoblacion;
	}

	public void setNombrePoblacion(String nombrePoblacion) {
		this.nombrePoblacion = nombrePoblacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}
