package com.paula.hospital.dtos;

public class EstadoCitaDTO {

	private int id;
	private String estado;

	public EstadoCitaDTO(int id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
