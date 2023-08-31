package com.jesus.practicaTeoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PracticaTeoria {
	public static void main(String[] args) throws IOException {
//		FileReader fr = null;
//		BufferedReader br;
//		try {
//			fr = new FileReader("C:\\Users\\DAW2226\\eclipse-workspace\\Tema 5\\archivos lectura\\mifichero.txt");
//			br = new BufferedReader(fr);
//			String linea;
//			while ((linea = br.readLine()) != null) {
//				System.out.println(linea);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (fr != null) {
//				fr.close();
//			}
//		}
//		FileWriter miWriter = null;
//		try {
//			miWriter = new FileWriter("C:\\Users\\DAW2226\\eclipse-workspace\\Tema 5\\archivos lectura\\mifichero.txt",
//					true);
//			miWriter.write("Escribir en archivos usando Java está chupado!!");
//
//			miWriter.close();
//			System.out.println("Se ha escrito el fichero!!");
//		} catch (IOException e) {
//			System.out.println("Ha ocurrido un error de entrada y salida");
//			e.printStackTrace();
//		} finally {
//			if (miWriter != null) {
//				miWriter.close();
//			}
//		}
		try(FileWriter miWriter = new FileWriter("C:\\Users\\DAW2226\\eclipse-workspace\\Tema 5\\archivos lectura\\mifichero.txt", true)){
			miWriter.write("\n Escribir en archivos usando Java está chupao!!");
		}
		try (FileReader fr = new FileReader(
				"C:\\Users\\DAW2226\\eclipse-workspace\\Tema 5\\archivos lectura\\mifichero.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		}
	}

}
