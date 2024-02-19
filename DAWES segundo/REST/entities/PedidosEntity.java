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
@Table(name = "pedidos")
public class PedidosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private ClientesEntity cliente;
	
	@Column(name = "FechaPedido", insertable = false)
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name = "EstadoID")
	@JsonBackReference
	private EstadosPedidosEntity estado;
	
	@OneToMany(mappedBy = "pedido")
    private Set<DetallesPedidosEntity> detallesPedidos;

	
	
	public PedidosEntity(Integer id, ClientesEntity cliente, String fecha, EstadosPedidosEntity estado,
			Set<DetallesPedidosEntity> detallesPedidos) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.estado = estado;
		this.detallesPedidos = detallesPedidos;
	}

	public PedidosEntity() {
		super();
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientesEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClientesEntity cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public EstadosPedidosEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadosPedidosEntity estado) {
		this.estado = estado;
	}

	public Set<DetallesPedidosEntity> getDetallesPedidos() {
		return detallesPedidos;
	}

	public void setDetallesPedidos(Set<DetallesPedidosEntity> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}

	
	
	@Override
	public String toString() {
		return "PedidosEntity [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", estado=" + estado
				+ ", detallesPedidos=" + detallesPedidos + "]";
	}

}
