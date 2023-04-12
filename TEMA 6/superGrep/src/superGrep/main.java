package superGrep;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String directorioInicio = obtenerDirectorioInicio();
		String fechaBusqueda= obtenerFechaBusqueda();
		Date fechaBusqueda = null;
		if (!fechaBusqueda.isEmpty()) {
            fechaBusqueda = obtenerFecha(fechaBusqueda);
        }
        buscarArchivos(directorioInicio, fechaBusqueda);
    }
		
public static String obtenerDirectorioInicio() {
	return"";
	}

public static String obtenerFechaBusqueda() {
	Scanner scanner =  new Scanner(System.in);
	System.out.println("Introduce una fecha");
	return scanner.nextLine();
}
	 public static void buscarArchivos (String ruta) {
		 File raiz = new File(ruta) ;
		 //1.Listar los archivos que hay en la carpeta prueba
		 //y obtener un array de elementos de tipo File.
		 
		 File[]  arrayFiles = raiz.listFiles();
		 //2.Recorrer este array:
		 for (File f : arrayFiles ) {
			 if ( f.isHidden()) {
				 //2.1 Si el elemento visitado es un archivo debemos analizarlo (esta seria la operacion termianl).
				 System.out.println("Esto es un fichero y se llama" + f.getName());
				 
			 } else {
				 //2.2 Si el elemento visitado es un directorio hacemos una llamada recursiva a la función.
				 System.out.println("Esto es un dir: " + f.getAbsolutePath() + "vamos a visitarlo...");
				 buscarArchivos(f.getAbsolutePath());
			 }
		 }
	 }

}
