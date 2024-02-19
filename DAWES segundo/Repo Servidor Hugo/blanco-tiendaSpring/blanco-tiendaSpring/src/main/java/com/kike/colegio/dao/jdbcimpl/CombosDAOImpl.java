package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.DBUtils;

@Component
public class CombosDAOImpl implements ICombosDAO {

	@Override
	public List<ComboDTO> recuperaComboProveedores() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_proveedor, nombre FROM proveedores ORDER BY nombre";

		List<ComboDTO> listaMunicipios = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaMunicipios.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> recuperaComboCategorias() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_Categoria, nombre FROM categorias ORDER BY nombre";

		List<ComboDTO> listaMunicipios = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaMunicipios.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> recuperaComboPoblacion() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID, nombre FROM poblacion ORDER BY nombre";

		List<ComboDTO> listaPoblacion = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaPoblacion.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaPoblacion;
	}

	@Override
	public List<ComboDTO> recuperaComboClientes() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_Cliente, nombre FROM clientes ORDER BY nombre";

		List<ComboDTO> listaClientes = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaClientes.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaClientes;
	}

	@Override
	public List<ComboDTO> recuperaComboProductos() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT ID_Producto, nombre FROM productos ORDER BY nombre";

		List<ComboDTO> listaProductos = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaProductos.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaProductos;
	}

	@Override
	public List<ComboDTO> recuperaComboEstados() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT EstadoID, NombreEstado FROM estadospedidos ORDER BY NombreEstado";

		List<ComboDTO> listaEstados = new ArrayList<>();

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaEstados.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();

		return listaEstados;
	}

}
