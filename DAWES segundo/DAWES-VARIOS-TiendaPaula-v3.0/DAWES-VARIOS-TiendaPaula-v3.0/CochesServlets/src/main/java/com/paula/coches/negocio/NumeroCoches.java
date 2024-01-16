package com.paula.coches.negocio;

import java.io.IOException;

import com.paula.coches.modelo.ConsultaDatosCoches;

public class NumeroCoches {

	public Integer calculaNumeroCoches(String nombre) throws IOException {
		
		ConsultaDatosCoches numCoches = new ConsultaDatosCoches();
		
		return numCoches.consultaCoches(nombre);
	}
}
