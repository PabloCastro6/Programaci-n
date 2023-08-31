import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Principal {
	List<Propietario> listaPropietario = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		new Principal().dale();

	}

	public void dale() throws IOException {
		File archivoPersonas = new File("C:\\Users\\Usuario\\Documents\\listaPropietarios.txt.txt");
		File archivoFincas = new File("C:\\Users\\Usuario\\Documents\\listaFincas.txt.txt");
		leerPersonas(archivoPersonas);
		leerFincas(archivoFincas);
		Scanner sc = new Scanner(System.in);
		System.out.println("Como quiere ordenar la lista de propieatarios? Propiedades/Edad");
		String eleccion = sc.next();
		if (eleccion.equalsIgnoreCase("Propiedades")) {
			Collections.sort(listaPropietario, new OrdenacionFincas());

			
		}else if (eleccion.equalsIgnoreCase("Edad")) {
			Collections.sort(listaPropietario, new OrdenacionEdad());
			
		}

		System.out.println(listaPropietario);

	}

	private void leerPersonas(File archivoPersonas) throws IOException {
		BufferedReader lector;       
		lector = new BufferedReader(new InputStreamReader(new FileInputStream(archivoPersonas), StandardCharsets.UTF_8));;
		String linea;
		while ((linea = lector.readLine()) != null) {
			anadirPersona(linea);

		}
		lector.close();

	}

	private void anadirPersona(String linea) {
		String[] persona = linea.split(";");

		Propietario nuevoPropietario = new Propietario(persona[0], Integer.parseInt(persona[1]), persona[2]);
		listaPropietario.add(nuevoPropietario);

	}

	private void leerFincas(File archivoFincas) throws IOException {
		BufferedReader lector;
		lector = lector = new BufferedReader(new InputStreamReader(new FileInputStream(archivoFincas), StandardCharsets.UTF_8));;
		String linea;
		while ((linea = lector.readLine()) != null) {
			anadirFinca(linea);

		}
		lector.close();

	}

	private void anadirFinca(String linea) {
		String[] finca = linea.split(";");

		Finca nuevaFinca = new Finca(finca[0], Integer.parseInt(finca[1]));

		for (Propietario propietario : listaPropietario) {
			if (propietario.getNombre().equals(finca[2])) {
				propietario.getFincas().add(nuevaFinca);

			}

		}

	}

}


