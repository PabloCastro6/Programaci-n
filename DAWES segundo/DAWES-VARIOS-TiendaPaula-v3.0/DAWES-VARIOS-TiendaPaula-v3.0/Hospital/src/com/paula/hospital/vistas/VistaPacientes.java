package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.PacienteController;
import com.paula.hospital.dtos.PacienteDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaPacientes {
	public void menuGeneralPacientes() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("Introduzca la operación que desee realizar: ");

			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA PACIENTES");
			System.out.println("===========================================================");
			System.out.println("1. Buscar paciente");
			System.out.println("2. Insertar paciente");
			System.out.println("3. Actualizar paciente ");
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
				menuBuscaPaciente();
				continue;
			}

			if (n == 2) {
				menuInsertaPaciente();
				continue;
			}

			if (n == 3) {
				menuActualizarPacientes();
				continue;
			}

		} while (n != 5);

	}

	public void menuBuscaPaciente() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del paciente a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente a buscar: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del paciente a buscar: ");
		String apellidoPaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de nacimiento del paciente a buscar (YYYY-MM-DD): ");
		String fechaNacimiento = sc.nextLine();

		System.out.println("Introduzca por favor el dni del paciente a buscar: ");
		String dni = sc.nextLine();

		System.out.println("Introduzca por favor la direccion del paciente a buscar: ");
		String direccion = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente a buscar: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente a buscar: ");
		String correo = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion de la alergia del paciente a buscar: ");
		String descripcionAlergia = sc.nextLine();

		System.out.println("Introduzca por favor la historia medica del paciente a buscar: ");
		String historiaMedica = sc.nextLine();

		PacienteController cp = new PacienteController();
		List<PacienteDTO> listaPaciente = cp.buscaPaciente(id, nombrePaciente, apellidoPaciente, fechaNacimiento, dni,
				direccion, telefono, correo, descripcionAlergia, historiaMedica);

		for (PacienteDTO paciente : listaPaciente) {
			System.out.println(paciente.getId() + " " + paciente.getNombre() + " " + paciente.getApellido() + " "
					+ paciente.getFechaDeNacimiento() + " " + paciente.getDni() + " " + paciente.getNombre() + " "
					+ paciente.getDireccion() + " " + paciente.getTelefono() + " " + paciente.getCorreo() + " "
					+ paciente.getDescripcionAlergia() + " " + paciente.getHistoriaMedica());

		}

	}

	public void menuInsertaPaciente() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id del paciente: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del paciente: ");
		String apellidoPaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de nacimiento del paciente (YYYY-MM-DD): ");
		String fechaNacimiento = sc.nextLine();
		if(fechaNacimiento.equals("")) {
			fechaNacimiento = "2004-08-09";
		}

		System.out.println("Introduzca por favor el dni del paciente: ");
		String dni = sc.nextLine();

		System.out.println("Introduzca por favor la direccion del paciente: ");
		String direccion = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente: ");
		String correo = sc.nextLine();

		System.out.println("Introduzca por favor la descripcion de la alergia del paciente: ");
		String descripcionAlergia = sc.nextLine();

		System.out.println("Introduzca por favor la historia medica del paciente: ");
		String historiaMedica = sc.nextLine();

		PacienteController pc = new PacienteController();
		int resultado = pc.insertarPacientes(id, nombrePaciente, apellidoPaciente, fechaNacimiento, dni, direccion,
				telefono, correo, descripcionAlergia, historiaMedica);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizarPacientes() throws SQLException, ClassNotFoundException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del paciente a actualizar: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el apellido del paciente: ");
		String apellidoPaciente = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de nacimiento del paciente (YYYY-MM-DD): ");
		String fechaNacimiento = sc.nextLine();

		System.out.println("Introduzca por favor el dni del paciente: ");
		String dni = sc.nextLine();

		System.out.println("Introduzca por favor la direccion del paciente: ");
		String direccion = sc.nextLine();

		System.out.println("Introduzca por favor el telefono del paciente: ");
		String telefono = sc.nextLine();

		System.out.println("Introduzca por favor el correo del paciente: ");
		String correo = sc.nextLine();

		System.out.println("Introduzca por favor la descripción de la alergia del paciente: ");
		String descripcionAlergia = sc.nextLine();

		System.out.println("Introduzca por favor la historia medica del paciente: ");
		String historiaMedica = sc.nextLine();

		PacienteController pc = new PacienteController();
		int resultado = pc.actualizarPacientes(id, nombrePaciente, apellidoPaciente, fechaNacimiento, dni, direccion,
				telefono, correo, descripcionAlergia, historiaMedica);

		if (resultado == 1) {
			System.out.println("Se ha actualizado el registro con la id " + id + " con  éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el registro con la id" + id);
		}
	}

}
