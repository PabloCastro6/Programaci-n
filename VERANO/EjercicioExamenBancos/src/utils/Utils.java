package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

	public static  Connection conectar() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/bancos";
		String user = "root";
		String password = "1234";
		
		Connection bbdd = DriverManager.getConnection(servidor, user, password);
		return bbdd;
		
	}
}
