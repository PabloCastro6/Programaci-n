package com.Pablo.app.main;

import java.util.Scanner;

import com.Pablo.app.dto.Persona;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame el número de personas que tiene el programa");
        int numPersonas = sc.nextInt();
        sc.nextLine();
        Persona[] personas = new Persona [numPersonas];
        for ( int i=0; i<numPersonas; i++) {
		System.out.println("Digame el DNI de la persona" +(i+1));
		String dni = sc.nextLine();
		System.out.println("Digame el nombre de la persona" + (i+1));
		String nombre = sc.nextLine();
		System.out.println("Digame el apellido de la persona" +(i+1));
		String ap = sc.nextLine();
		
		Persona p = new Persona(dni,nombre,ap);
		personas[i] = p;
		
	}
        //Recorremos el array
//Forma tradicional
        
        for (int i = 0; i < personas.length; i++) {
        	System.out.println("El nombre de la persona" +(i+1)+ " es " +personas[i].getNombre());
        	System.out.println("El DNI de la persona" +(i+1)+ " es " +personas[i].getDni());
        	System.out.println("El apellido de la persona" +(i+1)+ " es " +personas[i].getApellido());
        	System.out.println("*********************************************************");
        }
        for (Persona x: personas) {
        	System.out.println(x.getDni());
        	System.out.println(x.getNombre());
        	System.out.println(x.getApellido());
        }
}
}
