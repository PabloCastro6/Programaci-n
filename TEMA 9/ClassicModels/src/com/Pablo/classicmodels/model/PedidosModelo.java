package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Pablo.classicmodels.dtos.CantidadPedidaProductoDTO;
import com.Pablo.classicmodels.dtos.EmpleadosDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class PedidosModelo {

	public Integer crearPedido(String orderDate, String requiredDate, String status,String comments, Integer customerNumber, List<CantidadPedidaProductoDTO> listaProductos) throws ClassNotFoundException, SQLException {
		
		String queryOrder = "INSERT INTO orders (orderDate, requiredDate, status, comments, customerNumber) values (?, ?, ?, ?, ?)";
		String queryOrderDetails = "INSERT INTO orderDetails (orderNumber, productCode, quantityOrdered, orderLineNumber) values (?, ?, ?, ?)";
		String queryUpdateProducts = "UPDATE products SET quatityInStock = quatityInStock - ? WHERE productCode = ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		conexionBBDD.setAutoCommit(false);
		PreparedStatement psOrder = conexionBBDD.prepareStatement(queryOrder, Statement.RETURN_GENERATED_KEYS);
		PreparedStatement psOrderDetails = conexionBBDD.prepareStatement(queryOrderDetails);
		PreparedStatement psUpdateProducts = conexionBBDD.prepareStatement(queryUpdateProducts);
		
		psOrder.setString(1, orderDate);
		psOrder.setString(2, requiredDate);
		psOrder.setString(3, status);
		psOrder.setString(4, comments);
		psOrder.setInt(5, customerNumber);
		psOrder.executeUpdate();
		
		ResultSet rs = psOrder.getGeneratedKeys();
		int orderNumber = 0;
		int orderLineNumber = 0;
		
		if (rs.next()) {
			orderNumber = rs.getInt(1);
		}
		
		for(CantidadPedidaProductoDTO producto : listaProductos) {
			
			orderLineNumber++;
			psOrderDetails.setInt(1, orderNumber);
			psOrderDetails.setString(2, producto.getProductCode());
			psOrderDetails.setInt(3, producto.getQuantityOrdered());
			psOrderDetails.setInt(4, orderLineNumber);
			
			psUpdateProducts.setInt(1, producto.getQuantityOrdered());
			psUpdateProducts.setString(2, producto.getProductCode());
			
			psOrderDetails.executeUpdate();
			psUpdateProducts.executeUpdate();
		}
		
		conexionBBDD.setAutoCommit(true);
		conexionBBDD.close();
		
		return orderNumber;
	}

	
}