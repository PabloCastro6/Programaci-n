package com.jesus.quijote;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase Analisis, con el funcionamiento del programa.
 *
 * @autor Jesus Angel Gajate Luna.
 */
public class Analisis {
	FicheroUtils fichero = new FicheroUtils();
	PdfUtils pdf = new PdfUtils();

	/**
	 * Metodo start() con el funcionamiento del programa.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
	public void start() throws Exception{
		
		Path quijote = Paths.get(Constantes.FICHERO_TEXTO_QUIJOTE);
		Path ficheroPalabras = Paths.get(Constantes.FICHERO_PALABRAS_A_BUSCAR);
		
		
		if(Files.exists(quijote) && Files.exists(ficheroPalabras)) {		
			File file = new File(Constantes.INFORME_FINAL);
	        file.getParentFile().mkdirs();

	        pdf.crearPdf(Constantes.INFORME_FINAL);
		}else {
			System.out.println("El fichero del quijote no existe, por favor pongalo en la ruta solicitada y ejecute el programa de nuevo");
		}
	}
}
