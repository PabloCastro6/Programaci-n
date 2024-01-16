package com.paula.tienda.dtos;

public class ProductoDTO {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidad;
	private String categoria;
	private Integer idCategoria;
	private String proveedor;
	private Integer idProveedor;

	public ProductoDTO(Integer id, String nombre, String descripcion, Double precio, Integer cantidad, String categoria,
			Integer idCategoria, String proveedor, Integer idProveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.idCategoria = idCategoria;
		this.proveedor = proveedor;
		this.idProveedor = idProveedor;
	}
	
	

	public ProductoDTO(Integer id, String nombre, String descripcion, Double precio, Integer cantidad, String categoria,
			String proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.proveedor = proveedor;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

}
