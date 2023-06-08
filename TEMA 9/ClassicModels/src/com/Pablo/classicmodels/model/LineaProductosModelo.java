package com.Pablo.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.LineaProductosDTO;
import com.Pablo.classicmodels.utils.DBUtils;

public class LineaProductosModelo {
public List<LineaProductosDTO> consultarLineaProductos (String productLine, String textDescription) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM productlines WHERE productLine LIKE ? AND textDescription LIKE ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,"%" + productLine + "%");
		ps.setString(2,"%" +  textDescription + "%");
		
		ResultSet rs = ps.executeQuery();
		
		List<LineaProductosDTO> listaInventario = new ArrayList<>();
		
		while (rs.next()) {
			LineaProductosDTO l = new LineaProductosDTO(rs.getString("productLine"),rs.getString("textDescription"));
			listaInventario.add(l);
		}
		
		conexionBBDD.close();
		return listaInventario;
	}
	
	public Integer insertarLineaProductos(String productLine, String textDescription) throws SQLException, ClassNotFoundException {
		
		String sql ="INSERT INTO productlines (productLine, textDescription) values (?, ? )";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, productLine);
		ps.setString(2, textDescription);

		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
	
	public Integer azctualizarLineaProductos(String productLine, String textDescription) throws SQLException, ClassNotFoundException {
		
		String query ="UPDATE productlines SET textDescription = case when ? ='' then textDescription else ? END "
				+ "WHERE productLine = ? ";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1, textDescription);
		ps.setString(2, textDescription);

		ps.setString(3, productLine);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		
		return resultado;
	}
	
	public Integer borrarLineaProductos(String productLine) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM productlines WHERE productLine LIKE ?";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setString(1, productLine);
		
		Integer resultado = ps.executeUpdate();
		conexionBBDD.close();
		
		return resultado;
	}
}

