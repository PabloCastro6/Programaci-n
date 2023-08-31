import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	List<Propietario> listaPropietario = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		new Principal().dale();
	}
	
	public void dale() throws IOException {
		File archivoPersonas = new File ("C:\\Users\\Usuario\\Downloads\\listaPropietarios.txt");
		File archivoFincas = new File ("C:\\Users\\Usuario\\Downloads\\listaFincas.txt");
		leerPersonas(archivoPersonas);
		leerFincas(archivoFincas);
		Scanner sc = new Scanner(System.in);
		System.out.println("Como quiere ordenar la lista de propietarios? Propiedades/edad");
		String eleccion = sc.next();
		if (eleccion.equalsIgnoreCase("Propiedades")) {
			Collections.sort(listaPropietario, new OrdenacionFincas());
			
		} else if (eleccion.equalsIgnoreCase("Edad")) {
			Collections.sort(listaPropietario, new OrdenacionEdad());
		}
		
		for(Propietario propietario : listaPropietario) {  // recorrer listas 
			System.out.println(propietario);
		}
		
		sc.close(); 
		
	}
	
	private void leerPersonas(File archivoPersonas) throws IOException {
		BufferedReader lector;
		lector = new BufferedReader(new FileReader(archivoPersonas));
		String linea;
		while ((linea = lector.readLine()) != null) { // recorrer linea a linea 
			anadirPersona(linea);
		}
		
		lector.close();
	}
	
	private void anadirPersona (String linea) {
		String[] persona = linea.split(";");
		
		Propietario nuevoPropietario = new Propietario (persona[0], Integer.parseInt(persona[1]), persona[2]);
		listaPropietario.add(nuevoPropietario);
	}
	
	private void leerFincas (File archivoFincas) throws IOException {
		BufferedReader lector;
		FileReader leer = new FileReader(archivoFincas);
		lector = new BufferedReader (leer);
		String linea;
		while ((linea = lector.readLine()) != null) {
			anadirFinca(linea);
		}
		lector.close(); // cerrar el lector 
		leer.close();
	}
	
	private void anadirFinca(String linea) {
		String[] finca = linea.split(";");
		
		Finca nuevaFinca = new Finca(finca[0], Integer.parseInt(finca[1]));
		
		for(Propietario propietario : listaPropietario) {
			if(propietario.getNombre().equals(finca[2])) {
				propietario.getFincas().add(nuevaFinca);
			}
		}
	}
}
