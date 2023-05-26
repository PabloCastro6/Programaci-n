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
	
	public  List<ClienteDTO> recuperaTodosClientes() throws ClassNotFoundException, SQLException {
		Connection conexionBBDD = DBUtils.conexionBBDD();
		
		
		Statement statement = conexionBBDD.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM customers");
		
		List<ClienteDTO> listaClientes = new ArrayList<>();
		
		while (rs.next()) {
			ClienteDTO c = new ClienteDTO(rs.getString("customerName"), rs.getString("phone"));
            listaClientes.add(c);
		}
		conexionBBDD.close();
		return listaClientes;
	}
	
	public List<ClienteDTO> recuperaClienteFiltraPorNombre(String nombre, String country, String phone) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM customers WHERE customerName LIKE ? AND country LIKE ? AND phone LIKE ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		
		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + country + "%");
		ps.setString(3, "%" + phone + "%");
		
		System.out.println("query que enviamos: " + ps.toString());
		ResultSet rs = ps.executeQuery();
		
		List <ClienteDTO> listaClientes = new ArrayList<>();
		
		while (rs.next()) {
			//ClienteDTO c = new ClienteDTO(rs.getArray("customerName"),rs.getString("Phone"));
        listaClientes.add(new ClienteDTO(rs.getString("customerName"), rs.getString("phone")));		
		}
		conexionBBDD.close();
		return listaClientes;
		
	
	}
	
	public Integer insertarCCliente(Integer customerName,String customerNumber,String contactLastName,String phone,String addresLine1, String addresLine2, 
			String city, String state, String postalCode,
	
			String country, Integer salesRepEmployeeNumber, Double creditLimit  ) throws ClassNotFoundException, SQLException {
	
		
		String sql ="INSERT INTO customers (customerNumber,customerName,contactLastName, contactFirstName, phone, addresLine1, addresLine2,"
				+ " city, state, postalCode,"
				+ "country,salesRepEmployeeNumber,creditLimit" + "VALUES (?, ?,?,?,?,?,?,?,?,?,?,?)";
		
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, customerName);
		ps.setString(2, customerNumber);
		ps.setString(3, contactLastName);
		ps.setString(4, phone);
		ps.setString(5, addresLine1);
		ps.setString(6, addresLine2);
		ps.setString(7, city);
		ps.setString(8, state);
		ps.setString(9, postalCode);
		ps.setString(10, country);
		ps.setInt(11, salesRepEmployeeNumber);
		ps.setDouble(12, creditLimit);
		
		Integer resultado = ps.executeUpdate();
		
		
		
		conexionBBDD.close();
		
		return resultado;
	}

}
