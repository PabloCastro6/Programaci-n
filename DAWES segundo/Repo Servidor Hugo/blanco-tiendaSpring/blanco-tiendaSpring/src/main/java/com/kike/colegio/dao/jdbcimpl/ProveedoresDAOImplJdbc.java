package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProveedoresDAO;
import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.utils.DBUtils;

@Component("proveedoresJDBC")
public class ProveedoresDAOImplJdbc implements ProveedoresDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProveedoresDAOImplJdbc.class);

	@Override
	public List<ProvedoresDTO> obtenerTodosProveedores() throws ClassNotFoundException, SQLException, NamingException {
//        ResultSet proveedoresResultSet = null;
//        List<ProvedoresDTO> listaProveedores = new ArrayList<>();
//        Connection connection = DBUtils.conectaBBDD();
//
//        Statement st = connection.createStatement();
//        proveedoresResultSet = st.executeQuery("SELECT * FROM proveedores");
//
//        while (proveedoresResultSet.next()) {
//            listaProveedores.add(new ProvedoresDTO(proveedoresResultSet.getInt(1), proveedoresResultSet.getString(2),
//                    proveedoresResultSet.getString(3), proveedoresResultSet.getString(4),
//                    proveedoresResultSet.getString(5), proveedoresResultSet.getString(6),
//                    proveedoresResultSet.getInt(7)));
//            logger.info("Añadido proveedor " + proveedoresResultSet.getInt(1) + " " + proveedoresResultSet.getString(2));
//        }
//
//        return listaProveedores;
		return null;
	}

	@Override
	public List<ProvedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT ID_Proveedor, nombre, contacto, telefono, CorreoElectronico, direccion, activo "
				+ " FROM proveedores   "
				+ " WHERE ID_Proveedor LIKE ? AND nombre LIKE ? AND contacto LIKE ? AND telefono LIKE ? "
				+ " AND CorreoElectronico LIKE ? AND direccion LIKE ? AND activo = ? ";

		Connection connection = DBUtils.conectaBBDD();
		List<ProvedoresDTO> listaProveedores = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + contacto + "%");
		ps.setString(4, "%" + telefono + "%");
		ps.setString(5, "%" + correo + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, activo);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaProveedores.add(new ProvedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		connection.close();
		return listaProveedores;
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO proveedores (nombre, contacto, telefono, CorreoElectronico, direccion, activo) "
				+ "  VALUES (?, ?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, contacto);
		ps.setString(3, telefono);
		ps.setString(4, correo);
		ps.setString(5, direccion);
		ps.setString(6, activo);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE proveedores set nombre = ?, contacto = ?, telefono = ?, CorreoElectronico = ?, direccion = ?, activo = ?"
				+ "WHERE ID_Proveedor = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, contacto);
		ps.setString(3, telefono);
		ps.setString(4, correo);
		ps.setString(5, direccion);
		ps.setString(6, activo);
		ps.setString(7, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarProveedor(String id) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE proveedores SET activo = 0 " + "WHERE ID_Proveedor = ? ";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}
}
