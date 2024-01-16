package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.AdmisionController;
import com.paula.hospital.utils.MiScanner;

import com.paula.hospital.dtos.AdmisionDTO;

public class VistaAdmision {

	public void menuGeneralAdmision() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA ADMISIONES");
			System.out.println("===============================================================");
			System.out.println("1. Buscar admisiones");
			System.out.println("2. Insertar admisión");
			System.out.println("3. Actualizar admisión ");
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
				menuBuscaAdmision();
				continue;
			}

			if (n == 2) {
				menuInsertaAdmision();
				continue;
			}

			if (n == 3) {
				menuActualizaAdmision();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaAdmision() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la admisión a buscar: ");
		String id = sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del paciente relacionado con la admisión: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación: ");
		String tipoHabitacion = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de ingreso de la admisión a buscar (YYYY-MM-DD): ");
		String fechaIngreso = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de salida de la admisión a buscar (YYYY-MM-DD): ");
		String fechaSalida = sc.nextLine();

		System.out.println("Introduzca por favor el motivo de la admisión a buscar: ");
		String motivo = sc.nextLine();

		AdmisionController ac = new AdmisionController();
		List<AdmisionDTO> listaAdmisiones = ac.buscaAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso,
				fechaSalida, motivo);

		for (AdmisionDTO admision : listaAdmisiones) {
			System.out.println(admision.getId() + " " + admision.getNombrePaciente() + " "
					+ admision.getTipoHabitacion() + " " + admision.getFechaDeIngreso() + " "
					+ admision.getFechaDeSalida() + " " + admision.getMotivo());
		}
	}

	public void menuInsertaAdmision() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la admisión (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación: ");
		String tipoHabitacion = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de ingreso (YYYY-MM-DD): ");
		String fechaIngreso = sc.nextLine();
		if(fechaIngreso.equals("")) {
			fechaIngreso = "2023-01-09";
		}

		System.out.println("Introduzca por favor la fecha de salida (YYYY-MM-DD): ");
		String fechaSalida = sc.nextLine();
		if(fechaSalida.equals("")) {
			fechaSalida = "2023-08-09";
		}

		System.out.println("Introduzca por favor el motivo de la admisión: ");
		String motivo = sc.nextLine();

		AdmisionController ac = new AdmisionController();
		int resultado = ac.insertarAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso, fechaSalida, motivo);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizaAdmision() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la admisión que quiere actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el tipo de la habitación: ");
		String tipoHabitacion = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de ingreso (YYYY-MM-DD): ");
		String fechaIngreso = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de salida (YYYY-MM-DD): ");
		String fechaSalida = sc.nextLine();

		System.out.println("Introduzca por favor el motivo de la admisión: ");
		String motivo = sc.nextLine();

		AdmisionController ac = new AdmisionController();
		int resultado = ac.actualizarAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso, fechaSalida, motivo);

		if (resultado == 1) {
			System.out.println("Se ha actualizado la admision con id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar la admision con id " + id);
		}
	}

}
