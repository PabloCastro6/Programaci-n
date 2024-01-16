package com.paula.tienda.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.paula.tienda.dao.ClientesDAO;
import com.paula.tienda.dtos.ClienteDTO;
import com.paula.tienda.utils.DBUtils;

@Component
public class ClientesDAOimpljdbc implements ClientesDAO {

//	@Override
//	public List<ClienteDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException {
//		
//		Connection connection = DBUtils.conectaBBDD();
//		ResultSet clientesRS = null;
//		
//		List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();
//		
//		Statement st = connection.createStatement();
//		clientesRS = st.executeQuery("SELECT * FROM clientes");
//		while (clientesRS.next()) {
//			listaClientes.add(new ClienteDTO(clientesRS.getInt(1), clientesRS.getString(2),
//					clientesRS.getString(3), clientesRS.getString(4), clientesRS.getInt(5),
//					clientesRS.getInt(6)));
//		}
//		return listaClientes;
//	}

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = null;

		if (poblacion.equals("")) {
			sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico , p.Nombre, c.ID_Poblacion, c.activo "
					+ " FROM clientes c " + " INNER JOIN poblacion p" + " ON p.ID = c.ID_Poblacion"
					+ " WHERE c.ID_Cliente LIKE ? AND c.Nombre LIKE ? AND c.CorreoElectronico LIKE ? "
					+ " AND c.activo = ? ";
		} else {
			sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico , p.Nombre, c.ID_Poblacion, c.activo "
					+ " FROM clientes c " + " INNER JOIN poblacion p" + " ON p.ID = c.ID_Poblacion"
					+ " WHERE c.ID_Cliente LIKE ? AND c.Nombre LIKE ? AND c.CorreoElectronico LIKE ? "
					+ " AND c.ID_Poblacion = ? AND c.activo = ? ";
		}

		Connection connection = DBUtils.conectaBBDD();
		List<ClienteDTO> listaClientes = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);
		
		if (poblacion.equals("")) {
			
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + correo + "%");
			ps.setString(4, activo);
			
		} else {
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + correo + "%");
			ps.setString(4, poblacion);
			ps.setString(5, activo);
		}
		
		System.out.println(ps.toString());
		ResultSet clientesRS = ps.executeQuery();
		while (clientesRS.next()) {
			listaClientes.add(new ClienteDTO(clientesRS.getInt(1), clientesRS.getString(2), clientesRS.getString(3),
					clientesRS.getString(4), clientesRS.getInt(5), clientesRS.getInt(6)));
		}

		connection.close();

		return listaClientes;
	}


	@Override
	public Integer insertarClientes(String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "INSERT INTO clientes(Nombre, CorreoElectronico, ID_Poblacion, activo)"
				+ "VALUES ( ? ,? ,? ,? )";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, poblacion);
		ps.setString(4, activo);

		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE clientes SET Nombre = ?, CorreoElectronico = ?, ID_Poblacion = ?, activo = ? "
	            + "WHERE ID_Cliente = ?";

	    Connection connection = DBUtils.conectaBBDD();
	    PreparedStatement ps = connection.prepareStatement(sql);
	   
	    ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, poblacion);
		ps.setString(4, activo);
		ps.setString(5, id);
	    
	    
	    Integer resultado = ps.executeUpdate();

	    connection.close();

	    return resultado;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "UPDATE clientes SET  activo = 0 " 
				+ "WHERE ID_Cliente = ?";

				Connection connection = DBUtils.conectaBBDD();
				PreparedStatement ps = connection.prepareStatement(sql);

			
				ps.setString(1, id);
				
			
				Integer resultado = ps.executeUpdate();

				connection.close();

				return resultado;
	}

}
