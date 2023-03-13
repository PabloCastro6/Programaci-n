package com.pablo.ficheros;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
	FileReader fr = null;
	 BufferedReader br;
		try {
			fr = new FileReader("C:\\Users\\daw2223\\Desktop\\Trabajo Programacion GIT\\Programacion\\TEMA 6\\EjercicioFileReader.txt");
			br = new BufferedReader(fr);
			//Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\daw2223\\Desktop\\Trabajo Programacion GIT\\Programacion\\TEMA 6\\EjercicioFileReader.txt", true);
		
		
		fileWriter.write("\n Hola soy Pablo y estoy escribiendo en el fichero");
		fileWriter.close();
		
		

//		try (FileReader fr = new FileReader("C:\\Users\\daw2223\\Desktop\\Trabajo Programacion GIT\\Programacion\\TEMA 6");
//				BufferedReader br = new BufferedReader(fr)) {
//			String linea;
//			while ((linea = br.readLine()) !=null)
//				System.out.println(linea);
//		}
		
	}

}
