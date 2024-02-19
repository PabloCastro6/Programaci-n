package com.kike.colegio.entities;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Cliente")
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "CorreoElectronico", nullable = false, unique = true)
	private String correoElectronico;

	@Column(name = "password")
	private String password;

	@Column(name = "FechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

//    @ManyToOne
//	@JoinColumn(name = "ID_Poblacion")
//	private PoblacionEntity cliente;

	@Column(name = "activo")
	private Integer activo;

	public ClienteEntity(int id, String nombre, String correoElectronico, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.activo = activo;
	}

	public ClienteEntity() {
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

//	public PoblacionEntity getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(PoblacionEntity cliente) {
//		this.cliente = cliente;
//	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@OneToMany(mappedBy = "cliente")
	private Set<PeticionesEntity> peticiones;
	@OneToMany(mappedBy = "cliente")
	private Set<PedidosEntity> pedidos;

//
//    @OneToMany(mappedBy = "cliente")
//    private Set<Peticion> peticiones;

	// Getters y setters...
}
