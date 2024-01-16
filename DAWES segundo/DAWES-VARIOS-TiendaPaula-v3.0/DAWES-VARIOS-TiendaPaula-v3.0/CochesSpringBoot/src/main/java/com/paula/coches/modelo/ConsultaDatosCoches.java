package com.paula.coches.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;


@Component
public class ConsultaDatosCoches implements IConsultaDatosCoches {

	public Integer consultaCoches(String nombre) throws IOException {
		
		File f = ResourceUtils.getFile("classpath:Coches.txt");
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
