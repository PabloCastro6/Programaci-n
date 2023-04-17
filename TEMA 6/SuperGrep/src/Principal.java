import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;



public class Principal {

	public static void main (String[] args) {
		buscarArchivos ("C:\\Users\\daw2223\\Documents\\kk");
	}
	 public static void buscarArchivos (String ruta) {	
		 System.out.println("Bienvenido al programa SUPERGREP");
		 System.out.println("Por favor, introduzca la ruta del directorio que desea buscar");
		 
		 //1.Listar los archivos que hay en la carpeta prueba
		 // y obtener un array de elementos de tipo File
		 File raiz = new File (ruta);
		
		 File[] arrayFiles = raiz.listFiles();
		 
		// 2. Recorrer este array
		 for (File f : arrayFiles) {
			 if (f.isFile()) {
				 System.out.println("Esto es un fichero y se llama: "+ f.getName());
			 }else {
				 System.out.println("Esto es un directorio: " + f.getAbsolutePath() + "Vamos a visitarlo...");
				 buscarArchivos (f.getAbsolutePath());
			 }
		 }
		 
	 }
	 
	 public boolean esTexto(File f) {
		 String nombreDeFichero = f.getName();
		 if (nombreDeFichero.endsWith(".txt")) {
			 return true;
			 
		 }else 
		return false;
		 }
		 
	 
		 public boolean contarPalabra (File f, String palabra) throws IOException {
			 try (FileReader fr = new FileReader(f,StandardCharsets.UTF_8);
					 BufferedReader br = new BufferedReader (fr)) {
				 String linea;
				 while ((linea = br.readLine()) != null) {
					 String [] palabrasPorLinea = linea.split("");
					 for ( String p : palabrasPorLinea) {
						 if(p.equalsIgnoreCase(palabra) ) {
							 
						 }
					 }	 
			 }
		 }
	return false;	 
	
	
	
	} 
		 
		 public boolean estaLogCreado () {
			 //Hacedemos a la carpeta de Log
			 // Revisar todos los archivos de la carpeta de Log
			 // Hay que crear un String  con este formato superGrep_300321.log
			 String nombreArchivo = "superGrep_"+String.valueOf(fechaDeHoy())+".log";
			 File logFolder = new File ("log");
			 File [] logFiles = logFolder.listFiles();
			 
			 
				return false;
	
}
		 public int fechaDeHoy () {
			 int año = Calendar.YEAR;
			 int mes = Calendar.MONTH + 1;
			 int dia = Calendar.DAY_OF_MONTH;
			 int year = año % 100; 

			 String fechaDeHoy = String.valueOf (dia) + String.valueOf (mes)+ String.valueOf (año);
			 return Integer.parseInt(fechaDeHoy) ;
		 }
		 
	 
}
