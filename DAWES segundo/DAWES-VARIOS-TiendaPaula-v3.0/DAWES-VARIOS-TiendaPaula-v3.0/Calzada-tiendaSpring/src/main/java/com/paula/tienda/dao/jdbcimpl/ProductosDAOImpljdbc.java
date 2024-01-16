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

import com.paula.tienda.dao.ProductosDAO;
import com.paula.tienda.dtos.ProductoDTO;
import com.paula.tienda.utils.DBUtils;

@Component
public class ProductosDAOImpljdbc implements ProductosDAO {

	public List<ProductoDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {

		Connection connection = DBUtils.conectaBBDD();
		ResultSet productosResultSet = null;

		List<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();

		Statement st = connection.createStatement();
		productosResultSet = st.executeQuery("SELECT * FROM productos");
		while (productosResultSet.next()) {
			listaProductos.add(new ProductoDTO(productosResultSet.getInt(1), productosResultSet.getString(2),
					productosResultSet.getString(3), productosResultSet.getDouble(4), productosResultSet.getInt(5),
					productosResultSet.getString(6), productosResultSet.getInt(7), productosResultSet.getString(8),
					productosResultSet.getInt(9)));
		}

		return listaProductos;

	}

	@Override
	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT p.ID_Producto, p.Nombre, p.Descripcion , p.Precio, p.CantidadEnStock, c.Nombre, p.ID_Categoria, pr.Nombre,  p.ID_Proveedor "
				+ " FROM productos p " + " INNER JOIN categorias c" + " ON c.ID_Categoria = p.ID_Categoria"
				+ " INNER JOIN proveedores pr " + "ON pr.ID_Proveedor = p.ID_Proveedor"
				+ " WHERE p.ID_Producto LIKE ? AND p.Nombre LIKE ? AND p.Descripcion LIKE ? AND p.precio >= ? "
				+ " AND p.CantidadEnStock >= ? AND p.ID_Categoria = ? AND p.ID_Proveedor = ? ";

		Connection connection = DBUtils.conectaBBDD();
		List<ProductoDTO> listaProductos = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, precio);
		ps.setString(5, cantidad);
		ps.setString(6, categoria );
		ps.setString(7,  proveedor);

		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaProductos.add(new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
					rs.getInt(5), rs.getString(6),rs.getInt(7), rs.getString(8),rs.getInt(9)));
		}
		
//		public ProductoDTO(Integer id, String nombre, String descripcion, Double precio, Integer cantidad, String categoria,
//				Integer idCategoria, String proveedor, Integer idProveedor)
		connection.close();
		
		return listaProductos;
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO productos(Nombre, Descripcion, Precio, CantidadEnStock, ID_Categoria, ID_Proveedor)"
				+ "VALUES ( ? ,? ,? ,? ,? ,? )";

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

	    String sql = "UPDATE productos SET Nombre = ?, Descripcion = ?, Precio = ?, CantidadEnStock = ?, ID_Categoria = ?, ID_Proveedor = ? "
	            + "WHERE ID_Producto = ?";

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
