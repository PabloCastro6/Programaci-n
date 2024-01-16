package com.paula.IMC.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatosIMC {

    public Integer[] consultaPesoAltura(String nombre) throws IOException {
    	
    	String path = Thread.currentThread().getContextClassLoader().getResource("IMC.txt").getPath();
		File f = new File(path);
        BufferedReader lector = new BufferedReader(new FileReader(f));
        String linea;

        while ((linea = lector.readLine()) != null) {
            if (linea.contains(nombre)) {
                String[] arrayPesoAltura = linea.split("-");
                int peso = Integer.parseInt(arrayPesoAltura[1]);
                int altura = Integer.parseInt(arrayPesoAltura[2]);
                return new Integer[]{peso, altura};
            }
        }

        return null;
    }
}
