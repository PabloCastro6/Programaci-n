package com.paula.tienda.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.paula.tienda.utils.DBUtils;
import com.paula.tienda.dao.CategoriasDAO;
import com.paula.tienda.dtos.CategoriaDTO;

@Component
public class CategoriasDAOImpljdbc implements CategoriasDAO {

	@Override
	public List<CategoriaDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {

		Connection connection = DBUtils.conectaBBDD();
		ResultSet categoriasResultSet = null;

		List<CategoriaDTO> listaCategorias = new ArrayList<CategoriaDTO>();

		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM categorias");
		while (categoriasResultSet.next()) {
			listaCategorias.add(new CategoriaDTO(categoriasResultSet.getInt(1), categoriasResultSet.getString(2),
					categoriasResultSet.getString(3), categoriasResultSet.getInt(4)));

		}

		return listaCategorias;
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_Categoria, Nombre, Descripcion, Activo FROM categorias"
				+ " WHERE ID_Categoria LIKE ? AND Nombre LIKE ? AND Descripcion LIKE ? AND Activo = ?";
		Connection connection = DBUtils.conectaBBDD();
		List<CategoriaDTO> listaCategorias = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, activo);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaCategorias.add(new CategoriaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		connection.close();

		return listaCategorias;
	}

	@Override
	public Integer insertarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO categorias(ID_Categoria, Nombre, Descripcion, Activo)"
				+ "VALUES ( ? ,? ,? ,? )";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, activo);
		
		Integer resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE categorias SET Nombre = ?, Descripcion = ?, Activo = ?"
				+ "WHERE ID_Categoria = ?";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		ps.setString(4, id);
		
		Integer resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "UPDATE categorias SET  Activo = 0 " 
				+ "WHERE ID_Categoria = ?";

				Connection connection = DBUtils.conectaBBDD();
				PreparedStatement ps = connection.prepareStatement(sql);

			
				ps.setString(1, id);
				
			
				Integer resultado = ps.executeUpdate();

				connection.close();

				return resultado;
	}

}
