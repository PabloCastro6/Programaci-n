
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Metodos {
	int contArchivos = 0, contDirs=0,total=0;
	FileWriter fw;
	public Metodos (FileWriter fw) {
		this.fw=fw;
	}
	
	
	public String escribirFecha () {
		SimpleDateFormat date2 = new SimpleDateFormat("dd/MM/yyyy");
		return date2.format(new Date());
	}

	public void buscaArchivos(String directorio, String palabra, String fecha) throws IOException {
		String date = new SimpleDateFormat("ddMMyy").format(new Date());
		// superGrep_280423.log
		FileWriter fw = new FileWriter(Constantes.DIRETORIO_LOG + "superGrep" + date + ".log", true);

		File raiz = new File(directorio);
		File[] arrayFiles = raiz.listFiles();
		boolean palabraEncontrada = false;
		String nombreArchivo = "";

		
		for (File f : arrayFiles) {
			if (esTexto(f)) {
				fw.write(escribirFecha()+ "Fecha-finalizando archivo: " + f.getName() + "\n");
				nombreArchivo = f.getName();
				fw.write("Fecha "+escribirFecha()+" - Analizando archivo: " + nombreArchivo + "\n");
				if (encontrarPalabra(f, palabra)) {
					fw.write("Palabra " + palabra + " ENCONTRADA !!! \n");
					fw.write("Copiando fichero: " + f.getName() + " a directorio " + Constantes.DIRECTORIO_DESTINO
							+ "\n");
					
		
					Path origen = Paths.get(f.getAbsolutePath());
					Path destino = Paths.get(Constantes.DIRECTORIO_DESTINO + f.getName());
					Files.copy(origen,destino, StandardCopyOption.REPLACE_EXISTING);
					

				}

			} else {
				fw.write("Fecha" +escribirFecha()+ "- Analizando directorio: " + f.getName() + "\n");
				contDirs++;
				buscaArchivos(f.getAbsolutePath(), palabra, fecha);

			}
		}
	}
	
	public void imprimirContadores() {
		try {
			fw.write("Fecha" +escribirFecha()+ " - Numero total de archivos analizados: " +contArchivos+"\n");
			
			fw.write("Fecha " +escribirFecha()+ "- Numero total de los directorios analizados: " +contDirs+ "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean esTexto(File f) {
		String nombreDeFichero = f.getName();
		if (nombreDeFichero.endsWith(".txt")) {
			System.out.println("Incrementa contador Ar");
			contArchivos++;
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

	
	public int fechaDeHoy() {
		int anio = Calendar.YEAR;
		int mes = Calendar.MONTH + 1;
		int dia = Calendar.DAY_OF_MONTH;
		int year = anio % 100;

		String fechaDeHoy = String.valueOf(dia) + String.valueOf(mes) + String.valueOf(anio);
		return Integer.parseInt(fechaDeHoy);
	}

}
