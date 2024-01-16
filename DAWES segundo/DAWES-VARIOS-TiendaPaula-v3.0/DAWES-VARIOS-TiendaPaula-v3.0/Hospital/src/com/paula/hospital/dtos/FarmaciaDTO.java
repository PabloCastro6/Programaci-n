package com.paula.hospital.dtos;

public class FarmaciaDTO {

	private int id;
	private String nombre;
	private String descripcion;
	private int cantidadDisponible;
	private double precio;

	public FarmaciaDTO(int id, String nombre, String descripcion, int cantidadDisponible, double precio) {
		super();
		this. id =  id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadDisponible = cantidadDisponible;
		this.precio = precio;
	}

	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this. id = id;
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

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
