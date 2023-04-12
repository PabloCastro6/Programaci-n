package com.Pablo.Quijote;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FicheroUtils {
	
public String[] lecturasPalabras() {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	ArrayList<String> palabras = new ArrayList<String>();
	
	try {
		archivo = new File (System.getProperty("user.dir")+ "\\src\\LecturaQuijote\\palabras.txt");
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		String linea;
		while ((linea = br.readLine()) != null) {
		System.out.println(linea);
		}
		fr.close();
		
	} catch(Exception e) {
		System.out.println(linea);
		
	}
	fr.close();
}
	
	}
 //métodos para hacer operaciones con fichero
	
	
	

