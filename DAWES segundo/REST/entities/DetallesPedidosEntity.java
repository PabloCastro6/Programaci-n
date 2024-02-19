package com.chuchi.tienda.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetallesPedidosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Detalle")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_Pedido")
	@JsonBackReference
	private PedidosEntity pedido;
	
	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	@JsonBackReference
	private ProductosEntity producto;
	
	@Column(name = "Cantidad")
	private Integer cantidad;
	
	@Column(name = "PrecioUnitario")
	private Double precio;
	
	

	public DetallesPedidosEntity(Integer id, PedidosEntity pedido, ProductosEntity producto, Integer cantidad,
			Double precio) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public DetallesPedidosEntity() {
		super();
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PedidosEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidosEntity pedido) {
		this.pedido = pedido;
	}

	public ProductosEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductosEntity producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
	@Override
	public String toString() {
		return "DetallesPedidosEntity [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}

}
