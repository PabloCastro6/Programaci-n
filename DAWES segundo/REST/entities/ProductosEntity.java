package com.chuchi.tienda.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "CantidadEnStock")
    private Integer cantidadEnStock;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private CategoriasEntity categoria;
    
    @ManyToOne
    @JoinColumn(name = "ID_Proveedor")
    @JsonBackReference
    private ProveedorEntity proveedor;


    @OneToMany(mappedBy = "producto")
    private Set<PeticionesEntity> peticiones;

    @OneToMany(mappedBy = "producto")
    private Set<DetallesPedidosEntity> detallePedidos;

    
    
	public ProductosEntity(int id, String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriasEntity categoria, ProveedorEntity proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public ProductosEntity(int id, String nombre, String descripcion, Double precio, Integer cantidadEnStock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
	}

	public ProductosEntity() {
		super();
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

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	
	public CategoriasEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriasEntity categoria) {
		this.categoria = categoria;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	
	
	@Override
	public String toString() {
		return "ProductosEntity [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", cantidadEnStock=" + cantidadEnStock + "]";
	}

}
