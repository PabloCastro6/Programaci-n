package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.MedicoController;
import com.paula.hospital.dtos.MedicoDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaMedicos {

	public void menuGeneralMedicos() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA MEDICOS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar medicos");
			System.out.println("2. Insertar medicos");
			System.out.println("3. Actualizar medicos ");
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
				menuBuscaMedico();
				continue;
			}

			if (n == 2) {
				menuInsertaMedico();
				continue;
			}

			if (n == 3) {
				menuActualizaMedico();
				continue;
			}

		} while (n != 5);

	}

	public void menuBuscaMedico() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del medico a buscar: ");
		String medicoId = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medico a buscar: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del medico a buscar: ");
		String apellido = sc.nextLine();

		System.out.println("Introduzca por favor la especialidad del medico a buscar: ");
		String especialidad = sc.nextLine();

		System.out.println("Introduzca por favor la licencia del medico a buscar: ");
		String licenciaMedica = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente a buscar: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente a buscar: ");
		String correo = sc.nextLine();

		MedicoController mc = new MedicoController();
		List<MedicoDTO> listaMedicos = mc.buscarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica,
				telefono, correo);

		for (MedicoDTO medico : listaMedicos) {
			System.out.println(medico.getMedicoId() + " " + medico.getNombre() + " " + medico.getApellido() + " "
					+ medico.getEspecialidad() + " " + medico.getLicenciaMedica() + " " + medico.getTelefono() + " "
					+ medico.getTelefono());

		}
	}

	public void menuInsertaMedico() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del medico (Obligatorio): ");
		int medicoId = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medico: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del medico: ");
		String apellido = sc.nextLine();

		System.out.println("Introduzca por favor la especialidad del medico: ");
		String especialidad = sc.nextLine();

		System.out.println("Introduzca por favor la licencia del medico: ");
		String licenciaMedica = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente: ");
		String correo = sc.nextLine();

		MedicoController mc = new MedicoController();

		int resultado = mc.insertarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica, telefono, correo);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizaMedico() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del medico a actualizar (Obligatorio): ");
		int medicoId = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medico: ");
		String nombre = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del medico: ");
		String apellido = sc.nextLine();

		System.out.println("Introduzca por favor la especialidad del medico: ");
		String especialidad = sc.nextLine();

		System.out.println("Introduzca por favor la licencia del medico: ");
		String licenciaMedica = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente: ");
		String correo = sc.nextLine();

		MedicoController mc = new MedicoController();

		int resultado = mc.actualizarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica, telefono, correo);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el medico con id " + medicoId + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el medico con id " + medicoId);
		}
	}
}
