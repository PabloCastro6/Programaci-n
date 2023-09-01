package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.AlumnoDTO;
import utils.Utils;

public class AlumnoModelo {

	 public static boolean borrar(int id) throws SQLException {
	        try {
	            Connection connection = Utils.conectar();
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM alumnos WHERE id = ?");
	            statement.setInt(1, id);
	            int count = statement.executeUpdate();
	            connection.close();
	            return count > 0;
	        } catch (ClassNotFoundException exception) {
	            System.err.println(exception.getMessage());
	            return false;
	        }
	    }	


	 public static boolean crear(AlumnoDTO alumno) throws SQLException {
	        try {
	            Connection connection = Utils.conectar();
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO alumnos (nombre, id_municipio, familia_numerosa) VALUES (?, ?, ?)");
	            statement.setString(1, alumno.getNombre());
	            statement.setInt(2, alumno.getIdMunicipio());
	            statement.setInt(3, alumno.getFamiliaNumerosa());
	            int count = statement.executeUpdate();
	            connection.close();
	            return count > 0;
	        } catch (ClassNotFoundException exception) {
	            System.err.println(exception.getMessage());
	            return false;
	        }
	    }


	 public static AlumnoDTO buscar(int id) throws SQLException {
	        try {
	            Connection connection = Utils.conectar();
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM alumnos al LEFT JOIN municipios m ON al.id = m.id WHERE a1.id = ?");
	            statement.setInt(1, id);
	            ResultSet result = statement.executeQuery();
	            AlumnoDTO alumno = null;

	            if (result.next()) {
	                int idUsuario = result.getInt("id");
	                String nombre = result.getString("nombre");
	                int municipio = result.getInt("id_municipio");
	                int familiaNumerosa = result.getInt("familia_numerosa");
	                
	               
					alumno = new AlumnoDTO(id, nombre, municipio, familiaNumerosa);
	            }

	            connection.close();
	            return alumno;
	        } catch (ClassNotFoundException exception) {
	            System.err.println(exception.getMessage());
	            return null;
	        }
	    }
	 
	 public static boolean actualizar(AlumnoDTO alumno) throws SQLException {
	        try {
	            Connection connection = Utils.conectar();
	            PreparedStatement statement = connection.prepareStatement("UPDATE alumnos "
	            + "SET nombre = CASE WHEN ? = '' THEN nombre ELSE ? END, " 
	            + "id_municipio = CASE WHEN ? = '' THEN id_municipio ELSE ? END, " 
	            + "familia_numerosa = CASE WHEN ? = '' THEN familia_numerosa ELSE ? END, " 
	            + "WHERE id = ?"); 
	            statement.setString(1, alumno.getNombre());
	            statement.setString(2, alumno.getNombre());
	            statement.setInt(3, alumno.getIdMunicipio());
	            statement.setInt(4, alumno.getIdMunicipio());
	            statement.setInt(5, alumno.getFamiliaNumerosa());
	            statement.setInt(6, alumno.getFamiliaNumerosa());
	            statement.setInt(9, alumno.getId());
	            int count = statement.executeUpdate();
	            connection.close();
	            return count > 0;
	        } catch (ClassNotFoundException exception) {
	            System.err.println(exception.getMessage());
	            return false;
	        }
	    }

}

