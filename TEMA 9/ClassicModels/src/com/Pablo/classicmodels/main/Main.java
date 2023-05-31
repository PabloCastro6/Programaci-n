package com.Pablo.classicmodels.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Pablo.classicmodels.dtos.CantidadPedidaProducto;
import com.Pablo.classicmodels.dtos.ClienteDTO;
import com.Pablo.classicmodels.model.PedidosModelo;
import com.Pablo.classicmodels.utils.DBUtils;
import com.Pablo.classicmodels.vistas.VistaClientes;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		
//	VistaClientes v = new VistaClientes();
//	v.recuperarClienteFiltraPorNombre();
//	v.menuInsertarCliente();
		
		PedidosModelo pm = new PedidosModelo();
		
		List<CantidadPedidaProducto> listaProductos = new ArrayList<>();
		
		listaProductos.add(new CantidadPedidaProducto("S10_1678", 1));
		listaProductos.add(new CantidadPedidaProducto("S10_1949", 1));
		listaProductos.add(new CantidadPedidaProducto("S10_4698", 5));
		
		pm.crearPedido("2023-01-01", "2023-01-02", "shipped", "lo quiero ya" , 103, listaProductos);
		
	}

	


}
