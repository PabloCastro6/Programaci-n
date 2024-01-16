package com.paula.coches.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.coches.modelo.IConsultaDatosCoches;

@Component
public class NumeroCoches implements INumeroCoches {
	
	@Autowired
	IConsultaDatosCoches consultaCoches;

	public Integer calculaNumeroCoches(String nombre) throws IOException {
		
		//ConsultaDatosCoches numCoches = new ConsultaDatosCoches();
		
		return consultaCoches.consultaCoches(nombre);
	}
}
