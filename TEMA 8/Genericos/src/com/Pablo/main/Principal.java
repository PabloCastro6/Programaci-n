package com.Pablo.main;

import com.Pablo.utilidades.UtilidadesArrays;

public class Principal {

	public static void main(String[] args) {
		
		Integer[] arrayInt = { 1, 3, 5};
		UtilidadesArrays u = new UtilidadesArrays();
		
		
		//u.imprimeArraydeInt(arrayInt);

		
		Double[] arrayDouble  = { 2.0, 400.0, 5.0 };
		
		u.imprimeArray(arrayDouble);
	//	u.imprimeArraydeDouble(arrayDouble);
		
		String[] arrayString = {"Pablo", "Juana" , "pepita"};
		
	//	u.imprimeArrayDeString(arrayString);
		u.imprimeArray(arrayDouble);
	}

}
