package com.jesus.quijote;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Class principal del programa con el main.
 *
 * @autor Jesus Angel Gajate Luna.
 */
public class Principal {
	public static void main(String[] args) throws Exception {
		Analisis analisis = new Analisis();
		analisis.start();
	}
}
