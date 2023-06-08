package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.LineaProductosDTO;
import com.Pablo.classicmodels.model.LineaProductosModelo;

public class LineaProductosController {
public List<LineaProductosDTO> consultarLineaProductos(String productLine, String textDescription) throws ClassNotFoundException, SQLException{
		
		LineaProductosModelo lpm = new LineaProductosModelo();
		
		return lpm.consultarLineaProductos(productLine, textDescription);
	}
	
	public Integer insertarLineaProductos(String productLine, String textDescription) throws SQLException, ClassNotFoundException {
		
		LineaProductosModelo lpm = new LineaProductosModelo();
		
		return lpm.insertarLineaProductos(productLine, textDescription);
	}	
	
	public Integer azctualizarLineaProductos(String productLine, String textDescription) throws SQLException, ClassNotFoundException {
			
		LineaProductosModelo lpm = new LineaProductosModelo();
		
		return lpm.azctualizarLineaProductos(productLine, textDescription);
		}	
	
	public Integer borrarLineaProductos(String productLine) throws SQLException, ClassNotFoundException {
	
		LineaProductosModelo lpm = new LineaProductosModelo();
		
		return lpm.borrarLineaProductos(productLine);
		}
}

