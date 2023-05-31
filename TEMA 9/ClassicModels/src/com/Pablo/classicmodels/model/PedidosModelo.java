package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Pablo.classicmodels.dtos.CantidadPedidaProducto;
import com.Pablo.classicmodels.utils.DBUtils;

public class PedidosModelo {

	public Integer crearPedido ( String orderDate, String requiredDate,String status,String comments,
			Integer customerNumber, List<CantidadPedidaProducto> listaProductos) throws ClassNotFoundException, SQLException {
		
		//Insert del order
		String insertOrder = "INSERT INTO orders (orderDate, requiredDate,status,comments,customerNumber)" 
				+ "VALUES (?, ?, ?, ?,?)";
		//Insert del order details (un insert por producto)
		String insertOrderDetails = "INSERT INTO orderdetails (orderNumber,productCode,quantityOrdered,orderLineNumber)" 
		+ "VALUES (?,?,?,?) ";
		
		//Actulizacion del inventario
		String actualizacionInventario = "UPDATE products SET quantityInStock = quantityInStock  - ? "
				                        + "WHERE productCode = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		
		connection.setAutoCommit(false);
		
		PreparedStatement psInsertOrder = connection.prepareStatement(insertOrder,Statement.RETURN_GENERATED_KEYS);
		PreparedStatement psInsertOrderDetails = connection.prepareStatement(insertOrderDetails);
		PreparedStatement psActualizacionInventario = connection.prepareStatement(actualizacionInventario);
		
		psInsertOrder.setString(1, orderDate);
		psInsertOrder.setString(2, requiredDate);
		psInsertOrder.setString(3, status);
		psInsertOrder.setString(4, comments);
		psInsertOrder.setInt(5, customerNumber);
		
		
		System.out.println(psInsertOrder.toString());
		
		psInsertOrder.executeUpdate();
		
		
		ResultSet rs = psInsertOrder.getGeneratedKeys();
		int orderNumber = 0;
		if (rs.next()) {
			orderNumber = rs.getInt(1);
		}
		
		int orderLineNumber = 0;
		
		for (CantidadPedidaProducto producto : listaProductos) {
			orderLineNumber++;
			psInsertOrderDetails.setInt(1, orderNumber);
			psInsertOrderDetails.setString(2, producto.getProductCode());
			psInsertOrderDetails.setInt(3,producto.getQuantityOrdered());
			psInsertOrderDetails.setInt(4,orderLineNumber);
			
			psActualizacionInventario.setInt(1,producto.getQuantityOrdered());
			psActualizacionInventario.setString(2,producto.getProductCode());
			
			
			System.out.println(psInsertOrderDetails.toString());
			System.out.println(psActualizacionInventario.toString());
			
			
			psInsertOrderDetails.executeUpdate();
			psActualizacionInventario.executeUpdate();
		}
		
		connection.commit();
		
		
		connection.close();
		
		return orderNumber;
	
}
}