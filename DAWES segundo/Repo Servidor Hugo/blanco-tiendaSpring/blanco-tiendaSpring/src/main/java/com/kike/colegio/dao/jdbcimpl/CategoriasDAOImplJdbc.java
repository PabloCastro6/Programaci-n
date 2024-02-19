package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.CategoriasDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.utils.DBUtils;

@Component("categoriasJDBC")
public class CategoriasDAOImplJdbc implements CategoriasDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoriasDAOImplJdbc.class);

	@Override
	public List<CategoriaDTO> obtenerTodosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet categoriasResultSet = null;
		List<CategoriaDTO> listaCategorias = new ArrayList<CategoriaDTO>();
		Connection connection = DBUtils.conectaBBDD();

		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM categorias");

		while (categoriasResultSet.next()) {
			listaCategorias.add(new CategoriaDTO(categoriasResultSet.getInt(1), categoriasResultSet.getString(2)));
			logger.info("añadido categoria " + categoriasResultSet.getInt(1) + " " + categoriasResultSet.getString(2));
		}

		return listaCategorias;
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT ID_Categoria, nombre, descripcion, activo " + " FROM categorias   "
				+ " WHERE ID_Categoria LIKE ? AND nombre LIKE ? AND descripcion LIKE ? " + " AND activo = ? ";

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
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO categorias ( nombre, descripcion, activo) " + "  VALUES (?, ?, ?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE categorias set nombre = ?, descripcion = ?, activo = ?" + "WHERE ID_Categoria = ? ";

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
		String sql = "UPDATE categorias SET activo = 0 " + "WHERE ID_Categoria = ? ";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

}
