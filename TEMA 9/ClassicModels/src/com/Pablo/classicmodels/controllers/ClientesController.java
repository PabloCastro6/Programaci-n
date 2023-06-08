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
	 
	 public Integer insertarCliente(Integer customerNumber, String customerName, String contactLastName,
	            String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state,
	            String postalCode, String country, Integer salesRepEmployeeNumber, Double creditLimit)  throws ClassNotFoundException, SQLException {
		
	ClientesModelo cm = new ClientesModelo();
	return cm.insertarCliente(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);

} 
	 
	 public Integer actualizarCliente (String customerNumber,int customerName,String contactLastName,String contactFirstName, String phone,String addressLine1, String addressLine2, 
				String city, String state, String postalCode,
				String country, Integer salesRepEmployeeNumber, Double creditLimit) throws ClassNotFoundException, SQLException {
		ClientesModelo cm = new ClientesModelo();			
		return cm.actualizarClientes(  customerName,   customerNumber,   contactLastName,   contactFirstName,   phone,   addressLine1,   addressLine2,   city,   state,  postalCode,  country,  salesRepEmployeeNumber,  creditLimit);

}

	 public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {
		 ClientesModelo cm = new ClientesModelo();
		 return cm.borrarCliente(customerNumber);
	 }
}
