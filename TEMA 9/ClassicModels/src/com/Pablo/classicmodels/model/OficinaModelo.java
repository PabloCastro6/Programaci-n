package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.OficinaDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class OficinaModelo {
public List<OficinaDTO> recuperarOficina (String officeCode, String city, String state, String country) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM offices WHERE officeCode LIKE ? AND city LIKE ? AND state LIKE ? AND country LIKE ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,"%" + officeCode + "%");
		ps.setString(2,"%" + city + "%");
		ps.setString(3,"%" + state + "%");
		ps.setString(4,"%" + country + "%");
		
		
		ResultSet rs = ps.executeQuery();
		
		List<OficinaDTO> listaCliente = new ArrayList<>();
		
		while (rs.next()) {
			OficinaDTO c = new OficinaDTO(rs.getString("officeCode"),rs.getString("city"), rs.getString("phone"), rs.getString("addressLine1"), rs.getString("addressLine2"),rs.getString("state"),rs.getString("country"),rs.getString("postalCode"),rs.getString("territory"));
			listaCliente.add(c);
		}
		
		conexionBBDD.close();
		return listaCliente;
	}

	public Integer insertarOficina(String  officeCode, String  city, String  phone, String  addressLine1, String  addressLine2, String  state, String  country, String  postalCode, String  territory) throws SQLException, ClassNotFoundException {
		
		String sql ="INSERT INTO offices (officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, officeCode);
		ps.setString(2, city);
		ps.setString(3, phone);
		ps.setString(4, addressLine1);
		ps.setString(5, addressLine2);
		ps.setString(6, state);
		ps.setString(7, country);
		ps.setString(8, postalCode);
		ps.setString(9, territory);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}

	public Integer actualizarOficina(String  officeCode, String  city, String  phone, String  addressLine1, String  addressLine2, String  state, String  country, String  postalCode, String  territory) throws SQLException, ClassNotFoundException {
		
		String query ="UPDATE offices SET city = case when ? ='' then city else ? END, "
				+ "phone = case when ? ='' then phone else ? END, "
				+ "phone = case when ? ='' then phone else ? END, "
				+ "addressLine1 = case when ? ='' then addressLine1 else ? END, "
				+ "addressLine2 = case when ? ='' then addressLine2 else ? END, "
				+ "state = case when ? ='' then state else ? END, "
				+ "country = case when ? ='' then country else ? END, "
				+ "territory = case when ? ='' then territory else ?"
				+ "END "
				+ "WHERE officeCode = ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
	
		ps.setString(1, city);
		ps.setString(2, city);
		
		ps.setString(3, phone);
		ps.setString(4, phone);
		
		ps.setString(5, addressLine1);
		ps.setString(6, addressLine1);
		
		ps.setString(7, addressLine2);
		ps.setString(8, addressLine2);
		
		ps.setString(9, state);
		ps.setString(10, state);
		
		ps.setString(11, country);
		ps.setString(12, country);
		
		ps.setString(13, postalCode);
		ps.setString(14, postalCode);
		
		ps.setString(15, territory);
		ps.setString(16, territory);
		
		ps.setString(17, officeCode);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		
		return resultado;
	}
	
	public Integer borrarOficina(String officeCode) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM offices WHERE officeCode = ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, officeCode);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
}

