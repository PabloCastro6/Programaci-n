package com.Pablo.app.impl;

import com.Pablo.app.interfaces.IOpcionMenu;

public class OpcionTres implements IOpcionMenu {

	@Override
	public void imprimeOpcion() {
	System.out.println("Opcion tercera lo que sea...");
		
	}

	@Override
	public void ejecutaOpcion() {
		System.out.println("Ejecutando la opcion elegida,opcion Tres....");
		
	}

}
