package com.kike.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.entities.CategoriaEntity;

@Repository
public interface CategoriasRepository extends CrudRepository<CategoriaEntity, Integer> {

	@Query("SELECT new com.kike.colegio.dtos.CategoriaDTO(c.id, c.nombre, c.descripcion, c.activo) "
			+ "FROM  com.kike.colegio.entities.CategoriaEntity c "
			+ "WHERE CAST(c.id AS STRING) LIKE CONCAT('%', :id, '%') " + "AND c.nombre LIKE CONCAT('%', :nombre, '%') "
			+ "AND c.descripcion LIKE CONCAT('%', :descripcion, '%') " + "AND c.activo = :activo")
	List<CategoriaDTO> buscarCategorias(@Param("id") String id, @Param("nombre") String nombre,
			@Param("descripcion") String descripcion, @Param("activo") String activo);

}
