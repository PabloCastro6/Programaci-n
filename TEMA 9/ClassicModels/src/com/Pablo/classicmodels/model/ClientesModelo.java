package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class ClientesModelo {
	

public List<ClienteDTO> recuperarClienteFiltraPorNombre (String nombre) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM customers WHERE customerName LIKE ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,"%" + nombre + "%");
		
		
		ResultSet rs = ps.executeQuery();
		
		List<ClienteDTO> listaCliente = new ArrayList<>();
		
		while (rs.next()) {
			ClienteDTO c = new ClienteDTO(rs.getInt("customerNumber"), rs.getString("customerName"), rs.getString("contactLastName"),rs.getString("contactFirstName"), rs.getString("phone"), rs.getString("addressLine1"),rs.getString("addressLine2"), rs.getString("city"), rs.getString("state"),rs.getString("postalCode"), rs.getString("country"), rs.getInt("salesRepEmployeeNumber"),rs.getDouble("creditLimit"));
			listaCliente.add(c);
		}
		
		conexionBBDD.close();
		return listaCliente;
	}
	
	public List<ClienteDTO> recuperarClienteFiltraPorNombreTelefono (String nombre, String country, String phone) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM customers WHERE customerName LIKE ? AND country LIKE ? AND phone LIKE ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,"%" + nombre + "%");
		ps.setString(2,"%" + country + "%");
		ps.setString(3,"%" + phone + "%");
		

		ResultSet rs = ps.executeQuery();
		
		List<ClienteDTO> listaCliente = new ArrayList<>();
		
		while (rs.next()) {
			ClienteDTO c = new ClienteDTO(rs.getInt("customerNumber"), rs.getString("customerName"), rs.getString("contactLastName"),rs.getString("contactFirstName"), rs.getString("phone"), rs.getString("addressLine1"),rs.getString("addressLine2"), rs.getString("city"), rs.getString("state"),rs.getString("postalCode"), rs.getString("country"), rs.getInt("salesRepEmployeeNumber"),rs.getDouble("creditLimit"));
			listaCliente.add(c);
		}
		
		conexionBBDD.close();
		return listaCliente;
	}
	
	public Integer insertarCliente(Integer  customerNumber, String  customerName, String  contactLastName, String  contactFirstName, String  phone, String  addressLine1, String  addressLine2, String  city, String  state, String postalCode, String country, Integer salesRepEmployeeNumber, Double creditLimit) throws SQLException, ClassNotFoundException {
		
		String sql ="INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, customerNumber);
		ps.setString(2, customerName);
		ps.setString(3, contactLastName);
		ps.setString(4, contactFirstName);
		ps.setString(5, phone);
		ps.setString(6, addressLine1);
		ps.setString(7, addressLine2);
		ps.setString(8, city);
		ps.setString(9, state);
		ps.setString(10, postalCode);
		ps.setString(11, country);
		ps.setInt(12, salesRepEmployeeNumber);
		ps.setDouble(13, creditLimit);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
	
	public Integer actualizarClientes(Integer  customerNumber, String  customerName, String  contactLastName, String  contactFirstName, String  phone, String  addressLine1, String  addressLine2, String  city, String  state, String postalCode, String country, Integer salesRepEmployeeNumber, Double creditLimit) throws SQLException, ClassNotFoundException {
		
		String query ="UPDATE customers SET customerName = case when ? ='' then customerName else ? END, "
				+ "contactLastName = case when ? ='' then contactLastName else ? END, "
				+ "contactFirstName = case when ? ='' then contactFirstName else ? END, "
				+ "phone = case when ? ='' then phone else ? END, "
				+ "addressLine1 = case when ? ='' then addressLine1 else ? END, "
				+ "addressLine2 = case when ? ='' then addressLine2 else ? END, "
				+ "city = case when ? ='' then city else ? END, "
				+ "state = case when ? ='' then state else ? END, "
				+ "postalCode = case when ? ='' then postalCode else ? END, "
				+ "country = case when ? ='' then country else ? END, "
				+ "salesRepEmployeeNumber = case when ? ='' then salesRepEmployeeNumber else ? END, "
				+ "creditLimit = case when ? ='' then creditLimit else ? "
				+ "END "
				+ "WHERE customerNumber = ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1, customerName);
		ps.setString(2, customerName);
		
		ps.setString(3, contactLastName);
		ps.setString(4, contactLastName);
		
		ps.setString(5, contactFirstName);
		ps.setString(6, contactFirstName);
		
		ps.setString(7, phone);
		ps.setString(8, phone);
		
		ps.setString(9, addressLine1);
		ps.setString(10, addressLine1);
		
		ps.setString(11, addressLine2);
		ps.setString(12, addressLine2);
		
		ps.setString(13, city);
		ps.setString(14, city);
		
		ps.setString(15, state);
		ps.setString(16, state);
		
		ps.setString(17, postalCode);
		ps.setString(18, postalCode);
		
		ps.setString(19, country);
		ps.setString(20, country);
		
		ps.setInt(21, salesRepEmployeeNumber);
		ps.setInt(22, salesRepEmployeeNumber);
		
		ps.setDouble(23, creditLimit);
		ps.setDouble(24, creditLimit);

		ps.setInt(25, customerNumber);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		
		return resultado;
	}
	
	public Integer borrarCliente(int customerNumber) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM customers WHERE customerNumber = ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, customerNumber);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
}
