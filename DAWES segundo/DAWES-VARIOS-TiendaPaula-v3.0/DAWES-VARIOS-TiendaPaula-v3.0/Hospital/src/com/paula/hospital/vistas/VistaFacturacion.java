package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.FacturacionController;
import com.paula.hospital.dtos.FacturacionDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaFacturacion {

	public void menuGeneralFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA FACTURACIÓN");
			System.out.println("========================================================================");
			System.out.println("1. Buscar registros de facturación");
			System.out.println("2. Insertar registro de facturación");
			System.out.println("3. Actualizar registro de facturación");
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
				 menuBuscaFacturacion();
				continue;
			}

			if (n == 2) {
				menuInsertaFacturacion();
				continue;
			}

			if (n == 3) {
				menuActualizaFacturacion();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de facturación a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente relacionado con la facturación: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la facturación a buscar (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor el monto a buscar: ");
		String monto = sc.nextLine();

		System.out.println("Introduzca por favor el estado de la facturación a buscar: ");
		String estado = sc.nextLine();

		FacturacionController fc = new FacturacionController();
		List<FacturacionDTO> listaFacturacion = fc.buscaFacturacion(id, nombrePaciente, fecha, monto, estado);

		for (FacturacionDTO facturacion : listaFacturacion) {
			System.out.println(facturacion.getId() + " " + facturacion.getNombrePaciente() + " "
					+ facturacion.getFecha() + " " + facturacion.getMonto() + " " + facturacion.getEstado());
		}
	}

	public void menuInsertaFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de facturación (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la facturación (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		if(fecha.equals("")) {
			fecha = "2004-08-09";
		}
		System.out.println("Introduzca por favor el monto (Obligatorio): ");
		double monto = sc.nextDouble();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la facturación: ");
		String estadoFacturacion = sc.nextLine();

		FacturacionController fc = new FacturacionController();
		int resultado = fc.insertarFacturacion(id, nombrePaciente, fecha, monto, estadoFacturacion);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizaFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del registro de facturación que quiere actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la facturación (YYYY-MM-DD): ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor el monto (Obligatorio): ");
		double monto = sc.nextDouble();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la facturación: ");
		String estadoFacturacion = sc.nextLine();

		FacturacionController fc = new FacturacionController();
		int resultado = fc.actualizarFacturacion(id, nombrePaciente, fecha, monto, estadoFacturacion);

		if (resultado == 1) {
			System.out.println("Se ha actualizado la facturacion con id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar la facturacion con id " + id);
		}
	}
}
