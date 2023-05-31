package com.Pablo.classicmodels.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.ClientesController;
import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class VistaClientes {
	
	Scanner sc;
	public void recuperarClienteFiltraPorNombre() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Digame el nombre a buscar");
		String nombre = sc.nextLine();
		
		System.out.println("Digama el pais a buscar");
		
		String pais = sc.nextLine();
		
		System.out.println("Digame el telefono a buscar");
		
		String Phone = sc.nextLine();
		
	
		
		ClientesController clientesController = new ClientesController();
		List<ClienteDTO> listaClientes =  clientesController. recuperarClienteFiltraPorNombre(nombre, Phone,Phone);
		
		
		for (ClienteDTO c : listaClientes) {
			System.out.println(c.getNombre()+ " " + c.getTelefono());
		}
		
	}
	
	public void menuInsertarCliente() throws ClassNotFoundException, SQLException {
		
		
		sc = MiScanner.getInstance();
		System.out.println("Digame el customerName ");
		
		Integer customerName = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el customerNumber ");
		 String customerNumber = sc.nextLine();;
		
		System.out.println("Digame el contactLastName");
		String contactLastName  =	sc.nextLine();;
		
		System.out.println("Digame el phone ");
		String phone =	sc.nextLine();;
		
		System.out.println("Digame el addresLine1 ");
		
		String addresLine1 = 	sc.nextLine();
		;
		System.out.println("Digame el addresLine2 ");
		String addresLine2 = 	sc.nextLine();
	
		System.out.println("Digame el city");
		
		String city = 	sc.nextLine();
		
		System.out.println("Digame el state");
		
		String state = 	sc.nextLine();
		
		System.out.println("Digame el postalCode ");
		String postalCode = sc.nextLine();

		System.out.println("Digame el country");
		String country = 	sc.nextLine();
		
		System.out.println("Digame el salesRepEmployeeNumber ");
		Integer salesRepEmployeeNumber = 0;
		try  {
			salesRepEmployeeNumber = Integer.parseInt(sc.nextLine());
			
		} catch (NumberFormatException e) {
			System.out.println("No has introducido nada, no se cambiara el representado");
		}
	
		
	
		System.out.println("Digame el creditLimit (pon decimales) ");
		Double creditLimit = 0.0;
		try {
			creditLimit = Double.parseDouble(sc.nextLine());
			
		} catch (NumberFormatException e) {
			System.out.println("NO has introducido nada, no se cambiara el creedito");
		}
		
		
		ClientesController cc = new ClientesController();
		cc.actualizarCliente(customerName, customerNumber, contactLastName, phone, addresLine1, addresLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
			
		}
		
	public void menuBorrarCliente() {
		sc = MiScanner.getInstance();
		System.out.println("digame el customerNumber");
		
		Integer customerNumber = sc.nextInt();
		sc.nextLine();
		
		ClientesController cc = new ClientesController();
		
		int resultado = cc.borrarCliente(customerNumber);
		
		if(resultado == 1 ) {
			System.out.println("cliente borrado con exito");
		}
		
	}
	
	}
	
	


