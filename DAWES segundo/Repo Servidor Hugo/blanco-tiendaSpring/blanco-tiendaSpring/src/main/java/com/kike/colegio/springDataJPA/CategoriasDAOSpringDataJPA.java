package com.kike.colegio.springDataJPA;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.CategoriasDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.entities.CategoriaEntity;
import com.kike.colegio.repositories.CategoriasRepository;

@Component("CategoriasJPA")

public class CategoriasDAOSpringDataJPA implements CategoriasDAO {

	@Autowired
	CategoriasRepository categoriasRepository;

	@Override
	public List<CategoriaDTO> obtenerTodosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		return null;
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasRepository.buscarCategorias(id, nombre, descripcion, activo);

	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = new CategoriaEntity(nombre, descripcion, Integer.parseInt(activo));
		categoriasRepository.save(categoriaEntity);
		return categoriaEntity.getId();

	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = new CategoriaEntity(nombre, descripcion, Integer.parseInt(activo));
		categoriasRepository.save(categoriaEntity);
		return categoriaEntity.getId();
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = categoriasRepository.findById(Integer.parseInt(id)).get();
		categoriaEntity.setActivo(0);

		categoriasRepository.save(categoriaEntity);

		return categoriaEntity.getId();
	}

}
