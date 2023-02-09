import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios{
	//Ejercicio 1
	 public int CalculaSuma (int [] numeros) {
		 int suma = 0; 
		 for ( int i = 0; i < numeros.length; i++) {
			 suma += numeros[i];
		 }
		 return suma; 
	 }
	 public int calculaProducto (int [] numeros) {
		 int producto = 1;
		 for (int i : numeros) {
			 producto *= i;
			 
		 }
		 return producto;
	 }
	 public int calculaMedia (int [] numeros) {
		 return (CalculaSuma(numeros)/numeros.length);
		 
	 }
	 
	 //Ejercicio 3
	 // Determinar Maximo con Sort 
	 
	 public int MaximoSort (int [] numeros) {
		 Arrays.sort(numeros);
		 return numeros [numeros.length -1 ];
	 }
	 
	 //Determinar Minimo con Sort
	 
	 public int MinimoSort (int [] numeros) {
		 Arrays.sort(numeros);
		 return numeros [0];
	 }
	 
	 //Determinar Maximo
	 public int Maximo (int[] numeros) {
		 int n = 0;
		 for (int i = 0; i<numeros.length -1; i++ ) {
			 if (numeros[i] < numeros[i + 1]) {
				 n = numeros [i + 1];
			 }
			 else n = numeros[i];
			 }
		 return n;
		 }
	 //Determinar Minimo
	 public int Minimo (int [] numeros) {
		 int n = numeros [0];
		 for (int i = 1; i < numeros.length; i++) {
			 if (numeros[i] <n ) {
				 n = numeros [i];
			 }
		 }
		 return n;
	 }
	 
	 //Ejercicio 4
	 //Numeros negativos 
	 
	 public int numNegativos (int[] numeros) {
		 int c = 0; 
		 for (int i : numeros) {
			 if (i < 0) c += 1;
		 }
		 return c;
	 }
	 // Numero positivos 
	 public int numPositivos ( int[] numeros) {
		 int c = 0;
		 for (int i : numeros) {
				 if ( i > 0) c += 1;
			 }
			 return c;
		 }
	//Null
	  public int encuentraNull (int[] numeros) {
		  int c = 0;
		  for (int i : numeros) {
			  if (i==0) c += 1;
		  }
		  return c; 
	  }
	
	 
	 
	 
	 }

	 
		
	


