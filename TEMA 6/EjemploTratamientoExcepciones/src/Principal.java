import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digame el nombre del fichero..");
		String rutaFichero = sc.nextLine();
		ClaseUtilidadesFichero c = new ClaseUtilidadesFichero ();
		
		c.leerFichero(rutaFichero);
		
		
	}
}
