package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.HistorialMedicoController;
import com.paula.hospital.dtos.HistorialMedicoDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaHistorialMedico {

	public void menuGeneralHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA HISTORIAL MÉDICO");
			System.out.println("========================================================================");
			System.out.println("1. Buscar historial médico");
			System.out.println("2. Insertar registro de historial médico");
			System.out.println("3. Actualizar registro de historial médico");
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
				menuBuscaHistorialMedico();
				continue;
			}

			if (n == 2) {
				menuInsertaHistorialMedico();
				continue;
			}

			if (n == 3) {
				menuActualizaHistorialMedico();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de historial médico a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente relacionado con el historial médico: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico relacionado con el historial médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha del registro de historial médico a buscar (YYYY-MM-DD): ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el diagnóstico a buscar: ");
		String diagnostico = sc.nextLine();

		System.out.println("Introduzca por favor el tratamiento a buscar: ");
		String tratamiento = sc.nextLine();

		HistorialMedicoController hc = new HistorialMedicoController();
		List<HistorialMedicoDTO> listaHistorialMedico = hc.buscaHistorialMedico(id, nombrePaciente, nombreMedico, fecha,
				diagnostico, tratamiento);

		for (HistorialMedicoDTO historialMedico : listaHistorialMedico) {
			System.out.println(historialMedico.getId() + " " + historialMedico.getNombrePaciente() + " "
					+ historialMedico.getNombreMedico() + " " + historialMedico.getFecha() + " "
					+ historialMedico.getDiagnostico() + " " + historialMedico.getTratamiento());
		}
	}

	public void menuInsertaHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de historial médico (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha del registro de historial médico (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		if(fecha.equals("")) {
			fecha = "2004-08-09";
		}
		System.out.println("Introduzca por favor el diagnóstico: ");
		String diagnostico = sc.nextLine();

		System.out.println("Introduzca por favor el tratamiento: ");
		String tratamiento = sc.nextLine();

		HistorialMedicoController hc = new HistorialMedicoController();
		int resultado = hc.insertarHistorialMedico(id, nombrePaciente, nombreMedico, fecha, diagnostico, tratamiento);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	public void menuActualizaHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de historial médico a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor la fecha del registro de historial médico (YYYY-MM-DD): ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el diagnóstico: ");
		String diagnostico = sc.nextLine();

		System.out.println("Introduzca por favor el tratamiento: ");
		String tratamiento = sc.nextLine();

		HistorialMedicoController hc = new HistorialMedicoController();
		int resultado = hc.actualizarHistorialMedico(id, nombrePaciente, nombreMedico, fecha, diagnostico, tratamiento);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el historial con " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar  el historial con " + id);
		}
	}

}
