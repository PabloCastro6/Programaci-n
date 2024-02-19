package com.kike.colegio.entities;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "estadospedidos")
public class EstadoPedidosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EstadoID")
	private Integer estadoId;

	@Column(name = "NombreEstado")
	private String nombreEstado;

	@OneToMany(mappedBy = "estado")
	private Set<PeticionesEntity> peticiones;

	@OneToMany(mappedBy = "estado")
	private Set<PedidosEntity> estado;

	@ManyToOne
	@JoinColumn(name = "ID_Pedido")
	private PedidosEntity pedido;

	public EstadoPedidosEntity(Integer estadoId, String nombreEstado, Set<PeticionesEntity> peticiones) {
		super();
		this.estadoId = estadoId;
		this.nombreEstado = nombreEstado;
		this.peticiones = peticiones;
	}

	public EstadoPedidosEntity() {
		super();
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public Set<PeticionesEntity> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(Set<PeticionesEntity> peticiones) {
		this.peticiones = peticiones;
	}

}
