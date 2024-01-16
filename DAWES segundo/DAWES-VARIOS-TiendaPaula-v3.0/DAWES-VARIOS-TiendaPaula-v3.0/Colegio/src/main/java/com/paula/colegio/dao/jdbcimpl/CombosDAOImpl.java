package com.paula.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.paula.colegio.dao.ICombosDAO;
import com.paula.colegio.dtos.ComboDTO;
import com.paula.colegio.utils.DBUtils;

@Component
public class CombosDAOImpl implements ICombosDAO {

	@Override
	public List<ComboDTO> recuperarCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT id_municipio, nombre FROM municipios ORDER BY nombre";

		Connection connection = DBUtils.conectaBBDD();
		List<ComboDTO> listaMunicipios = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while (rs.next()) {
			listaMunicipios.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		connection.close();
		return listaMunicipios;
	}
}
