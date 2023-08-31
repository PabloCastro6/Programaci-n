package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.BancoDTO;
import utils.Utils;

public class ClientesModelo {
	public static void borrarCliente(int id) throws ClassNotFoundException, SQLException {
		
		String consulta = "DELETE FROM clientes WHERE id_usuario = ? ";
		Connection connection = Utils.conectar();
		
		PreparedStatement statement = connection.prepareStatement(consulta); //para poder mandarla la consulta a la BBDD 
		
		statement.setInt(1, id );
	
	
	statement.executeUpdate();  // Para ejecutar la consulta 
	
	connection.close(); 
		
		
	}
	
	public static BancoDTO buscarCliente (int id) throws ClassNotFoundException, SQLException {
		
		String consulta = "SELECT * FROM clientes JOIN cuentas ON clientes.id_usuario = cuentas.id_usuario WHERE clientes.id_usuario = ?  ";
		Connection connection = Utils.conectar();
		PreparedStatement statement = connection.prepareStatement(consulta);
		
		statement.setInt(1, id);
		
		ResultSet result = statement.executeQuery();
		
		if (result.next()) {

			BancoDTO cliente = new BancoDTO(result.getInt("id_usuario"),result.getString("nombre"), result.getString("apellido"), result.getString("telefono"),result.getString("direccion"), result.getInt("numero_cuenta"), result.getDouble("saldo")); // Los nombres tienen que ser los nombres de la BBDD
					
			
			connection.close();
			
			return cliente;
		}
		return null;
		
	}
	
	
	
	
	public static void  crearCliente(BancoDTO cliente) throws ClassNotFoundException, SQLException {
		String consulta = "INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES (?,?,?,?)";
		Connection conexion = Utils.conectar(); // conectar a la BBDD desde utils
		PreparedStatement ps = conexion.prepareStatement(consulta); 
		
		ps.setString(1,cliente.getNombre());
		ps.setString(2,cliente.getApellido());
		ps.setString(3,cliente.getDireccion());
		ps.setString(4,cliente.getTelefono());
		
		
		int resultado = ps.executeUpdate();
		
		
	}
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
