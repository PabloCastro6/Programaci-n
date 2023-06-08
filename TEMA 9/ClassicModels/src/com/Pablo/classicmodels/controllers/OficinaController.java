package com.Pablo.classicmodels.controllers;

import java.sql.SQLException;
import java.util.List;

import com.Pablo.classicmodels.dtos.LineaProductosDTO;
import com.Pablo.classicmodels.dtos.OficinaDTO;
import com.Pablo.classicmodels.model.LineaProductosModelo;

public class OficinaController {
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

	public List<OficinaDTO> recuperarOficina(String officeCode, String city, String state, String country) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer insertarOficina(String officeCode, String city, String phone, String addressLine1,
			String addressLine2, String state, String country, String postalCode, String territory) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer actualizarOficina(String officeCode, String city, String phone, String addressLine1,
			String addressLine2, String state, String country, String postalCode, String territory) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer borrarOficina(String officeCode) {
		// TODO Auto-generated method stub
		return null;
	}


	}

	
	

	
	


