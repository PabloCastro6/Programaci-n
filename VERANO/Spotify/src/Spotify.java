


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Spotify{
	
	static List <Cancion> listaCanciones = new ArrayList <Cancion>();
	
	public static void main (String[] args) throws IOException {
		getSongs();
		
		for(Cancion s : listaCanciones) {
			System.out.println(s);
		}
		
		Collections.sort(listaCanciones); // ordenacion de coleccion, listas
		
		System.out.println();
		
		for(Cancion s : listaCanciones) {
			System.out.println(s);
		}
		
		Comparator comparator = new AutorComparator();
		Collections.sort(listaCanciones,comparator); // ordenacion de coleccion, listas
		
		System.out.println();
		
		for(Cancion s : listaCanciones) {
			System.out.println(s);
		}
	
	}
	
	static void getSongs() throws IOException {
		File file = new File("C:\\Users\\Usuario\\Downloads\\listacanciones.txt");
		BufferedReader lector;
		
		lector = new BufferedReader(new FileReader(file));
		String linea;
		
		while((linea = lector.readLine())  !=null) {
			addSong(linea);
		}
	}
	
	static void addSong(String linea) {
		
		String[] arrayCancion = linea.split("-");    //separacion entre palabras dentro del fichero 
		listaCanciones.add(new Cancion(arrayCancion[0],arrayCancion[1],arrayCancion[2]));
	}
}

