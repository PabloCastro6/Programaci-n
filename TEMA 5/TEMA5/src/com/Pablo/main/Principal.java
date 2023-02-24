package com.Pablo.main;

import java.util.Scanner;

import com.Pablo.calculos.Calculos;

public class Principal {
public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	boolean valoresOK = false;
	do {
	System.out.println("Porfavor, digame el primer número");
	int valorUno = sc.nextInt();
	sc.hasNextLine();
	System.out.println("Porfavor, digame el segundo número");
	int valorDos= sc.nextInt();
	sc.nextLine();
	
	Calculos c = new Calculos();
	try {
	c.dividirYSumar(valorUno, valorDos);
	valoresOK=true;
	
	} catch (ArithmeticException a) {
		System.out.println ("El divisor no puede ser cero, intentelo otra vez");
	}
} while (!valoresOK);
}
}
