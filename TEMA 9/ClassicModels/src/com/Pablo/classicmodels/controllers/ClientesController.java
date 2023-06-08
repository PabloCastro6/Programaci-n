package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.model.ClientesModelo;

public class ClientesController {
	
	 public List<ClienteDTO> recuperarClienteFiltraPorNombre(String nombre) throws ClassNotFoundException, SQLException {
	 
	 ClientesModelo cm = new ClientesModelo();
	 
	 return cm.recuperarClienteFiltraPorNombre(nombre);

}
	 public List<ClienteDTO> recuperaNombreTelefono(String nombre, String telefono, String pais) throws ClassNotFoundException, SQLException{
			ClientesModelo cm = new ClientesModelo();
			return cm.recuperarClienteFiltraPorNombreTelefono(nombre, telefono, pais);
		}
	 
	 public Integer insertarCliente(Integer customerName,String customerNumber,String contactLastName,String phone,String addresLine1, String addresLine2, 
				String city, String state, String postalCode,
				String country, Integer salesRepEmployeeNumber, Double creditLimit  ) throws ClassNotFoundException, SQLException {
		
	ClientesModelo cm = new ClientesModelo();
	return cm.actualizarCliente(customerName, customerNumber, contactLastName, phone, addresLine1, addresLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
} 
	 
	 public Integer actualizarCliente (String customerName,String customerNumber,String contactLastName,String phone,String addresLine1, String addresLine2, 
				String city, String state, String postalCode,
				String country, Integer salesRepEmployeeNumber, Double creditLimit) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();			
		 return cm.actualizarCliente( customerName, customerNumber, contactLastName, phone, addresLine1,  addresLine2, 
							 city,  state, postalCode,
							 country,  salesRepEmployeeNumber,  creditLimit);
}

	 public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {
		 ClientesModelo cm = new ClientesModelo();
		 return cm.borrarCliente(customerNumber);
	 }
}
