package com.paula.IMC.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.IMC.modelo.IConsultaDatosIMC;

@Component
public class CalculaIMC implements ICalculaIMC{
    
	@Autowired
	IConsultaDatosIMC consultaIMC;
    public double calculaIMC(String nombre) throws IOException {
        
        //ConsultaDatosIMC cd = new ConsultaDatosIMC();
        
        Integer[] datos = consultaIMC.consultaPesoAltura(nombre);

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
