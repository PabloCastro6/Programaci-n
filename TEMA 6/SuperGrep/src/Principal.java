import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al programa SUPERGREP");
		
		System.out.println("Por favor, introduzca la ruta del directorio que desea buscar");
		String directorio = scanner.nextLine();

		System.out.println("Por favor, introduzca la palabra");
		String palabra = scanner.nextLine();

		System.out.println("Por favor, introduzca la fecha");
		String fecha = scanner.nextLine();
		buscaArchivos(directorio, palabra, fecha);

	}

	public static void buscaArchivos(String directorio, String palabra, String fecha) {

		File raiz = new File(directorio);
		File[] arrayFiles = raiz.listFiles();

		// 2. Recorrer este array
		for (File f : arrayFiles) {
			if (f.isFile()) {
				System.out.println("Esto es un fichero y se llama: " + f.getName());
				if (esTexto(f)) {
					if (estaPalabra(f,palabra));
				}
				//comprobar si la fecha introducida es menor que la fecha del fichero y comprobar si el fichero es de texto
				//Si se dan las dos condiciones anteriores hay que buscar si la palabra está en el fichero 
				//Si la palabra está en el fichero --> copiar el fichero al dir destino
			} else {
				System.out.println("Esto es un directorio: " + f.getAbsolutePath() + "Vamos a visitarlo...");
				buscaArchivos(f.getAbsolutePath(), palabra, fecha);
			}
		}

	}

	public boolean esTexto(File f) {
		String nombreDeFichero = f.getName();
		if (nombreDeFichero.endsWith(".txt")) {
			return true;

		} else
			return false;
	}

	public boolean contarPalabra(File f, String palabra) throws IOException {
		try (FileReader fr = new FileReader(f, StandardCharsets.UTF_8); BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabrasPorLinea = linea.split("");
				for (String p : palabrasPorLinea) {
					if (p.equalsIgnoreCase(palabra)) {

					}
				}
			}
		}
		return false;

	}

	public boolean estaLogCreado() {
		// Hacedemos a la carpeta de Log
		// Revisar todos los archivos de la carpeta de Log
		// Hay que crear un String con este formato superGrep_300321.log
		String nombreArchivo = "superGrep_" + String.valueOf(fechaDeHoy()) + ".log";
		File logFolder = new File("log");
		File[] logFiles = logFolder.listFiles();
		if (logFiles != null) {
			for (File logFile : logFiles) {
				if (logFile.getName().equals(nombreArchivo)) {
					return true;
				}
			}
		}
		return false;

	}

	public int fechaDeHoy() {
		int año = Calendar.YEAR;
		int mes = Calendar.MONTH + 1;
		int dia = Calendar.DAY_OF_MONTH;
		int year = año % 100;

		String fechaDeHoy = String.valueOf(dia) + String.valueOf(mes) + String.valueOf(año);
		return Integer.parseInt(fechaDeHoy);
	}

}
