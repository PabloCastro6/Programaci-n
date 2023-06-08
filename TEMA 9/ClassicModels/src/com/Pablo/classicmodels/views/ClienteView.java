package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.ClientesController;
import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class ClienteView {
Scanner sc;
	
	public void recuperarClienteFiltraPorNombre() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame el nombre a buscar:");
		String nombre = sc.nextLine();
		
		ClientesController cc = new ClientesController();
		List<ClienteDTO> listaCliente = cc.recuperarClienteFiltraPorNombre(nombre, nombre, nombre);
		
		for(ClienteDTO c : listaCliente) {
			System.out.println(c.toString());
		}
	}
	
	
	public void recuperarClienteFiltraPorNombreTelefono() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame el nombre a buscar:");
		String nombre = sc.nextLine();
		
		System.out.println("Digame el pais a buscar:");
		String country = sc.nextLine();
		
		System.out.println("Digame el número de teléfono a buscar:");
		String phone = sc.nextLine();
		
		ClientesController cc = new ClientesController();
		List<ClienteDTO> listaCliente = cc.recuperarClienteFiltraPorNombre(nombre, country, phone);
		
		for(ClienteDTO c : listaCliente) {
			System.out.println(c.toString());
		}
	}
	
	public void menuInsertarCliente() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el customerNumber a buscar:");
		Integer customerNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el customerName a buscar:");
		String customerName = sc.nextLine();
		
		System.out.println("Digame el contactLastName a buscar:");
		String contactLastName = sc.nextLine();
		
		System.out.println("Digame el contactFirstName a buscar:");
		String contactFirstName = sc.nextLine();
		
		System.out.println("Digame el phone a buscar:");
		String phone = sc.nextLine();
		
		System.out.println("Digame el addressLine1 a buscar:");
		String addressLine1 = sc.nextLine();
		
		System.out.println("Digame el addressLine2 a buscar:");
		String addressLine2 = sc.nextLine();
		
		System.out.println("Digame el city a buscar:");
		String city = sc.nextLine();
		
		System.out.println("Digame el state a buscar:");
		String state = sc.nextLine();
		
		System.out.println("Digame el postalCode a buscar:");
		String postalCode = sc.nextLine();
		
		System.out.println("Digame el pais a buscar:");
		String country = sc.nextLine();
		
		System.out.println("Digame el salesRepEmployeeNumber a buscar:");
		int salesRepEmployeeNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el creditLimit a buscar:");
		Double creditLimit = sc.nextDouble();
		sc.nextLine();
		
		
		ClientesController cc = new ClientesController();
		Integer insertarCliente = cc.insertarCliente(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, salesRepEmployeeNumber, creditLimit);
	}
	
	public void menuActualizarClientes() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el customerNumber a buscar:");
		Integer customerNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el customerName a buscar:");
		String customerName = sc.nextLine();
		
		System.out.println("Digame el contactLastName a buscar:");
		String contactLastName = sc.nextLine();
		
		System.out.println("Digame el contactFirstName a buscar:");
		String contactFirstName = sc.nextLine();
		
		System.out.println("Digame el phone a buscar:");
		String phone = sc.nextLine();
		
		System.out.println("Digame el addressLine1 a buscar:");
		String addressLine1 = sc.nextLine();
		
		System.out.println("Digame el addressLine2 a buscar:");
		String addressLine2 = sc.nextLine();
		
		System.out.println("Digame el city a buscar:");
		String city = sc.nextLine();
		
		System.out.println("Digame el state a buscar:");
		String state = sc.nextLine();
		
		System.out.println("Digame el postalCode a buscar:");
		String postalCode = sc.nextLine();
		
		System.out.println("Digame el pais a buscar:");
		String country = sc.nextLine();
		
		System.out.println("Digame el salesRepEmployeeNumber a buscar:");
		int salesRepEmployeeNumber = 0;
		try {
			salesRepEmployeeNumber = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No has introducido nada, no se cambiará el representante");
		}

		
		System.out.println("Digame el creditLimit a buscar:");
		Double creditLimit = 0.0;
		try { 
			creditLimit = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No has introducio nada, no se cambiará el crédito");
		}
	
		
		
		ClientesController cc = new ClientesController();
		Integer insertarCliente = cc.actualizarClientes(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
	}
	
	public void menuBorrarCliente() throws SQLException, ClassNotFoundException {

		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el customerNumber a borrar:");
		Integer customerNumber = sc.nextInt();
		sc.nextLine();
		
		ClientesController cc = new ClientesController();
		Integer borrarClientes = cc.borrarCliente(customerNumber);
		System.out.println("cliente " + customerNumber + " borrado con exito");
	}
	
	public void menuGeneralCliente() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		int n=0;
		
		do {
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE CLIENTES");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar cliente por nombre");
		    System.out.println("2. Buscar cliente por nombre, teléfono o país");
		    System.out.println("3. Insertar cliente");
		    System.out.println("4. Actualizar cliente");
		    System.out.println("5. Borrar cliente");
		    System.out.println("6. Volver al menú principal");
		    System.out.println("===============================================");
		    
		  
		    n = Integer.parseInt(sc.nextLine());
		   
		    	
	            if (n>6||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if(n == 1) {
	            	recuperarClienteFiltraPorNombre();
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	recuperarClienteFiltraPorNombreTelefono();
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuInsertarCliente();
	            	continue;
	            }
	            if(n == 4) {
	            	menuActualizarClientes();
	            	continue;
	            }
	            
	            if ( n == 5) {
	            	menuBorrarCliente();
	            	continue;
	            }
	            
	            if ( n == 6) {
	            	System.out.println("Volviendo a menú principal");
	            	return;
	            }

		    } while(n!=6);
	}
}

