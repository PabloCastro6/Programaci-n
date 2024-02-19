package com.kike.colegio.dtos;

import java.sql.Timestamp;

public class PeticionesDTO {

	private String id;
	private String cliente;
	private String producto;
	private String cantidad;
	private String idCliente;
	private String idProducto;
	private String idCantidad;
	private String estado;
	private String fecha;
	private Timestamp fech;

	public PeticionesDTO(Integer id, String cliente, String producto, Integer cantidad, String estado, Timestamp fech) {
		this.id = String.valueOf(id);
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = String.valueOf(cantidad);
		this.estado = estado;
		this.fecha = fech.toString();
	}

	public PeticionesDTO(String id, String cliente, String producto, String cantidad, String estado, String fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.estado = estado;
		this.fecha = fecha;
	}

	public PeticionesDTO(String id, String cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}

	public PeticionesDTO(String id, String cliente, String producto, String cantidad, String idCliente,
			String idProducto, String idCantidad, String estado, String fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.idCantidad = idCantidad;
		this.estado = estado;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdCantidad() {
		return idCantidad;
	}

	public void setIdCantidad(String idCantidad) {
		this.idCantidad = idCantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
