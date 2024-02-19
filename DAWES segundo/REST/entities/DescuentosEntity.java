package com.chuchi.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "descuentos")
public class DescuentosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddescuentos")
	private Integer id;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "descuento")
	private Integer descuento;
	
	

	public DescuentosEntity(Integer id, Integer cantidad, Integer descuento) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}

	public DescuentosEntity() {
		super();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	
	
	@Override
	public String toString() {
		return "DescuentosEntity [id=" + id + ", cantidad=" + cantidad + ", descuento=" + descuento + "]";
	}

}
