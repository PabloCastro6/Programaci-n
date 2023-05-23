package com.Pablo.classicmodels.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.ClienteDTO;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/classicmodels";
		String username = "root";
		String password ="PracticaRoot";
		
		Connection conexionBBDD = DriverManager.getConnection(servidor,username,password);
		
		
		Statement statement = conexionBBDD.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM customers");
		
		List<ClienteDTO> listaClientes = new ArrayList<>();
		
		while (rs.next()) {
			ClienteDTO c = new ClienteDTO(rs.getString("customerName"), rs.getString("phone"));
            listaClientes.add(c);
		}
		System.out.println("El resultado de la consulta es ");
		for (ClienteDTO c : listaClientes) {
			System.out.println("Nombre: " + c.getNombre() + "Telefono" + c.getTelefono());
			
		}
		
		
	}

}
