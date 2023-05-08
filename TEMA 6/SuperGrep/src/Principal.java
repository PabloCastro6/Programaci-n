import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class Principal {

	public void start() throws IOException {
		String date = new SimpleDateFormat("ddMMyy").format(new Date());
		FileWriter fw = new FileWriter(Constantes.DIRETORIO_LOG + "superGrep_" + date + ".log",true );
		
		
		Metodos metodos = new Metodos(fw);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al programa SUPERGREP");

		System.out.println("Por favor, introduzca la ruta del directorio que desea buscar");
		String directorio = scanner.nextLine();

		System.out.println("Por favor, introduzca la palabra");
		String palabra = scanner.nextLine();

		System.out.println("Por favor, introduzca la fecha");
		String fecha = scanner.nextLine();
		metodos.buscaArchivos(directorio, palabra, fecha);
		metodos.imprimirContadores();
		fw.close();

	}

}