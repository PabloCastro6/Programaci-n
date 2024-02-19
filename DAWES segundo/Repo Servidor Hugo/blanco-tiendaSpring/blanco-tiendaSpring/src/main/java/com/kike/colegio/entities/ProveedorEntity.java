package com.kike.colegio.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Proveedor")
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "Contacto")
	private String contacto;

	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "CorreoElectronico")
	private String correo;

	@Column(name = "Direccion")
	private String direccion;

	@Column(name = "Activo")
	private String activo;

	@OneToMany(mappedBy = "proveedor")
	private Set<ProductoEntity> productos;

	public ProveedorEntity(int id, String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.activo = activo;
	}

	public ProveedorEntity(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) {
		super();
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.activo = activo;
	}

	public ProveedorEntity(String nombre) {
		super();
		this.nombre = nombre;
	}

	public ProveedorEntity(int id) {
		super();
		this.id = id;
	}

	public ProveedorEntity() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

}