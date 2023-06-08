package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.EmpleadosDTO;
import com.Pablo.classicmodels.model.EmpleadosModelo;
import com.Pablo.classicmodels.model.PedidosModelo;

public class EmpleadoController {
public List<EmpleadosDTO> consultarEmpleado(Integer employeeNumber, String lastName, String firstName, String extension, String jobTitle) throws ClassNotFoundException, SQLException{
		
		PedidosModelo em = new PedidosModelo();
		
		return em.consultarEmpleados(employeeNumber, lastName, firstName, extension, jobTitle);
	}
	
	public Integer insertarEmpleado(Integer employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) throws SQLException, ClassNotFoundException {
		
		EmpleadosModelo em = new EmpleadosModelo();
		
		return em.insertarEmpleado(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
	}	
	
	public Integer actualizarEmpleado(Integer employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) throws SQLException, ClassNotFoundException {
		
		EmpleadosModelo em = new EmpleadosModelo();
		
		return em.actualizarEmpleado(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
	}	
	
	public Integer borrarEmpleado(Integer employeeNumber) throws SQLException, ClassNotFoundException {
	
		EmpleadosModelo em = new EmpleadosModelo();
		
		return em.borrarEmpleado(employeeNumber);
	}
}

