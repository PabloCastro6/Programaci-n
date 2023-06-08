package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.InventarioDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class InventarioModelo {
public List<InventarioDTO> consultarInventario (String productCode, String productName, String productLine, String productDescription) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM products WHERE productCode LIKE ? AND productName LIKE ? AND productLine LIKE ? AND productDescription LIKE ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,"%" + productCode + "%");
		ps.setString(2,"%" +  productName + "%");
		ps.setString(3,"%" +  productLine + "%");
		ps.setString(4,"%" +  productDescription + "%");
		
		ResultSet rs = ps.executeQuery();
		
		List<InventarioDTO> listaInventario = new ArrayList<>();
		
		while (rs.next()) {
			InventarioDTO i = new InventarioDTO(rs.getString("productCode"),rs.getString("productName"), rs.getString("productLine"), rs.getString("productDescription"), rs.getString("productScale"), rs.getString("productVendor"),rs.getInt("quantityInStock"), rs.getDouble("buyPrice"), rs.getDouble("MSRP"));
			listaInventario.add(i);
		}
		
		conexionBBDD.close();
		return listaInventario;
	}
	
	public Integer insertarProducto(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantityInStock, Double buyPrice, Double MSRP) throws SQLException, ClassNotFoundException {
		
		String sql ="INSERT INTO products (productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) values (?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, productCode);
		ps.setString(2, productName);
		ps.setString(3, productLine);
		ps.setString(4, productScale);
		ps.setString(5, productVendor);
		ps.setString(6, productDescription);
		ps.setInt(7, quantityInStock);
		ps.setDouble(8, buyPrice);
		ps.setDouble(9, MSRP);

		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
	
	public Integer actualizarProducto(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantityInStock, Double buyPrice, Double MSRP) throws SQLException, ClassNotFoundException {
		
		String query ="UPDATE products SET productName = case when ? ='' then productName else ? END, "
				+ "productLine = case when ? ='' then productLine else ? END, "
				+ "productScale = case when ? ='' then productScale else ? END, "
				+ "productVendor = case when ? ='' then productVendor else ? END, "
				+ "productDescription = case when ? ='' then productDescription else ? END, "
				+ "quantityInStock = case when ? ='' then quantityInStock else ? END, "
				+ "buyPrice = case when ? ='' then buyPrice else ? END, "
				+ "MSRP = case when ? ='' then MSRP else ? "
				+ "END "
				+ "WHERE productCode = ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1, productName);
		ps.setString(2, productName);
		
		ps.setString(3, productLine);
		ps.setString(4, productLine);
		
		ps.setString(5, productScale);
		ps.setString(6, productScale);
		
		ps.setString(7, productVendor);
		ps.setString(8, productVendor);
		
		ps.setString(9, productDescription);
		ps.setString(10, productDescription);
		
		ps.setInt(11, quantityInStock);
		ps.setInt(12, quantityInStock);
		
		ps.setDouble(13, buyPrice);
		ps.setDouble(14, buyPrice);
		
		ps.setDouble(15, MSRP);
		ps.setDouble(16, MSRP);

		ps.setString(17, productCode);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		
		return resultado;
	}
	
	public Integer borrarProducto(String productCode) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM products WHERE productCode = ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, productCode);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
}

