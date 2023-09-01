import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcionamiento {

	public static String palabrasABuscar;

	public static String ficheroDeBuscar;

	FileUtils fichero = new FileUtils();

	Scanner sc = new Scanner(System.in);

	public void flujo() throws Exception {
		System.out.println("Introduce una palabra");
		palabrasABuscar = sc.nextLine();
		System.out.println("Deseas introducir mas palabras? (s/n)");
		
			System.out.println("Dime el fichero en el que debo buscar");
			ficheroDeBuscar = sc.nextLine();
			System.out.println("dime el fichero en el que debo escribir");
			String ficheroPaEscribir = sc.nextLine();

			Path ficheroDeLeer = Paths.get(ficheroDeBuscar);
			Path ficheroDeEscribir = Paths.get(ficheroPaEscribir);

			if (Files.exists(ficheroDeLeer) && Files.exists(ficheroDeEscribir)) {
				File file = new File(ficheroPaEscribir);
				file.getParentFile().mkdirs();
			} else {
				System.out.println("El fichero donde debo buscar no existe");
			}
		}
	}

