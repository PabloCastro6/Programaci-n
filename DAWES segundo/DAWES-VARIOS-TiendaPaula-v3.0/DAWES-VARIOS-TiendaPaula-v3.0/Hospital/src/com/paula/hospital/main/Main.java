package com.paula.hospital.main;

import java.sql.SQLException;


import com.paula.hospital.vistas.MenuPrincipal;

class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();

	}

}
