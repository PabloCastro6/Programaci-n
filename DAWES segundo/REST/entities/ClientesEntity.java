package com.chuchi.tienda.entities;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class ClientesEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "CorreoElectronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "password")
    private String password;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_Poblacion")
    @JsonBackReference
    private PoblacionEntity poblacion;

    @Column(name = "activo")
    private Integer activo;
    
    @OneToMany(mappedBy = "cliente")
    private Set<PedidosEntity> pedidos;

    @OneToMany(mappedBy = "cliente")
    private Set<PeticionesEntity> peticiones;

    
    
	public ClientesEntity(int id, String nombre, String correoElectronico, String password, Date fechaRegistro,
			PoblacionEntity poblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
		this.poblacion = poblacion;
		this.activo = activo;
	}

	public ClientesEntity() {
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

	public PoblacionEntity getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionEntity poblacion) {
		this.poblacion = poblacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	

	@Override
	public String toString() {
		return "ClientesEntity [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico
				+ ", password=" + password + ", fechaRegistro=" + fechaRegistro + ", idPoblacion=" + poblacion
				+ ", activo=" + activo + "]";
	}

}


