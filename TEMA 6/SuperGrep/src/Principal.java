import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		 if (nombreDeFichero.endsWith("")) {
			 return true;
			 
		 }else 
		return false;
		 }
		 
		 public boolean contarPalabra (File f, String palabra) throws FileNotFoundException,IOexception {
			 try (FileReader fr = new FileReader(f,StandardCharsets.UTF_8);
					 BufferReader br = new BufferReader (fr)) {
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
	 
}
