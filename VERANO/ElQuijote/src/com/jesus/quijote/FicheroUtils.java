package com.jesus.quijote;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Clase con las utilidades para leer los ficheros.
 *
 * @autor Jesus Angel Gajate Luna.
 */
public class FicheroUtils {
	
	/**
	 * Metodo que cuenta el numero de palabras del archivo leeido.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
	public int hayPalabras() throws FileNotFoundException, IOException {
		int contador = 0;
		try (FileReader fr = new FileReader(Constantes.FICHERO_PALABRAS_A_BUSCAR, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(fr)) {
			while (br.readLine() != null) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Este metodo crea un array de tipo String en el que guardara las palabras encontradas en el fichero.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
	public String[] crearArrayPalabras() throws FileNotFoundException, IOException {
		String[] palabras = new String[hayPalabras()];
		try (FileReader fr = new FileReader(Constantes.FICHERO_PALABRAS_A_BUSCAR, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(fr)) {
			
			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				palabras[contador] = linea;
				contador++;
			}
		}
		
		return palabras;
	}
	
	/**
	 * Este metodo crea un array en el que contaremos las repeticiones de las palabras anteriores.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
	public int[] crearArrayRepeticion() throws FileNotFoundException, IOException{
		int[] repeticion = new int[hayPalabras()];
		
		for (int i = 0; i < hayPalabras(); i++) {
			repeticion[i] = 0;
		}
		
		return repeticion;
	}
	
	/**
	 * Este metodo cuenta en cuantas veces se repiten las palabras del array que recibe por parametro.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
	public int[] contarRepeticiones(String[] array) throws FileNotFoundException, IOException {
	    int[] repeticion = crearArrayRepeticion();
	    String[] palabras = array;
	    try (FileReader fr = new FileReader(Constantes.FICHERO_TEXTO_QUIJOTE, StandardCharsets.UTF_8);
	         BufferedReader br = new BufferedReader(fr)) {
	        String linea;
	        while ((linea = br.readLine()) != null) {

	            String[] palabrasLinea = linea.split("\\s+");
	            for (String palabra : palabrasLinea) {
	                for (int i = 0; i < palabras.length; i++) {
	                    if (palabra.equalsIgnoreCase(palabras[i])) {
	                        repeticion[i]++;
	                    }else if (palabra.toLowerCase().contains(palabras[i].toLowerCase())) {
	                        repeticion[i]++;
	                    }
	                }
	            }
	        }
	    }
	    return repeticion;
	}
}
