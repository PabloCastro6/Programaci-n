package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import com.paula.hospital.controllers.EstadoCitasController;
import com.paula.hospital.dtos.EstadoCitaDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaEstadoCitas {

	public void menuGeneralEstadoCitas() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA ESTADO DE CITAS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar el estado de la cita");
			System.out.println("2. Insertar el estado de la cita");
			System.out.println("3. Actualizar el estado de la cita ");
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
				menuBuscaEstadoCita();
				continue;
			}

			if (n == 2) {
				menuInsertarEstadoCita();
				continue;
			}

			if (n == 3) {
				menuActualizarEstadoCita();
				continue;
			}

		} while (n != 5);

	}

	public void menuBuscaEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id de la cita: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();

		EstadoCitasController cec = new EstadoCitasController();
		List<EstadoCitaDTO> listaEstadosCita = cec.buscaCita(id, estado);

		for (EstadoCitaDTO estadoCita : listaEstadosCita) {
			System.out.println(estadoCita.getId() + " " + estadoCita.getEstado());

		}

	}
	
	public void menuInsertarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id de la cita (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();
		
		EstadoCitasController cec = new EstadoCitasController();
		int resultado = cec.insertarEstadoCitas(id, estado);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	public void menuActualizarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la cita a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita: ");
		String estado = sc.nextLine();

		EstadoCitasController cec = new EstadoCitasController();
		int resultado = cec.actualizarEstadoCitas(id, estado);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el estado con id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el estado con id " + id);
		}
	}

}
