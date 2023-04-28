
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Metodos {
	
	public String escribirFecha () {
		
		//Devolver la fecha en formato string
		return null;
	}

	public void buscaArchivos(String directorio, String palabra, String fecha) throws IOException {
		String date = new SimpleDateFormat("ddMMyy").format(new Date());
		// superGrep_280423.log
		FileWriter fw = new FileWriter(Constantes.DIRETORIO_LOG + "superGrep" + date + ".log", true);

		File raiz = new File(directorio);
		File[] arrayFiles = raiz.listFiles();
		boolean palabraEncontrada = false;
		String nombreArchivo = "";
		// 2. Recorrer este array
		for (File f : arrayFiles) {
			if (esTexto(f)) {
				fw.write(escribirFecha()+ "Fecha-finalizando archivo: " + f.getName() + "\n");
				nombreArchivo = f.getName();

				if (encontrarPalabra(f, palabra)) {
					fw.write("Palabra " + palabra + " ENCONTRADA !!! \n");
					fw.write("Copiando fichero: " + f.getName() + " a directorio " + Constantes.DIRECTORIO_DESTINO
							+ "\n");
					String destino = Constantes.DIRECTORIO_DESTINO + f.getName();
					//Covertirlo a Path 
					Files.copy(f.toPath(), null, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Palabra " + palabra + " ENCONTRADA !!!");
					// Copiar fichero
					fw.write("Copiando fichero... ");

				}
//				System.out.println("Esto es un fichero y se llama: " + f.getName());
//				if (esTexto(f)) {
//						if (contarPalabra(f, palabra)) {
//							estaLogCreado(nombreArchivo + "Palabra:" + palabra + "EnCoNtRaDa!!");
//						estaLogCreado(LocalDate.now() + "Copiando fichero" + f.getPath() + "a directorio"
//								+ Constantes.DIRECTORIO_DESTINO);
//							if (fechaUsuario.compareTo(fechafichero) < 0) {
//								System.out.println("La fecha introducida es anterior a la fecha del fichero");
				//
//							} else {
//								System.out.println("La fecha introducida es posterior a la fecha del fichero ");
//							}
//						}
//					}

				// comprobar si la fecha introducida es menor que la fecha del fichero y
				// comprobar si el fichero es de texto
				// Si se dan las dos condiciones anteriores hay que buscar si la palabra está en
				// el fichero
				// Si la palabra está en el fichero --> copiar el fichero al dir destino
				//
			} else {
				// System.out.println("Esto es un directorio: " + f.getAbsolutePath() + "Vamos a
				// visitarlo...");
				fw.write("Fecha - Analizando directorio: " + f.getName() + "\n");
				buscaArchivos(f.getAbsolutePath(), palabra, fecha);

			}
		}
		fw.close();

	}

	public boolean esTexto(File f) {
		String nombreDeFichero = f.getName();
		if (nombreDeFichero.endsWith(".txt")) {
			return true;

		} else
			return false;
	}

	public boolean encontrarPalabra(File f, String palabra) throws IOException {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] palabrasPorLinea = linea.split(" ");
				for (String p : palabrasPorLinea) {
					if (p.equalsIgnoreCase(palabra)) {

						return true;
					}
				}
			}

			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean estaLogCreado(String mensaje) {
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
		int anio = Calendar.YEAR;
		int mes = Calendar.MONTH + 1;
		int dia = Calendar.DAY_OF_MONTH;
		int year = anio % 100;

		String fechaDeHoy = String.valueOf(dia) + String.valueOf(mes) + String.valueOf(anio);
		return Integer.parseInt(fechaDeHoy);
	}

}
