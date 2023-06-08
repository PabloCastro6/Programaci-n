package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.InventarioDTO;
import com.Pablo.classicmodels.model.InventarioModelo;

public class InventarioController {
	public List<InventarioDTO> consultarInventario(String productCode, String productName, String productLine, String productDescription) throws ClassNotFoundException, SQLException{
		
		InventarioModelo im = new InventarioModelo();
			
			return im.consultarInventario(productCode, productName, productLine, productDescription);
		}
		
		public Integer insertarProducto(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantityInStock, Double buyPrice, Double MSRP) throws SQLException, ClassNotFoundException {
			
			InventarioModelo im = new InventarioModelo();
			
			return im.insertarProducto(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
		}	
		
		public Integer actualizarProducto(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantityInStock, Double buyPrice, Double MSRP) throws SQLException, ClassNotFoundException {
				
			InventarioModelo im = new InventarioModelo();
			
			return im.actualizarProducto(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
		}	
		
		public Integer borrarProducto(String productCode) throws SQLException, ClassNotFoundException {
		
			InventarioModelo im = new InventarioModelo();
			
			return im.borrarProducto(productCode);
		}
	}

