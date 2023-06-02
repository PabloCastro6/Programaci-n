import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Scanner;

public class Metodos {
	
	public void dale() throws IOException {
		File archivoPersonas = new File("C:\\Users\\daw2223\\Downloads\\alumnos.txt");
		File archivoAsignaturas= new File("C:\\Users\\daw2223\\Downloads\\asignaturas.txt");
		leerAlumnos(archivoPersonas);
		leerAsignaturas(archivoAsignaturas);
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		String eleccion = sc.next();
		if (eleccion.equalsIgnoreCase("Asignaturas")) {
			Collections.sort(ArchivoAsignaturas, new OrdenacionAsignaturas());

			
		}else if (eleccion.equalsIgnoreCase("Alumnos")) {
			Collections.sort(listaAlumnos, new OrdenacionAlumnos());
			
		}

		System.out.println(listaAsignaturas);

	}
		
		
		private void leerAlumnos(File archivoPersonas) throws IOException {
			BufferedReader lector;
			lector = new BufferedReader(new FileReader(archivoPersonas, StandardCharsets.UTF_8));
			String linea;
			while ((linea = lector.readLine()) != null) {
				anadirAlumnos(linea);

			}
			lector.close();

		
	}
		private void anadirAlumnos(String linea) {
			String[] persona = linea.split(";");

			Alumno nuevoPropietario = new Alumno(persona[0], Integer.parseInt(persona[1]));
			ListaAlumno.add(nuevoPropietario);

		}
		
		private void anadirAsignatura(String linea) {
			String[] persona = linea.split(";");

			Asignatura nuevoPropietario = new Asignatura(persona[0], Integer.parseInt(persona[1]), persona[2]);
			listaAsignaturas.add(nuevaAsignatura);

		}
		
		
		private void leerAsignaturas(File archivoFincas) throws IOException {
			BufferedReader lector;
			lector = new BufferedReader(new FileReader(archivoFincas, StandardCharsets.UTF_8));
			String linea;
			while ((linea = lector.readLine()) != null) {
				anadirAsignatura(linea);

			}
			lector.close();

		}
	}

	
	

