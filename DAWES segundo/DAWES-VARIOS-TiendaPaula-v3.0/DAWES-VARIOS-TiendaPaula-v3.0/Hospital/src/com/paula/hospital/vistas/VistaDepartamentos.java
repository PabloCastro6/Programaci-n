package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.utils.MiScanner;
import com.paula.hospital.controllers.DepartamentoController;
import com.paula.hospital.dtos.DepartamentoDTO;

public class VistaDepartamentos {

	public void menuGeneralDepartamentos() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA DEPARTAMENTOS");
			System.out.println("===============================================================");
			System.out.println("1. Buscar departamento");
			System.out.println("2. Insertar departamento");
			System.out.println("3. Actualizar departamento");
			System.out.println("4. Borrar departamento");
			System.out.println("5. Volver al menú principal");
			System.out.println("===============================================================");

			n = Integer.parseInt(sc.nextLine());

			if (n == 5) {
				return;
			}

			if (n > 5 || n < 1) {
				System.out.print("Elección inválida, inténtalo otra vez...");
				continue;
			}

			if (n == 1) {
				menuBuscaDepartamento();
				continue;
			}

			if (n == 2) {
				menuInsertaDepartamento();
				continue;
			}

			if (n == 3) {
				menuActualizarDepartamento();
				continue;
			}

			if (n == 4) {
				menuBorrarDepartamento();
				continue;
			}

		} while (n != 5);
	}

	public void menuBuscaDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el ID del departamento a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del departamento a buscar: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripción del departamento a buscar: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el estado del departamento (1 para activo, 0 para inactivo): ");
		String activo = sc.nextLine();

		DepartamentoController cd = new DepartamentoController();
		List<DepartamentoDTO> listaDepartamentos = cd.buscaDepartamento(id, nombre, descripcion, activo);

		for (DepartamentoDTO departamento : listaDepartamentos) {
			System.out.println("ID: " + departamento.getId());
			System.out.println("Nombre: " + departamento.getNombre());
			System.out.println("Descripción: " + departamento.getDescripcion());
			System.out.println("Activo: " + departamento.getActivo());
		}
	}

	public void menuInsertaDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID del departamento (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del departamento: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la descripción del departamento: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el estado del departamento (1 para activo, 0 para inactivo)(Obligatorio): ");
		int activo = sc.nextInt();
		sc.nextLine();

		DepartamentoController controladorDepartamentos = new DepartamentoController();
		int resultado = controladorDepartamentos.insertarDepartamento(id, nombre, descripcion, activo);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID del departamento a actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nuevo nombre del departamento: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor la nueva descripción del departamento: ");
		String descripcion = sc.nextLine();

		System.out.println("Introduzca por favor el nuevo estado del departamento (1 para activo, 0 para inactivo) (Obligatorio): ");
		int activo = sc.nextInt();
		sc.nextLine();
		DepartamentoController cd = new DepartamentoController();
		int resultado = cd.actualizarDepartamento(id, nombre, descripcion, activo);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el departamento con el id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el departamento con el id " + id);
		}
	}

	public void menuBorrarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID del departamento a borrar: ");
		int id = sc.nextInt();
		sc.nextLine();

		DepartamentoController cd = new DepartamentoController();
		int resultado = cd.borrarDepartamento(id);

		if (resultado == 1) {
			System.out.println("Se ha borrado el departamento con el id " + id + " con éxito");
		} else {
			System.out.println("Se ha producido un error al borrar el departamento con el id " + id);
		}
	}

}
