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
@Table(name = "peticiones")
public class PeticionesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Peticiones")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private ClientesEntity cliente;

	@ManyToOne
	@JoinColumn(name = "ID_Producto")
	@JsonBackReference
	private ProductosEntity producto;

	@Column(name = "FechaAñadido", insertable = false)
	private String fecha;

	@Column(name = "cantidad")
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "estado")
	@JsonBackReference
	private EstadosPedidosEntity estado;
	
	
	
	public PeticionesEntity(Integer id, ClientesEntity cliente, ProductosEntity producto, String fecha,
			Integer cantidad, EstadosPedidosEntity estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estado = estado;
	}
	
	public PeticionesEntity() {
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

	public ProductosEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductosEntity producto) {
		this.producto = producto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public EstadosPedidosEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadosPedidosEntity estado) {
		this.estado = estado;
	}

	

	@Override
	public String toString() {
		return "PeticionesEntity [id=" + id + ", cliente=" + cliente + ", producto=" + producto + ", fecha=" + fecha
				+ ", cantidad=" + cantidad + ", estado=" + estado + "]";
	}

}
