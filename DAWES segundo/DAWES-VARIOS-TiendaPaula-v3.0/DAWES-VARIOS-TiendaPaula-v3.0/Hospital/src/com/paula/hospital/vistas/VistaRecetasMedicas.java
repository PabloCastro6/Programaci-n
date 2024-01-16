package com.paula.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.paula.hospital.controllers.RecetasMedicasController;
import com.paula.hospital.dtos.RecetaMedicaDTO;
import com.paula.hospital.utils.MiScanner;

public class VistaRecetasMedicas {

	public void menuGeneralRecetasMedicas() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;

		do {
			System.out.println("Introduzca la operación que desee realizar: ");
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA RECETAS MÉDICAS");
			System.out.println("===========================================================");
			System.out.println("1. Buscar recetas médicas");
			System.out.println("2. Insertar receta médica");
			System.out.println("3. Actualizar receta médica");
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
				menuBuscaRecetaMedica();
				continue;
			}

			if (n == 2) {
				menuInsertaRecetaMedica();
				continue;
			}

			if (n == 3) {
				menuActualizaRecetaMedica();
				continue;
			}

		} while (n != 5);

	}

	public void menuBuscaRecetaMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de la receta médica a buscar: ");
		String id = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente relacionado con la receta médica: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico relacionado con la receta médica: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento relacionado con la receta médica: ");
		String nombreMedicamento = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la receta médica a buscar (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		
		System.out.println("Introduzca por favor la cantidad prescrita de la receta médica a buscar: ");
		String cantidadPrescrita = sc.nextLine();

		RecetasMedicasController rmc = new RecetasMedicasController();
		List<RecetaMedicaDTO> listaRecetasMedicas = rmc.buscaRecetaMedica(id, nombrePaciente, nombreMedico,
				nombreMedicamento, fecha, cantidadPrescrita);

		for (RecetaMedicaDTO recetaMedica : listaRecetasMedicas) {
			System.out.println(recetaMedica.getId() + " " + recetaMedica.getNombrePaciente() + " "
					+ recetaMedica.getNombreMedico() + " " + recetaMedica.getNombreMedicamento() + " "
					+ recetaMedica.getFecha() + " " + recetaMedica.getCantidadPrescrita());
		}
	}

	public void menuInsertaRecetaMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de la receta médica (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombreMedicamento = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la receta médica (YYYY-MM-DD): ");
		String fecha = sc.nextLine();
		if(fecha.equals("")) {
			fecha = "2023-07-09";
		}
		System.out.println("Introduzca por favor la cantidad prescrita (Obligatorio): ");
		int cantidadPrescrita = sc.nextInt();
		sc.nextLine();

		RecetasMedicasController rmc = new RecetasMedicasController();
		int resultado = rmc.insertarRecetaMedica(id, nombrePaciente, nombreMedico, nombreMedicamento, fecha,
				cantidadPrescrita);

		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}

	public void menuActualizaRecetaMedica() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el ID de la receta médica que quiere actualizar (Obligatorio): ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el nombre del paciente: ");
		String nombrePaciente = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del médico: ");
		String nombreMedico = sc.nextLine();

		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombreMedicamento = sc.nextLine();

		System.out.println("Introduzca por favor la fecha de la receta médica (YYYY-MM-DD): ");
		String fecha = sc.nextLine();

		System.out.println("Introduzca por favor la cantidad prescrita (Obligatorio): ");
		int cantidadPrescrita = sc.nextInt();
		sc.nextLine();

		RecetasMedicasController rmc = new RecetasMedicasController();
		int resultado = rmc.actualizarRecetaMedica(id, nombrePaciente, nombreMedico, nombreMedicamento, fecha,
				cantidadPrescrita);
		
		if (resultado == 1) {
			System.out.println("Se ha actualizado la receta con" + id + "con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar la receta con" + id);
		}
	}

}
