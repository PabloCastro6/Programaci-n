package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.EmpleadosDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class EmpleadosModelo {
public List<EmpleadosDTO> consultarEmpleados (Integer employeeNumber, String lastName, String firstName, String extension, String jobTitle) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM employees WHERE employeeNumber LIKE ? AND lastName LIKE ? AND firstName LIKE ? AND extension LIKE ?AND jobTitle LIKE ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setInt(1,employeeNumber);
		ps.setString(2,"%" + lastName + "%");
		ps.setString(3,"%" + firstName + "%");
		ps.setString(4,"%" + extension + "%");
		ps.setString(5,"%" + jobTitle + "%");

		ResultSet rs = ps.executeQuery();
		
		List<EmpleadosDTO> listaEmpleados = new ArrayList<>();
		
		while (rs.next()) {
			EmpleadosDTO e = new EmpleadosDTO(rs.getInt("employeeNumber"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("extension"), rs.getString("email"), rs.getString("officeCode"), rs.getInt("reportsTo"), rs.getString("jobTitle"));
			listaEmpleados.add(e);
		}
		
		conexionBBDD.close();
		return listaEmpleados;
	}
	
	public Integer insertarEmpleado(Integer employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) throws SQLException, ClassNotFoundException {
		
		String sql ="INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, employeeNumber);
		ps.setString(2, lastName);
		ps.setString(3, firstName);
		ps.setString(4, extension);
		ps.setString(5, email);
		ps.setString(6, officeCode);
		ps.setInt(7, reportsTo);
		ps.setString(8, jobTitle);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
	
	public Integer actualizarEmpleado(Integer employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) throws SQLException, ClassNotFoundException {
			
		String query ="UPDATE employees SET lastName = case when ? ='' then lastName else ? END, "
				+ "firstName = case when ? ='' then firstName else ? END, "
				+ "extension = case when ? ='' then extension else ? END, "
				+ "email = case when ? ='' then email else ? END, "
				+ "officeCode = case when ? ='' then officeCode else ? END, "
				+ "reportsTo = case when ? ='' then reportsTo else ? END, "
				+ "jobTitle = case when ? ='' then jobTitle else ? "
				+ "END "
				+ "WHERE employeeNumber = ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1, lastName);
		ps.setString(2, lastName);
		
		ps.setString(3, firstName);
		ps.setString(4, firstName);
		
		ps.setString(5, extension);
		ps.setString(6, extension);
		
		ps.setString(7, email);
		ps.setString(8, email);
		
		ps.setString(9, officeCode);
		ps.setString(10, officeCode);
		
		ps.setInt(11, reportsTo);
		ps.setInt(12, reportsTo);
		
		ps.setString(13, jobTitle);
		ps.setString(14, jobTitle);

		ps.setInt(15, employeeNumber);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		
		return resultado;
	}
	
	public Integer borrarEmpleado(int employeeNumber) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM employees WHERE employeeNumber = ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, employeeNumber);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
}

