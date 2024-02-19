package com.kike.colegio.dtos;

public class PedidosDTO {
	private String id;
	private String idcliente;
	private String cliente;
	private String idproducto;
	private String producto;
	private String cantidad;
	private String fecha;
	private String estado;
	private String precio;

	public PedidosDTO(String id, String idcliente, String idproducto, String cantidad, String precio) {
		super();
		this.id = id;
		this.idcliente = idcliente;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public PedidosDTO(String idcliente, String cliente, String idproducto, String producto, String cantidad,
			String precio) {
		super();
		this.idcliente = idcliente;
		this.cliente = cliente;
		this.idproducto = idproducto;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public PedidosDTO(String id, String cliente, String estado, String fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.estado = estado;
		this.fecha = fecha;
	}

	public PedidosDTO(String cliente, String fecha, String estado) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.estado = estado;
	}

	public PedidosDTO(String id, String precio) {
		super();
		this.id = id;
		this.precio = precio;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
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

}
