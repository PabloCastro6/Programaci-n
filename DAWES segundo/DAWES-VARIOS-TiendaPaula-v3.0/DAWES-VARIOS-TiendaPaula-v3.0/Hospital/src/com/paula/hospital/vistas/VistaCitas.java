package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.CitasController;
import com.paula.hospital.utils.MiScanner;
import com.paula.hospital.dtos.CitaDTO;

public class VistaCitas {

	public void menuGeneralCitas() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA CITAS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar citas");
			System.out.println("2. Insertar cita");
			System.out.println("3. Actualizar cita ");
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
				menuBuscaCita();
				continue;
			}

			if (n == 2) {
				menuInsertaCita();
				continue;
			}

			if (n == 3) {
				menuActualizarCita();
				continue;
			}

		} while (n != 5);

	}

	public void menuBuscaCita() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la cita a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente relacionado con la cita: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico relacionado con la cita: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la cita a buscar: ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor la hora de la cita a buscar: ");
		String hora = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita a buscar: ");
		String estado = sc.nextLine();

		CitasController cc = new CitasController();
		List<CitaDTO> listaCitas = cc.buscaCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);

		for (CitaDTO cita : listaCitas) {
			System.out.println(cita.getId() + " " + cita.getNombrePaciente() + " " + cita.getNombreMedico() + " "
					+ cita.getFecha() + " " + cita.getHora() + " " + cita.getEstadoCita());
		}
	}

	public void menuInsertaCita() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID de la cita (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la cita (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		if(fecha.equals("")) {
			fecha = "2004-08-09";
		}
		System.out.println("Introduzca por favor la hora de la cita (HH:MM:SS): ");
		String hora = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita a buscar: ");
		String estado = sc.nextLine();

		CitasController cc = new CitasController();
		int resultado = cc.insertarCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarCita() throws SQLException, ClassNotFoundException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de la cita a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la cita para actualizar (YYYY-MM-DD): ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor la hora de la cita para actualizar (HH:MM:SS): ");
		String hora = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();

		CitasController cc = new CitasController();
		int resultado = cc.actualizarCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);

		if (resultado == 1) {
			System.out.println("Se ha actualizado la receta con id " + id +  " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar la receta con id " + id);
		}
	}
}
