package com.Pablo.spotify;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spotify {
	
	static List <CancionDTO> listaCanciones = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// Leer canciones
		getSongs();
		
		for (CancionDTO s : listaCanciones) {
			System.out.println(s);
		}
		Collections.sort(listaCanciones);
	//	Collections.sort(listaCanciones);
		System.out.println("=============");
		
		for (CancionDTO s : listaCanciones) {
			System.out.println(s);
	}
	}
	
	
	
	
	
	static void getSongs() throws IOException { 
		File file = new File ("C:\\Users\\daw2223\\Documents\\ListaCanciones.txt");
		BufferedReader lector;
		
		
		lector = new BufferedReader(new FileReader(file));
		String linea;
		
		while((linea = lector.readLine()) != null) {
			anadeCancion(linea);
			
			
		}
		
		
	}

	static void anadeCancion(String linea) {
		
		String[] arrayCancion = linea.split("-");
		listaCanciones.add(new CancionDTO(arrayCancion[0], arrayCancion[1], arrayCancion[2]));
		
	}
}
