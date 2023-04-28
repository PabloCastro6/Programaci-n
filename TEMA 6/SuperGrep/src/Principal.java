import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;


public class Principal {

	public void start() throws IOException {
		Metodos metodos = new Metodos();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al programa SUPERGREP");

		System.out.println("Por favor, introduzca la ruta del directorio que desea buscar");
		String directorio = scanner.nextLine();

		System.out.println("Por favor, introduzca la palabra");
		String palabra = scanner.nextLine();

		System.out.println("Por favor, introduzca la fecha");
		String fecha = scanner.nextLine();
		metodos.buscaArchivos(directorio, palabra, fecha);

	}

}