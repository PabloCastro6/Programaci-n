package com.gon.tienda.dao.tiendaimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.gon.tienda.dao.CategoriasDAO;
import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.utils.DBUtils;


public class CategoriasDAOImplTienda implements CategoriasDAO {
	
	
	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT c.ID_Categoria, c.Nombre, c.Descripcion, c.Activo FROM categorias c WHERE c.ID_Categoria like ?"
				+ " and c.Nombre like ?"
				+ " and c.Descripcion like ?"
				+ " and c.Activo = ? " ;
	
	Connection connection = DBUtils.conectaBBDD();
	List<CategoriaDTO> listaCategoria= new ArrayList<>();
	
	PreparedStatement ps = connection.prepareStatement(sql);
	
	ps.setString(1, "%" + id + "%");
	ps.setString(2, "%" + nombre + "%");
	ps.setString(3, "%" + descripcion + "%");
	ps.setString(4, activo );
	
	
	ResultSet rs = ps.executeQuery();
	System.out.println(ps.toString());
	
	while(rs.next()) {
		listaCategoria.add(new CategoriaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		
	}
	connection.close();
	return listaCategoria;
	}
	

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT into categorias (nombre, descripcion, activo) "
				+ " VALUES (?, ?, ?) " ;
	
		Connection connection = DBUtils.conectaBBDD();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		
		Integer resultado = ps.executeUpdate();
		System.out.println(ps.toString());
		
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE categorias set nombre = ?, descripcion = ?, activo = ? "
				+ " WHERE ID_Categoria = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		ps.setString(4, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE categorias SET activo = 0 "
				+ " WHERE ID_Categoria = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

//	@Override
//	public Integer insertarCategorias(String nombre, String descripcion, String activo)
//			throws ClassNotFoundException, SQLException {
//
//		String sql = "INSERT INTO categorias (id, nombre, descripcion, activo)"
//					+ " VALUES (?,?,?,?)";
//		
//		Connection connection = DBUtils.conectaBBDD();
//		
//		PreparedStatement ps = connection.prepareStatement(sql);
//		
//		ps.setString(1, id);
//		ps.setString(2, nombre);
//		ps.setString(3, apellido);
//		ps.setString(4, municipio);
//		ps.setString(5, famNumerosa);
//		ps.setString(6, activo);
//		
//		Integer resultado = ps.executeUpdate();
//		System.out.println(ps.toString());
//		connection.close();
//		return resultado;
//	}
//
//	@Override
//	public Integer actualizarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
//			String municipio) throws ClassNotFoundException, SQLException {
//
//		String sql = "UPDATE alumnos set nombre = ?, apellidos = ?, id_municipio = ?, familia_numerosa = ?, activo = ? "
//				+ " WHERE id = ? ";
//		
//		Connection connection = DBUtils.conectaBBDD();
//		
//		PreparedStatement ps = connection.prepareStatement(sql);
//		
//		ps.setString(1, nombre);
//		ps.setString(2, apellido);
//		ps.setString(3, municipio);
//		ps.setString(4, famNumerosa);
//		ps.setString(5, activo);
//		ps.setString(6, id);
//		
//		Integer resultado = ps.executeUpdate();
//		connection.close();
//		return resultado;
//	}
//
//	@Override
//	public Integer borrarAlumnos(String id) throws ClassNotFoundException, SQLException {
//		
//		String sql = "UPDATE alumnos SET activo = 0 "
//				+ " WHERE id = ? ";
//		
//		Connection connection = DBUtils.conectaBBDD();
//		
//		PreparedStatement ps = connection.prepareStatement(sql);
//		
//		ps.setString(1, id);
//		
//		Integer resultado = ps.executeUpdate();
//		connection.close();
//		return resultado;
//	}
//
//
//
//	@Override
//	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
//			throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
