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

import com.kike.colegio.dao.ProductosDAO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.utils.DBUtils;

@Component("productosJDBC")
public class ProductosDAOImplJdbc implements ProductosDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoriasDAOImplJdbc.class);

	@Override
	public List<ProductosDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet categoriasResultSet = null;
		List<ProductosDTO> listaCategorias = new ArrayList<ProductosDTO>();
		Connection connection = DBUtils.conectaBBDD();

		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM productos");

		while (categoriasResultSet.next()) {
			listaCategorias.add(new ProductosDTO(categoriasResultSet.getString(1), categoriasResultSet.getString(2),
					categoriasResultSet.getString(3), categoriasResultSet.getString(4),
					categoriasResultSet.getString(5), categoriasResultSet.getString(6),
					categoriasResultSet.getString(7)));
		}

		return listaCategorias;
	}

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT id_producto, nombre, descripcion, precio, CantidadEnStock, ID_Categoria, ID_Proveedor FROM productos WHERE id_producto LIKE ? AND nombre LIKE ? AND descripcion LIKE ? AND precio LIKE ? AND CantidadEnStock LIKE ? AND ID_Categoria LIKE ? AND ID_Proveedor LIKE ? ";
		Connection connection = DBUtils.conectaBBDD();
		List<ProductosDTO> listaCategorias = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, "%" + precio + "%");
		ps.setString(5, "%" + cantidad + "%");
		ps.setString(6, "%" + categoria + "%");
		ps.setString(7, "%" + proveedor + "%");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaCategorias.add(new ProductosDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		connection.close();
		return listaCategorias;

	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO productos ( nombre, descripcion, precio , CantidadEnStock, ID_Categoria, ID_Proveedor) "
				+ "  VALUES (?, ?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidad);
		ps.setString(5, categoria);
		ps.setString(6, proveedor);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE productos set nombre = ?, descripcion = ?, precio = ?, CantidadEnStock = ?, ID_Categoria = ?, ID_Proveedor = ? WHERE id_producto = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidad);
		ps.setString(5, categoria);
		ps.setString(6, proveedor);
		ps.setString(7, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}
}
