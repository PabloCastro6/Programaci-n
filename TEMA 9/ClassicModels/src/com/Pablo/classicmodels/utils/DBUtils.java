package com.Pablo.classicmodels.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	public static Connection conexionBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/classicmodels";
		String username = "root";
		String password ="PracticaRoot";
		
		Connection conexionBBDD = DriverManager.getConnection(servidor,username,password);
		return conexionBBDD;
	}

}
