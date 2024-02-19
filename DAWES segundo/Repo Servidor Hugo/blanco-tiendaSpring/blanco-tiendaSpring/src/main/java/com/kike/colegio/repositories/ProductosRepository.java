package com.kike.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.entities.ProductoEntity;

@Repository
public interface ProductosRepository extends CrudRepository<ProductoEntity, Integer> {

}
