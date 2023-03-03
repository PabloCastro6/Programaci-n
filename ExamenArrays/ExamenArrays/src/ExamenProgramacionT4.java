import com.github.*;
import java.util.Scanner;
import com.github.javafaker.*;
import java.util.Random;

public class ExamenProgramacionT4 {
	public static void main(String[] args) {
			int sumario = 0;
			        Scanner input = new Scanner(System.in);
			        System.out.println("Digame el numero: ");
			        int numero = input.nextInt();
			        int[] array = new int[numero];
			        Random rand = new Random();
			       
			        System.out.println("El contenido del array es:");
			        for (int i = 0; i < numero; i++) {
			            array[i] = rand.nextInt(numero + 1);
			            sumario += array[i];
			        }

			        for (int i = 0; i < numero; i++) {
			            System.out.print(array[i] + " " );
			            
			        }
			        
			        System.out.println("");
			        System.out.print("La suma total del array es:" + sumario);
		
		
		
		
		
	
		
		
		
		
		
		
		
//		System.out.println("===========");
//		System.out.println("Ejercicio 2");
//		System.out.println("===========");
//		numero = sc.nextInt();
//		sc.nextLine();
//		String[] arrayNumeros = new String[numero];
//		Faker faker = new Faker();
//		for (int i = 0; i < numero; i++) {
//		arrayNumeros[i] = faker.name().fullName();
//		System.out.println("Array de los nombres:");
//		System.out.println(arrayNumeros );
//		
//	
//
//	
//	
//	
	System.out.println("");
	System.out.print("===========");
	System.out.println("");
	System.out.println("Ejercicio 3");
	System.out.print("===========");
	
	 int numero3 = input.nextInt();
	 Scanner input3 = new Scanner(System.in);
	
     System.out.print("Digame un numero: ");
     int n = input.nextInt();
     int[][] array3 = new int[n][n];
     Random random = new Random();
     int sum = 0;

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
             if (rand.nextInt(2) == 0) {
                 array3[i][j] = rand.nextInt(n + 1);
             } else {
                 array3[i][j] = -1;
             }
             sum += array3[i][j];
         }
     }

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
             if (array3[i][j] == -1) {
                 System.out.print("X ");
             } else {
                 System.out.print(array3[i][j] + " ");
             }
         }
         System.out.println();
     }

     System.out.println("La suma total es: " + sum);
 }
}



	
	

