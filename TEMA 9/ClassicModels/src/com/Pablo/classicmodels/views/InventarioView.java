package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.InventarioController;
import com.Pablo.classicmodels.dtos.InventarioDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class InventarioView {
Scanner sc;
	
	public void menuConsultarInventario() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame el código del producto a buscar:");
		String productCode = sc.nextLine();
		
		System.out.println("Digame el nombre del producto:");
		String productName = sc.nextLine();
		
		System.out.println("Digame la linea de producto:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la descripción a buscar:");
		String productDescription = sc.nextLine();
		
		InventarioController ic = new InventarioController();
		List<InventarioDTO> listaProductos = ic.consultarInventario(productCode, productName, productLine, productDescription);
		
		for(InventarioDTO i : listaProductos) {
			System.out.println(i.toString());
		}
	}
	
	public void menuInsertarProducto() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el código del producto a insertar:");
		String productCode = sc.nextLine();
		
		System.out.println("Digame el nombre del producto a insertar:");
		String productName = sc.nextLine();
		
		System.out.println("Digame la linea del producto a insertar:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la escala del producto a insertar:");
		String productScale = sc.nextLine();
		
		System.out.println("Digame el vendedor del producto a insertar:");
		String productVendor = sc.nextLine();
		
		System.out.println("Digame la descripción del producto a insertar:");
		String productDescription = sc.nextLine();
		
		System.out.println("Digame el Stock del producto a insertar:");
		Integer quantityInStock = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el precio de compra del producto a insertar:");
		Double buyPrice = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Digame el MSRP del producto a insertar:");
		Double MSRP = sc.nextDouble();
		sc.nextLine();
		
		
		InventarioController ic = new InventarioController();
		Integer insertarProducto = ic.insertarProducto( productCode, productName, productLine, productScale, productVendor, productDescription,  quantityInStock,  buyPrice,  MSRP);
	}
	
	public void menuActualizarProducto() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el código del producto a actualizar:");
		String productCode = sc.nextLine();
		
		System.out.println("Digame el nombre del producto a actualizar:");
		String productName = sc.nextLine();
		
		System.out.println("Digame la linea del producto a actualizar:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la escala del producto a actualizar:");
		String productScale = sc.nextLine();
		
		System.out.println("Digame el vendedor del producto a actualizar:");
		String productVendor = sc.nextLine();
		
		System.out.println("Digame la descripción del producto a actualizar:");
		String productDescription = sc.nextLine();
		
		System.out.println("Digame el Stock del producto a actualizar:");
		Integer quantityInStock = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el precio de compra del producto a actualizar:");
		Double buyPrice = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Digame el MSRP del producto a actualizar:");
		Double MSRP = sc.nextDouble();
		sc.nextLine();

	
		
		
		InventarioController ic = new InventarioController();
		Integer actualizarProducto = ic.actualizarProducto(productCode, productName, productLine, productScale, productVendor, productDescription,  quantityInStock,  buyPrice,  MSRP);
	}
	
	public void menuBorrarProducto() throws SQLException, ClassNotFoundException {

		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el código del producto a borrar:");
		String customerNumber = sc.nextLine();
		
		InventarioController ic = new InventarioController();
		Integer borrarProducto = ic.borrarProducto(customerNumber);
		System.out.println("cliente " + customerNumber + " borrado con exito");
	}
	
	
	
	public void menuGeneralInventario() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		int n=0;
		
		do {
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE INVENTARIO");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar producto por código, nombre, linea y descripción");
		    System.out.println("2. Insertar producto");
		    System.out.println("3. Actualizar producto");
		    System.out.println("4. Borrar producto");
		    System.out.println("5. Volver al menú principal");
		    System.out.println("===============================================");
		    
		  
		    n = Integer.parseInt(sc.nextLine());
		   
		    	
	            if (n>5||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if(n == 1) {
	            	menuConsultarInventario();
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	menuInsertarProducto();
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuActualizarProducto();
	            	continue;
	            }
	            if(n == 4) {
	            	menuBorrarProducto();
	            	continue;
	            }
	            
	            if ( n == 5) {
	            	System.out.println("Volviendo a menu principal...");
	            	return;
	            }

		    } while(n!=6);
	}
}

