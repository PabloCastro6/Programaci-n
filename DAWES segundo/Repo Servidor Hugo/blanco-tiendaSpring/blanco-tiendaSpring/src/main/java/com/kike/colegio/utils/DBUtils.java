package com.kike.colegio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

	private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);

	private static SessionFactory sessionFactory;

	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {

			sessionFactory = new Configuration().configure().buildSessionFactory();

		}

		return sessionFactory;

	}

	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
		String user = "root";
		String pass = "PracticaRoot";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		logger.info("Establecida la conexión a la BBDD");
		return connection;
	}

//	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException, NamingException {
//	
//		Context  ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
//		
//		Connection con = ds.getConnection();
//		return con;
//	}
}
