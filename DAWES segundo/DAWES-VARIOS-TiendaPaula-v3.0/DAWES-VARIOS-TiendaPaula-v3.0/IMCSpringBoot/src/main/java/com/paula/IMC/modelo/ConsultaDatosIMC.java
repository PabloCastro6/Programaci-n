package com.paula.IMC.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class ConsultaDatosIMC implements IConsultaDatosIMC {

	
    public Integer[] consultaPesoAltura(String nombre) throws IOException {
    	
    	File f = ResourceUtils.getFile("classpath:IMC.txt");
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
