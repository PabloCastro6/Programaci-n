package com.paula.tienda.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dao.ICombosDAO;
import com.paula.tienda.dtos.CombosDTO;
import com.paula.tienda.utils.DBUtils;

public class CombosDAOImpl implements ICombosDAO {

	@Override
	public List<CombosDTO> recuperarCombosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_Categoria, Nombre FROM categorias ORDER BY Nombre";

		Connection connection = DBUtils.conectaBBDD();
		List<CombosDTO> listaCategorias = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaCategorias.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaCategorias;
	}

	@Override
	public List<CombosDTO> recuperarCombosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT ID_Proveedor, Nombre FROM proveedores ORDER BY Nombre";

		Connection connection = DBUtils.conectaBBDD();
		List<CombosDTO> listaProveedores = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProveedores.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaProveedores;
	}

	@Override
	public List<CombosDTO> recuperarCombosPoblaciones() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT ID, Nombre FROM poblacion ORDER BY ID";

		Connection connection = DBUtils.conectaBBDD();
		List<CombosDTO> listaPoblaciones = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaPoblaciones.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaPoblaciones;
	}
}
