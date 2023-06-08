package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.OficinaController;
import com.Pablo.classicmodels.dtos.OficinaDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class OficinaView {
Scanner sc;
	
	public void menuRecuperarOficina () throws ClassNotFoundException, SQLException {
		
		sc = MiScanner.getInstance();
			
		System.out.println("Digame el codigo de la oficina a buscar:");
		String officeCode = sc.nextLine();
		System.out.println("Digame la ciudad a buscar:");
		String city = sc.nextLine();
		System.out.println("Digame el estado a buscar:");
		String state = sc.nextLine();
		System.out.println("Digame el pais a buscar:");
		String country = sc.nextLine();
			
		OficinaController oc = new OficinaController();
		List<OficinaDTO> listaCliente = oc.recuperarOficina(officeCode, city, state, country);
			
		for(OficinaDTO c : listaCliente) {
			System.out.println(c.toString());
			
		}
	}
	
	public void menuInsertarOficina () throws ClassNotFoundException, SQLException {
		
		sc = MiScanner.getInstance();
			
		System.out.println("Digame el codigo de la oficina a insertar:");
		String officeCode = sc.nextLine();
		System.out.println("Digame la ciudad a insertar:");
		String city = sc.nextLine();
		System.out.println("Digame el teléfono a insertar:");
		String phone = sc.nextLine();
		System.out.println("Digame la dirección a insertar:");
		String addressLine1 = sc.nextLine();
		System.out.println("Digame la segunda linea de dirección a insertar:");
		String addressLine2 = sc.nextLine();
		System.out.println("Digame el estado a insertar:");
		String state = sc.nextLine();
		System.out.println("Digame el pais a insertar:");
		String country = sc.nextLine();
		System.out.println("Digame el codigo postal a insertar:");
		String postalCode = sc.nextLine();
		System.out.println("Digame el territorio a insertar:");
		String territory = sc.nextLine();
			
		OficinaController oc = new OficinaController();
		Integer listaCliente = oc.insertarOficina(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
	}
	
	public void menuActualizarOficina() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame el codigo de la oficina a actualizar:");
		String officeCode = sc.nextLine();
		System.out.println("Digame la ciudad:");
		String city = sc.nextLine();
		System.out.println("Digame el teléfono:");
		String phone = sc.nextLine();
		System.out.println("Digame la dirección:");
		String addressLine1 = sc.nextLine();
		System.out.println("Digame la segunda linea de dirección:");
		String addressLine2 = sc.nextLine();
		System.out.println("Digame el estado:");
		String state = sc.nextLine();
		System.out.println("Digame el pais:");
		String country = sc.nextLine();
		System.out.println("Digame el codigo postal:");
		String postalCode = sc.nextLine();
		System.out.println("Digame el territorio:");
		String territory = sc.nextLine();
			
		OficinaController oc = new OficinaController();
		Integer listaCliente = oc.actualizarOficina(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
	
	}
	
	public void menuBorrarOficina () throws ClassNotFoundException, SQLException {
		
		sc = MiScanner.getInstance();
			
		System.out.println("Digame el codigo de la oficina a borrar:");
		String officeCode = sc.nextLine();
		
			
		OficinaController oc = new OficinaController();
		Integer listaCliente = oc.borrarOficina(officeCode);
	}
	
	public void menuGeneralOficina() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		int n=0;
		
		do {
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE OFICINAS");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar oficina por código, ciudad, estado y país");
		    System.out.println("2. Insertar oficina");
		    System.out.println("3. Actualizar oficina");
		    System.out.println("4. Borrar oficina");
		    System.out.println("5. Volver al menú principal");
		    System.out.println("===============================================");
		    
		  
		    n = Integer.parseInt(sc.nextLine());
		   
		    	
	            if (n>5||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if(n == 1) {
	            	menuRecuperarOficina();
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	menuInsertarOficina();
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuActualizarOficina();
	            	continue;
	            }
	            if(n == 4) {
	            	menuBorrarOficina();
	            	continue;
	            }
	            
	            if ( n == 5) {
	            	System.out.println("Volviendo a menú principal");
	            	continue;
	            }

		    } while(n!=5);
	}
}


