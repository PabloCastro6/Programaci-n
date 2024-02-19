package com.chuchi.tienda.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadospedidos")
public class EstadosPedidosEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstadoID")
    private Integer id;
	
	@Column(name = "NombreEstado")
    private String nombre;

	@OneToMany(mappedBy = "estado")
	private Set<PeticionesEntity> peticiones;
}
