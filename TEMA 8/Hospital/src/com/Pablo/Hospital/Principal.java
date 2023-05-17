package com.Pablo.Hospital;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
	
	
	List<PacienteDTO> listaPacientes = new ArrayList<> ();
	
	public static void main(String[] args) throws IOException {
		
		new Principal().iniciarPrograma();

	}

	
	public void iniciarPrograma() throws IOException {
		leerArchivo();
		Collections.sort(listaPacientes);
		System.out.println(listaPacientes.toString());
		
	}
	
	public void leerArchivo() throws IOException {
		File f = new File("C:\\Users\\daw2223\\Documents\\ListaPacientes.txt");
		BufferedReader bf = new BufferedReader(new FileReader(f));
		String linea;
		
		
		while ((linea=bf.readLine()) != null) {
			anadePaciente(linea);
			
			
		}
	} 
	
	public void anadePaciente (String linea) {
		String[] paciente = linea.split(";");
		
		listaPacientes.add(new PacienteDTO (paciente[0], paciente[1], paciente[2], Integer.parseInt(paciente[3])));
	}
}
