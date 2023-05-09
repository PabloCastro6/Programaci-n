package com.Pablo.app.Main;

import com.Pablo.app.impl.OpcionDos;
import com.Pablo.app.impl.OpcionTres;
import com.Pablo.app.impl.OpcionUno;
import com.Pablo.app.interfaces.IOpcionMenu;
import com.Pablo.menu.Menu;

public class Principal {

	public static void main(String[] args) {
		Menu m = new  Menu();
				
		m.agregarOpcion(new OpcionUno());
		m.agregarOpcion(new OpcionDos());
		m.agregarOpcion(new OpcionTres());
		
		m.mostrarMenu();
	}

}
