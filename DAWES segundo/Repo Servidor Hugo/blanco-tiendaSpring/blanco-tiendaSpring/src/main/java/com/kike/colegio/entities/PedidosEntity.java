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

@Entity
@Table(name = "pedidos")
public class PedidosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Categoria")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Cliente")
	private ClienteEntity cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EstadoID")
	private EstadoPedidosEntity estado;
	@Column(name = "FechaAñadido")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAñadido;

	public PedidosEntity(int id, ClienteEntity cliente, EstadoPedidosEntity estado, Date fechaAñadido) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.estado = estado;
		this.fechaAñadido = fechaAñadido;
	}

	public PedidosEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public EstadoPedidosEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidosEntity estado) {
		this.estado = estado;
	}

	public Date getFechaAñadido() {
		return fechaAñadido;
	}

	public void setFechaAñadido(Date fechaAñadido) {
		this.fechaAñadido = fechaAñadido;
	}

}
