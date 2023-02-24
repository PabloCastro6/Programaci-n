package com.Pablo.dto;

import com.Pablo.Excepciones.edadIncorrectaExcepcion;

public class Persona {
	
	private Integer edad;

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) throws edadIncorrectaExcepcion {
		if(edad<0) {
			throw new edadIncorrectaExcepcion("la edad no puede ser negativa");
				
			
		}
		
		this.edad = edad;
	}
	

}
