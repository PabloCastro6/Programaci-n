package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.EstadoFacturacionController;
import com.paula.hospital.dtos.EstadoFacturacionDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaEstadoFacturacion {

	public void menuGeneralEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA ESTADO DE FACTURACIÓN");
			System.out.println("===========================================================");
			System.out.println("1. Buscar estado de facturación");
			System.out.println("2. Insertar estado de facturación");
			System.out.println("3. Actualizar estado de facturación");
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
				menuBuscaEstadoFacturacion();
				continue;
			}

			if (n == 2) {
				menuInsertarEstadoFacturacion();
				continue;
			}

			if (n == 3) {
				menuActualizarEstadoFacturacion();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del estado de facturación a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el estado de facturación a buscar: ");
		String estado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();
		List<EstadoFacturacionDTO> listaEstadosFacturacion = efc.buscaEstadoFacturacion(id, estado);

		for (EstadoFacturacionDTO ef : listaEstadosFacturacion) {
			System.out.println(ef.getId() + " " + ef.getEstado());
		}
	}

	public void menuInsertarEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID del estado de facturación (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de facturación: ");
		String estado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();
		int resultado = efc.insertarEstadoFacturacion(id, estado);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID del estado de facturación a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nuevo estado de facturación: ");
		String nuevoEstado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();
		int resultado = efc.actualizarEstadoFacturacion(id, nuevoEstado);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el estado con id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el estado con id " + id);
		}
	}
}
