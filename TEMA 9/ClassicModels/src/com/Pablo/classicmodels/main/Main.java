package com.Pablo.classicmodels.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.utils.DBUtils;
import com.Pablo.classicmodels.vistas.VistaClientes;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		
	VistaClientes v = new VistaClientes();
	v.recuperarClienteFiltraPorNombre();
	v.menuInsertarCliente();
		
		
	}

	


}
