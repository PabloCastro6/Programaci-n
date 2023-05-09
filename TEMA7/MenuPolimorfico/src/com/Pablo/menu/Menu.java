package com.Pablo.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Pablo.app.interfaces.IOpcionMenu;

public class Menu {
	
	private List<IOpcionMenu> opciones = new ArrayList <>();
	
	public void agregarOpcion(IOpcionMenu opcion) {
		opciones.add(opcion);
	}
	
	public void mostrarMenu () {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Por favor elija una opcion");
			for (int i = 0; i< opciones.size(); i++) {
				// System.out.print(i+1 + " - ");
				opciones.get(i).imprimeOpcion();
			}
			Integer opcionElegida = sc.nextInt();
			sc.nextLine();
			
			
			opciones.get(opcionElegida -1).ejecutaOpcion();
		}
	}

}
