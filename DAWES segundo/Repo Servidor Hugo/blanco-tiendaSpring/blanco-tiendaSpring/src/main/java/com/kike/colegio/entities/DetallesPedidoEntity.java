package com.kike.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetallesPedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Detalle")
	private Integer idDetalle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Pedido")
	private PedidosEntity peticion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Producto")
	private ProductoEntity producto;
	@Column(name = "Cantidad")
	private Integer cantidad;

	@Column(name = "PrecioUnitario")
	private Double precioUnitario;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public PedidosEntity getPeticion() {
		return peticion;
	}

	public void setPeticion(PedidosEntity peticion) {
		this.peticion = peticion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

}
