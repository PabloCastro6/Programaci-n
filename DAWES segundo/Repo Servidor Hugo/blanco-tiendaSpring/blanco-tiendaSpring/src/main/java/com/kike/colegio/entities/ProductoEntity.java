package com.kike.colegio.entities;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Producto")
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "Descripcion")
	private String descripcion;

	@Column(name = "Precio")
	private BigDecimal precio;

	@Column(name = "CantidadEnStock")
	private Integer cantidadEnStock;

	@ManyToOne
	@JoinColumn(name = "ID_Categoria")
	private CategoriaEntity categoria;

	@ManyToOne
	@JoinColumn(name = "ID_Proveedor")
	private ProveedorEntity proveedor;
	@OneToMany(mappedBy = "producto")
	private Set<PeticionesEntity> peticiones;

	@OneToMany(mappedBy = "producto")
	private Set<DetallesPedidoEntity> detalles;

	public ProductoEntity(int id, String nombre, String descripcion, BigDecimal precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedorEntity proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public ProductoEntity(String nombre, String descripcion, BigDecimal precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedorEntity proveedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public ProductoEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

}