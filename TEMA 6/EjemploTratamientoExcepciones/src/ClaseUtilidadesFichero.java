import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClaseUtilidadesFichero {

public void leerFichero(String nombreFichero) throws IOException {
	FileReader fr = null;
	BufferedReader br = null;
	boolean ficheroEncontrado = false;
	
	while(!ficheroEncontrado) {
	
		
			fr = new FileReader(nombreFichero);
			ficheroEncontrado = true;
			br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		
	
	}
}
}
