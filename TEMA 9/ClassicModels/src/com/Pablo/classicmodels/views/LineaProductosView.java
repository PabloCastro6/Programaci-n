package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.LineaProductosController;
import com.Pablo.classicmodels.dtos.LineaProductosDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class LineaProductosView {
Scanner sc;
	
	public void menuConsultarLineaProductos() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame la linea de productos a buscar:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la descripción a buscar:");
		String textDescription = sc.nextLine();

		
		LineaProductosController lpc = new LineaProductosController();
		List<LineaProductosDTO> listaLineaProductos = lpc.consultarLineaProductos(productLine, textDescription);
		
		for(LineaProductosDTO lp : listaLineaProductos) {
			System.out.println(lp.toString());
		}
	}
	
	public void menuInsertarLineaProductos() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame la linea de productos a buscar:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la descripción a buscar:");
		String textDescription = sc.nextLine();
		
		
		LineaProductosController lpc = new LineaProductosController();
		Integer insertarLineaProducto = lpc.insertarLineaProductos(productLine, textDescription);
	}
	
	public void menuActualizarLineaProductos() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame la linea de productos a buscar:");
		String productLine = sc.nextLine();
		
		System.out.println("Digame la descripción a buscar:");
		String textDescription = sc.nextLine();

		
		LineaProductosController lpc = new LineaProductosController();
		Integer actualizarLineaProducto = lpc.azctualizarLineaProductos(productLine, textDescription);
	}
	
	public void menuBorrarLineaProductos() throws SQLException, ClassNotFoundException {

		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame la linea de productos a buscar:");
		String productLine = sc.nextLine();
		
		
		LineaProductosController lpc = new LineaProductosController();
		Integer borrarLineaProducto = lpc.borrarLineaProductos(productLine);
		System.out.println("cliente " + productLine + " borrado con exito");
	}
	
	public void menuGeneralLineaProductos() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		int n=0;
		
		do {
			
		    System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE LINEAS DE PRODUCTOS");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar linea de productos por nombre o descripción");
		    System.out.println("2. Insertar linea de productos");
		    System.out.println("3. Actualizar linea de productos");
		    System.out.println("4. Borrar linea de productos");
		    System.out.println("5. Volver al menú principal");
		    System.out.println("===============================================");
		    
		  
		    n = Integer.parseInt(sc.nextLine());
		   
		    	
	            if (n>5||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if(n == 1) {
	            	menuConsultarLineaProductos();
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	menuInsertarLineaProductos();
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuActualizarLineaProductos();
	            	continue;
	            }
	            if(n == 4) {
	            	menuBorrarLineaProductos();
	            	continue;
	            }
	            
	            if ( n == 5) {
	            	System.out.println("Volviendo a menú principal");
	            	return;
	            }
	            
		} while(n!=5);
	}
}

