package com.gon.tienda.dao.tiendaimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gon.tienda.dao.ICombosDAO;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.utils.DBUtils;

@Component
public class CombosDAOImpl implements ICombosDAO{

	@Override
	public List<ComboDTO> recuperaComboProveedores() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM proveedores ORDER BY nombre";
		
		List<ComboDTO>listaProveedores = new ArrayList<>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaProveedores.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		return listaProveedores;
	}

	@Override
	public List<ComboDTO> recuperaComboCategorias() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM categorias ORDER BY nombre";
		
		List<ComboDTO>listaCategorias = new ArrayList<>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaCategorias.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		return listaCategorias;
	}

	@Override
	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM poblacion ORDER BY nombre";
		
		List<ComboDTO>listaMunicipio = new ArrayList<>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaMunicipio.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		return listaMunicipio;
	}

}

