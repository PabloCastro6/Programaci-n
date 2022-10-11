
public class proyec {

	public static void main(String args[]) {
		int primerNumero = 20;
		int segundoNumero = 5;

		int resultado;

		resultado = primerNumero + segundoNumero;
		System.out.println("La suma de los dos números es:" + resultado);
		System.out.println("También se podría hacer así, sin acumular el resultado en una variable: "
				+ (primerNumero + segundoNumero));

		// La variable puede cambiar de valor
		resultado = primerNumero * segundoNumero;
		System.out.println("La multiplicación de los dos números es: " + resultado);

		resultado = primerNumero / segundoNumero;
		System.out.println("La división de los dos números es:" + resultado);

		resultado = primerNumero % segundoNumero;
		System.out.println("El resto de los dos números es:" + resultado);

		// Diferencia entre ++primerNumero y primerNumero++
		System.out.println("Cuando no forman parte de una expresión el resultado es el mismo: ");
		++primerNumero;// Incrementa en uno la variable
		System.out.println("Cuando no forman parte de una expresión el resultado es el mismo:");
		++primerNumero; // Incrementa en uno la variable
		System.out.println("Valor de la variable primerNumero:" + primerNumero);

	
//Pero cuando forma parte de una expresión la posición del operador decidirá si el valor se
//incrementa (o decrementa)antes o después de la evaluación de la expresión
primerNumero = 20; //volvemos a darle el valor de 20
System.out.println(primerNumero);
resultado = primerNumero - ++segundoNumero; // 20 - (++5), es decir, 20 - 6
System.out.println("Resultado de la expresión:" + resultado);
System.out.println("Valor de la variable segundoNumero:" + segundoNumero); 
	
//Comparar con esto: 
segundoNumero = 5; //Le volvemos a dar a la variable segundoNumero su valor original
resultado = primerNumero - segundoNumero++; //20 - 5 = 4 y después de hacer la operación suma 1 a la variable segundoNumero
System.out.println("Resultado de la expresión:" + resultado);
System.out.println("valor de la variable segundoNumero: " + segundoNumero);
//Comparar con esto:
segundoNumero = 5; //Le volvemos a dar la variable segundoNumero su valor original 
resultado = primerNumero - segundoNumero++;// 20 - 5 = 4 y después de hacer la operación suma 1 a la variable segundoNumero
System.out.println("Resultado de la expresión:" + resultado);
System.out.println("valor de la variable segundoNumero:" + segundoNumero);

//Operadores relacionales. Con estos podremos tomar decisiones en el programa (lo veremos en un tema posterior)

System.out.println("Resultado de comparar su primerNumero y segundoNumero son iguales:" + (primerNumero == segundoNumero));
System.out.println("Resultado de comparar si primerNumero es mayor que segundoNumero:" + (primerNumero > segundoNumero));
System.out.println("Resultado de comparar si primerNumero es menor que segundoNumero:" + (primerNumero < segundoNumero));
System.out.println("Resultado de comparar si primerNumero y segundoNumero son diferentes:" + (primerNumero != segundoNumero));

//OPERADORES DE ASIGNACIÓN
segundoNumero = primerNumero;
System.out.println("Ahora segundoNumero vale lo mismo que primerNumero" + segundoNumero);

segundoNumero+= primerNumero; //Es equivalente a hacer segundoNumero = segundoNumero + primerNumero (20 + 20)
System.out.println("valor de la variable segundoNumero:" + segundoNumero);

segundoNumero -= primerNumero; //Es equivalente a hacer segundoNumero = segundoNumero - primerNumero (40 - 20)
System.out.println("valor de la variable segundoNumero:" + segundoNumero);

segundoNumero /= primerNumero; //Es equivalente a hacer segundoNumero = segundoNumero / primerNumero (20/20)
System.out.println("valor de la variable segundoNumero:" + segundoNumero);

segundoNumero *= primerNumero; //Es equivalente a hacer segundoNumero = primerNumero (1 * 20)
System.out.println ("valor de la variable segundoNuero:" + segundoNumero);

	}
}

