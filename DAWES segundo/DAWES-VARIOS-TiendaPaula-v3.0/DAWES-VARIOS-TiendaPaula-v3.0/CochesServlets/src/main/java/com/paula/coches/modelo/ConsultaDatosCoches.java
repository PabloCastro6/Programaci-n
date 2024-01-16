package com.paula.coches.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatosCoches {

	public Integer consultaCoches(String nombre) throws IOException {
		
		String path = Thread.currentThread().getContextClassLoader().getResource("Coches.txt").getPath();
		File f = new File(path);
		BufferedReader lector = new BufferedReader(new FileReader(f)); 
		String linea;
		int contador = 0;

		while ((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				contador++ ;
			}
		}

		return contador;
	}
}
