package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.CantidadPedidaProductoDTO;
import com.Pablo.classicmodels.model.PedidosModelo;

public class PedidosController {
public Integer crearPedido(String orderDate, String requiredDate, String status,String comments, Integer customerNumber, List<CantidadPedidaProductoDTO> listaProductos) throws ClassNotFoundException, SQLException {
		
		PedidosModelo pm = new PedidosModelo();
		return pm.crearPedido(orderDate, requiredDate, status, comments, customerNumber, listaProductos);
		
	}
}

