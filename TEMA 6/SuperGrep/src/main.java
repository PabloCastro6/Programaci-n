import java.io.File;

public class Main {

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
		 
		 
		 
		 //2.1 Si el elemento  visitado es un archivo debemos analizarlo 
		 //2.2 Si el elemento visitado es un directorio hacemos una llamada recursiva 
	 }
}
