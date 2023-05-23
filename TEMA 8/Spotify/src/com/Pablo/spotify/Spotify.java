package com.Pablo.spotify;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.Pablo.comparator.ComparaArtista;
import com.Pablo.comparator.ComparaPorUsuario;

public class Spotify {
	
	static List <CancionDTO> listaCanciones = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// Leer canciones
		getSongs();
		
		HashSet <CancionDTO> hs = new HashSet<CancionDTO> (listaCanciones);
		System.out.println("=========Contenido de hashset======");
		for (CancionDTO s : listaCanciones) 
			System.out.println(s);
		
			Scanner sc = new Scanner (System.in);
		
System.out.println("======ANTES DE ORDENAR=======");
		



		for (CancionDTO s : listaCanciones) {
			System.out.println(s);
	}
		Scanner sc = new Scanner (System.in);
		System.out.println("Como deseas ordenar las canciones? (artista/usuario/cancion)");
		String respuesta = sc.nextLine();
		
		
		if(respuesta.equals("artista")) {
			Collections.sort(listaCanciones,new ComparaArtista());
			
		} else if (respuesta.equals("usuario")) {
			Collections.sort(listaCanciones,new ComparaPorUsuario());
		} else {
			Collections.sort(listaCanciones);
		}
		
		System.out.println("======DESPUES DE ORDENAR=======");
		
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
