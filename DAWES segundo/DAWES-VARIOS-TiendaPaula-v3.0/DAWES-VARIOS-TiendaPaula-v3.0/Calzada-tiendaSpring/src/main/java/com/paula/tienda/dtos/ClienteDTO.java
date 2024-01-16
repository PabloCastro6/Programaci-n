package com.paula.tienda.dtos;

public class ClienteDTO {

	private Integer id;
	private String nombre;
	private String correo;
	private String poblacion;
	private Integer idPoblacion;
	private Integer activo;
	
	public ClienteDTO(Integer id, String nombre, String correo, String poblacion, Integer idPoblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.poblacion = poblacion;
		this.idPoblacion = idPoblacion;
		this.activo = activo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getIdPoblacion() {
		return idPoblacion;
	}
	public void setIdPoblacion(Integer idPoblacion) {
		this.idPoblacion = idPoblacion;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
	
	
}
