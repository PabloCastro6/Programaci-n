package com.kike.colegio.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "peticiones")
public class PeticionesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Peticiones")
	private Integer idPeticiones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Cliente")
	private ClienteEntity cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Producto")
	private ProductoEntity producto;

	@Column(name = "FechaAñadido")
	@Transient
	private Date fechaAñadido;

	@Column(name = "Cantidad")
	private Integer cantidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Estado")
	private EstadoPedidosEntity estado;

	public PeticionesEntity(Integer idPeticiones, ClienteEntity cliente, ProductoEntity producto, Date fechaAñadido,
			Integer cantidad, EstadoPedidosEntity estado) {
		super();
		this.idPeticiones = idPeticiones;
		this.cliente = cliente;
		this.producto = producto;
		this.fechaAñadido = fechaAñadido;
		this.cantidad = cantidad;
		this.estado = estado;
	}

	public PeticionesEntity() {
		super();
	}

	public Integer getIdPeticiones() {
		return idPeticiones;
	}

	public void setIdPeticiones(Integer idPeticiones) {
		this.idPeticiones = idPeticiones;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Date getFechaAñadido() {
		return fechaAñadido;
	}

	public void setFechaAñadido(Date fechaAñadido) {
		this.fechaAñadido = fechaAñadido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public EstadoPedidosEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidosEntity estado) {
		this.estado = estado;
	}

}
