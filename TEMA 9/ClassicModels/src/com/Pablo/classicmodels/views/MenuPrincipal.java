package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.Scanner;

import com.Pablo.classicmodels.utils.MiScanner;

public class MenuPrincipal {
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TIENDA CLASSIC MODELS");
	    System.out.println("===============================================");
	    System.out.println("1. Gestión de inventario");
	    System.out.println("2. Gestión de lineas productos");
	    System.out.println("3. Gestión de clientes");
	    System.out.println("4. Gestión de empleados ");
	    System.out.println("5. Gestión de oficinas");
	    System.out.println("6. Gestión de Pedidos");
	    System.out.println("7. Salir de la aplicación");
	    System.out.println("===============================================");
	    
	  
	    n = Integer.parseInt(sc.nextLine());
	   
	    	
            if (n>7||n<1){
                System.out.print("Elección invalida, inténtalo otra vez...");
                continue;
            }
            
            if ( n == 1) {
            	InventarioView iv = new InventarioView();
            	iv.menuGeneralInventario();
            	continue;
            }
            
            if ( n == 2) {
            	LineaProductosView lpv = new LineaProductosView();
            	lpv.menuGeneralLineaProductos();
            	continue;
            }
            
            if ( n == 3) {
            	ClienteView cv = new ClienteView();
            	cv.menuGeneralCliente();
            	continue;
            }

            if ( n == 4) {
            	EmpleadosView ev = new EmpleadosView();
            	ev.menuGeneralEmpleado();
            	continue;
            }
            
            if ( n == 5) {
            	OficinaView cv = new OficinaView();
            	cv.menuGeneralOficina();
            	continue;
            }
            
            if ( n == 6) {
            	System.out.println("ahora ejecutaría la gestión de pedidos");
            	continue;
            }
            
            if ( n == 7) {
            	System.out.println("Volviendo a menú principal");
            	return;
            }
            
	    } while(n!=7);
	}
}


