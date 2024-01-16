package com.paula.IMC.negocio;

import java.io.IOException;

import com.paula.IMC.modelo.ConsultaDatosIMC;

public class CalculaIMC {
    
    public static double calculaIMC(String nombre) throws IOException {
        
        ConsultaDatosIMC cd = new ConsultaDatosIMC();
        
        Integer[] datos = cd.consultaPesoAltura(nombre);

        if (datos != null && datos.length >= 2) {
            
            double peso = datos[0];
            double altura = datos[1];

            double alturaEnMetros = altura / 100.0;
            return peso / (alturaEnMetros * alturaEnMetros);
        } else {
            
            return -1; 
        }
    }
}
