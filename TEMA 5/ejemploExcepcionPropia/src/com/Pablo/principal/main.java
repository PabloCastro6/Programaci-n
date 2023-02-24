package com.Pablo.principal;

import java.util.Scanner;

import com.Pablo.Excepciones.edadIncorrectaExcepcion;
import com.Pablo.dto.Persona;

public class main {
public static void main (String[] args)  {
	Scanner sc = new Scanner(System.in);
	boolean datosOK = false;
			System.out.println("Porfavor, digame el numero de" + "la persona");
	
	
	Persona p = new Persona();
	int edad = sc.nextInt();
	sc.nextLine();
	
	
	try {
		p.setEdad(edad);
		datosOK= true;
		
	}	catch (edadIncorrectaExcepcion e) {
		System.out.println ("No se puede meter edades negativas, melon");
	}
	 while (!datosOK);

}
}
