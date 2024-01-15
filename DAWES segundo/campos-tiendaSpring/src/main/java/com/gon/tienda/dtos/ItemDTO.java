package com.gon.tienda.dtos;

public class ItemDTO {
	
	private Integer ClienteID;
	private String clienteNombre;
	private Integer productoID;
	private String productoNombre;
	private Integer cantidad;
	private Double cantidadPagar;
	
	public ItemDTO(Integer clienteID, String clienteNombre, Integer productoID, String productoNombre, Integer cantidad,
			Double cantidadPagar) {
		super();
		ClienteID = clienteID;
		this.clienteNombre = clienteNombre;
		this.productoID = productoID;
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.cantidadPagar = cantidadPagar;
	}

	public ItemDTO() {
		super();
	}

	public Integer getClienteID() {
		return ClienteID;
	}

	public void setClienteID(Integer clienteID) {
		ClienteID = clienteID;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public Integer getProductoID() {
		return productoID;
	}

	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidadPagar() {
		return cantidadPagar;
	}

	public void setCantidadPagar(Double cantidadPagar) {
		this.cantidadPagar = cantidadPagar;
	}
	
	

}
