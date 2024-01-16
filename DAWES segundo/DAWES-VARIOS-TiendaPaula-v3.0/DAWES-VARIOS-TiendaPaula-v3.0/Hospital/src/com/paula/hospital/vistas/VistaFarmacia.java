package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.FarmaciaController;
import com.paula.hospital.dtos.FarmaciaDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaFarmacia {

	public void menuGeneralFarmacia() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA FARMACIA");
			System.out.println("===========================================================");
			System.out.println("1. Buscar medicamentos en farmacia");
			System.out.println("2. Insertar medicamento en farmacia");
			System.out.println("3. Actualizar medicamento en farmacia");
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
				menuBuscaFarmacia();
				continue;
			}

			if (n == 2) {
			    menuInsertaFarmacia();
				continue;
			}

			if (n == 3) {
				menuActualizaFarmacia();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaFarmacia() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del medicamento a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento a buscar: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripción del medicamento a buscar: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible del medicamento a buscar: ");
		String cantidadDisponible = sc.nextLine();

		System.out.println("Introduzca por favor el precio del medicamento a buscar: ");
		String precio = sc.nextLine();

		FarmaciaController fc = new FarmaciaController();
		List<FarmaciaDTO> listaMedicamentos = fc.buscaFarmacia(id, nombre, descripcion, cantidadDisponible, precio);

		for (FarmaciaDTO medicamento : listaMedicamentos) {
			System.out.println(medicamento.getId() + " " + medicamento.getNombre() + " " + medicamento.getDescripcion()
					+ " " + medicamento.getCantidadDisponible() + " " + medicamento.getPrecio());
		}
	}

	public void menuInsertaFarmacia() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del medicamento (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripción del medicamento: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible del medicamento (Obligatorio): ");
		int cantidadDisponible = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el precio del medicamento (Obligatorio): ");
		double precio = sc.nextDouble();
		sc.nextLine();

		FarmaciaController fc = new FarmaciaController();
		int resultado = fc.insertarFarmacia(id, nombre, descripcion, cantidadDisponible, precio);

		if (resultado == 1) {
			System.out.println("Se ha introducido el medicamento con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el medicamento");
		}
	}

	public void menuActualizaFarmacia() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del medicamento (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripción del medicamento: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad disponible del medicamento (Obligatorio): ");
		int cantidadDisponible = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el precio del medicamento (Obligatorio): ");
		double precio = sc.nextDouble();
		sc.nextLine();

		FarmaciaController fc = new FarmaciaController();
		int resultado = fc.actualizarFarmacia(id, nombre, descripcion, cantidadDisponible, precio);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el medicamento con" + id + "con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el medicamento con" + id);
		}
	}

}
