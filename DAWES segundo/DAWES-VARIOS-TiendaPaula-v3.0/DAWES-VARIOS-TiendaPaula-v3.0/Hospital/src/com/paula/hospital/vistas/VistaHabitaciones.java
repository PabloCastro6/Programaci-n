package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.utils.MiScanner;
import com.paula.hospital.controllers.HabitacionController;
import com.paula.hospital.dtos.HabitacionDTO;

public class VistaHabitaciones {

	public void menuGeneralHabitaciones() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA HABITACIONES");
			System.out.println("===========================================================");
			System.out.println("1. Buscar habitaciones");
			System.out.println("2. Insertar habitación");
			System.out.println("3. Actualizar habitación");
			System.out.println("4. Volver al menú principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n == 4) {
				return;
			}

			if (n > 4 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}

			if (n == 1) {
				menuBuscaHabitacion();
				continue;
			}

			if (n == 2) {
				menuInsertaHabitacion();
				continue;
			}

			if (n == 3) {
				menuActualizarHabitacion();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaHabitacion() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la habitación a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación a buscar: ");
		String tipo = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la habitación a buscar: ");
		String estado = sc.nextLine();

		System.out.println("Introduzca por favor el costo por día de la habitación a buscar: ");
		String costoPorDia = sc.nextLine();

		HabitacionController hc = new HabitacionController();
		List<HabitacionDTO> listaHabitaciones = hc.buscaHabitacion(id, tipo, estado, costoPorDia);

		for (HabitacionDTO habitacion : listaHabitaciones) {
			System.out.println(habitacion.getId() + " " + habitacion.getTipo() + " " + habitacion.getEstado() + " "
					+ habitacion.getCostoPorDia());
		}
	}

	public void menuInsertaHabitacion() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la habitación (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación: ");
		String tipo = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la habitación: ");
		String estado = sc.nextLine();

		System.out.println("Introduzca por favor el costo por día de la habitación (Obligatorio): ");
		double costoPorDia = sc.nextDouble();
		sc.nextLine();

		HabitacionController hc = new HabitacionController();
		int resultado = hc.insertarHabitacion(id, tipo, estado, costoPorDia);

		if (resultado == 1) {
			System.out.println("Se ha introducido la habitación con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir la habitación");
		}
	}

	public void menuActualizarHabitacion() throws SQLException, ClassNotFoundException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de la habitación a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación: ");
		String tipo = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la habitación: ");
		String estado = sc.nextLine();

		System.out.println("Introduzca por favor el costo por día de la habitación (Obligatorio): ");
		double costoPorDia = sc.nextDouble();
		sc.nextLine();

		HabitacionController hc = new HabitacionController();
		int resultado = hc.actualizarHabitacion(id, tipo, estado, costoPorDia);

		if (resultado == 1) {
			System.out.println("Se ha actualizado la habitación con " + id  + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar la habitación con id " + id);
		}
	}

}
