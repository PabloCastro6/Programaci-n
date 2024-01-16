package com.paula.hospital.dtos;

public class DepartamentoDTO {

	private int id;
	private String nombre;
	private String descripcion;
	private int activo;

	public DepartamentoDTO(int departamentoId, String nombre, String descripcion, int activo) {
		super();
		this.id = departamentoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int departamentoId) {
		this.id = departamentoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
