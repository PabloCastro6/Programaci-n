package com.Pablo.classicmodels.views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Pablo.classicmodels.controllers.EmpleadoController;
import com.Pablo.classicmodels.dtos.EmpleadosDTO;
import com.Pablo.classicmodels.utils.MiScanner;

public class EmpleadosView {
Scanner sc;
	
	public void menuConsultarEmpleados() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		
		System.out.println("Digame el número de empleado a buscar:");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el apellido a buscar:");
		String lastName = sc.nextLine();
		
		System.out.println("Digame el nombre a buscar:");
		String firstName = sc.nextLine();
		
		System.out.println("Digame la extensión a buscar:");
		String extension = sc.nextLine();
		
		System.out.println("Digame el puesto a buscar:");
		String jobTitle = sc.nextLine();
		
		EmpleadoController ec = new EmpleadoController();
		List<EmpleadosDTO> listaCliente = ec.consultarEmpleado(employeeNumber, lastName, firstName, extension, jobTitle);
		
		for(EmpleadosDTO e : listaCliente) {
			System.out.println(e.toString());
		}
	}
	
	public void menuInsertarEmpleado() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el número de empleado a buscar:");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el apellido a buscar:");
		String lastName = sc.nextLine();
		
		System.out.println("Digame el nombre a buscar:");
		String firstName = sc.nextLine();
		
		System.out.println("Digame la extensión a buscar:");
		String extension = sc.nextLine();
		
		System.out.println("Digame el email a buscar:");
		String email = sc.nextLine();
		
		System.out.println("Digame el codigo de oficina a buscar:");
		String officeCode = sc.nextLine();
		
		System.out.println("Digame el reportsTo a buscar:");
		Integer reportsTo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el puesto a buscar:");
		String jobTitle = sc.nextLine();
		
		
		EmpleadoController ec = new EmpleadoController();
		Integer insertarEmpleado = ec.insertarEmpleado(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
	}
	
	public void menuActualizarEmpleado() throws SQLException, ClassNotFoundException {
		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el número de empleado a actualizar:");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el apellido a actualizar:");
		String lastName = sc.nextLine();
		
		System.out.println("Digame el nombre a actualizar:");
		String firstName = sc.nextLine();
		
		System.out.println("Digame la extensión a actualizar:");
		String extension = sc.nextLine();
		
		System.out.println("Digame el email a actualizar:");
		String email = sc.nextLine();
		
		System.out.println("Digame el codigo de oficina a actualizar:");
		String officeCode = sc.nextLine();
		
		System.out.println("Digame el reportsTo a actualizar:");
		Integer reportsTo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digame el puesto a actualizar:");
		String jobTitle = sc.nextLine();
		
		
		EmpleadoController ec = new EmpleadoController();
		Integer actualizarEmpleado = ec.actualizarEmpleado(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
	}
	
	public void menuBorrarEmpleado() throws SQLException, ClassNotFoundException {

		sc = MiScanner.getInstance();
		
		
		System.out.println("Digame el número de empleado a borrar:");
		Integer employeeNumber = sc.nextInt();
		sc.nextLine();
		
		EmpleadoController ec = new EmpleadoController();
		Integer borrarClientes = ec.borrarEmpleado(employeeNumber);
		System.out.println("cliente " + employeeNumber + " borrado con exito");
	}
	
	public void menuGeneralEmpleado() throws ClassNotFoundException, SQLException {
		sc = MiScanner.getInstance();
		int n=0;
		
		do {
			
		    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE CLIENTES");
		    System.out.println("===============================================");
		    System.out.println("2. Buscar empleado");
		    System.out.println("3. Insertar empleado");
		    System.out.println("4. Actualizar empleado");
		    System.out.println("5. Borrar empleado");
		    System.out.println("6. Volver al menú principal");
		    System.out.println("===============================================");
		    
		  
		    n = Integer.parseInt(sc.nextLine());
		   
		    	
	            if (n>5||n<1){
	                System.out.print("Elección invalida, inténtalo otra vez...");
	                continue;
	            }
	            if(n == 1) {
	            	menuConsultarEmpleados();;
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	menuInsertarEmpleado();;
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuActualizarEmpleado();;
	            	continue;
	            }
	            if(n == 4) {
	            	menuBorrarEmpleado();
	            	continue;
	            }
	            
	            if ( n == 5) {
	            	System.out.println("Volviendo a menú principal");
	            	return;
	            }

		    } while(n!=5);
	}
}

