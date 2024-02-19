package com.kike.colegio.dtos;

public class ItemDTO {

	private String clienteID;
	private String clienteNombre;
	private String productoID;
	private String productoNombre;
	private String cantidad;
	private String cantidadPagar;

	public ItemDTO(String clienteID, String clienteNombre, String productoID, String productoNombre, String cantidad,
			String cantidadPagar) {
		super();
		this.clienteID = clienteID;
		this.clienteNombre = clienteNombre;
		this.productoID = productoID;
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.cantidadPagar = cantidadPagar;
	}

	public String getClienteID() {
		return clienteID;
	}

	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public String getProductoID() {
		return productoID;
	}

	public void setProductoID(String productoID) {
		this.productoID = productoID;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return cantidadPagar;
	}

	public void setPrecio(String cantidadPagar) {
		this.cantidadPagar = cantidadPagar;
	}

}
