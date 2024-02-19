package com.kike.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.entities.ProveedorEntity;

@Repository

public interface ProveedoresRepository extends CrudRepository<ProveedorEntity, Integer> {
	@Query(value = "SELECT new com.kike.colegio.dtos.ProvedoresDTO "
			+ "(id, nombre, contacto, telefono, correo, direccion, activo) "
			+ "FROM com.kike.colegio.entities.ProveedorEntity p " + "WHERE nombre LIKE CONCAT ('%', :nombre, '%') "
			+ "AND contacto LIKE CONCAT ('%', :contacto, '%') " + "AND telefono LIKE CONCAT ('%', :telefono, '%') "
			+ "AND correo LIKE CONCAT ('%', :correo, '%') " + "AND direccion LIKE CONCAT ('%', :direccion, '%') "
			+ "AND activo = :activo ")
	public List<ProvedoresDTO> buscarProveedores(@Param("nombre") String nombre, @Param("contacto") String contacto,
			@Param("telefono") String telefono, @Param("correo") String correo, @Param("direccion") String direccion,
			@Param("activo") String activo);

}
