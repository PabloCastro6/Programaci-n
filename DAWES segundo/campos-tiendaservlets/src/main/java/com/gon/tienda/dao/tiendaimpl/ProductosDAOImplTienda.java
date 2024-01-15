package com.gon.tienda.dao.tiendaimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.gon.tienda.dao.ProductosDAO;
import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.dtos.ProductoDTO;
import com.gon.tienda.utils.DBUtils;

	public class ProductosDAOImplTienda implements ProductosDAO{

		@Override
		public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
				String cantidadStock, String idCategoria, String idProveedor)
				throws ClassNotFoundException, SQLException {

			String sql = "SELECT p.ID_Producto, p.Nombre, p.Descripcion, p.Precio, p.CantidadEnStock, c.nombre , p.ID_Categoria , pr.nombre , p.ID_Proveedor "
					+ "FROM productos p "
					+ "INNER JOIN categorias c "
					+ "ON p.ID_Categoria = c.ID_Categoria "
					+ "INNER JOIN proveedores pr "
					+ "ON p.ID_Proveedor = pr.ID_Proveedor "
					+ "WHERE p.ID_Producto LIKE ? "
					+ " AND p.Nombre LIKE ? "
					+ " AND p.Descripcion LIKE ? "
					+ " AND p.Precio >= ? "
					+ " AND p.CantidadEnStock >= ? "
					+ " AND p.ID_Categoria = ? "
					+ " AND p.ID_Proveedor = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		List<ProductoDTO> listaProductos = new ArrayList<>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id + "%");
		ps.setString(2, nombre + "%");
		ps.setString(3, descripcion + "%");
		ps.setString(4, precio );
		ps.setString(5, cantidadStock );
		ps.setString(6, idCategoria );
		ps.setString(7, idProveedor );
		
		ResultSet rs = ps.executeQuery();
		System.out.println(ps.toString());
		
		while(rs.next()) {
			System.out.println("variables RS:");
			System.out.println("RS 1: " + rs.getInt(1));
			System.out.println("RS 2: " + rs.getString(2));
			System.out.println("RS 3: " + rs.getString(3));
			System.out.println("RS 4: " + rs.getDouble(4));
			System.out.println("RS 5: " + rs.getInt(5));
			System.out.println("RS 6: " + rs.getInt(7));
			System.out.println("RS 7: " + rs.getInt(9));

			listaProductos.add(new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(7), rs.getInt(9)));
			
		}
		connection.close();
		return listaProductos;
		}

		@Override
		public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadStock,
				String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException {

			String sql = "INSERT INTO productos (Nombre, Descripcion, Precio, CantidadEnStock, ID_Categoria, ID_Proveedor) "
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setString(3, precio);
			ps.setString(4, cantidadStock);
			ps.setString(5, idCategoria);
			ps.setString(6, idProveedor);

			System.out.println(ps.toString());
			
			Integer resultado = ps.executeUpdate();
			connection.close();
			return resultado;
		}
		
		public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidadStock,
				String idCategoria, String idProvedor) throws ClassNotFoundException, SQLException{

			String sql = "UPDATE productos SET Nombre = ?, Descripcion = ?, Precio = ?, CantidadEnStock = ?, ID_Categoria = ?, "
					+ " ID_Proveedor = ? WHERE ID_Producto = ? ";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setString(3, precio);
			ps.setString(4, cantidadStock);
			ps.setString(5, idCategoria);
			ps.setString(6, idProvedor);
			ps.setString(7, id);

			Integer resultado = ps.executeUpdate();
			ps.toString();
			System.out.println(ps.toString());
			connection.close();

			return resultado;
		}
		
		

}
