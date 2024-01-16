import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número para generar la secuencia de Fibonacci: ");
        int numero = sc.nextInt();
        sc.nextLine();

        int a = numero, b = numero;
        
        System.out.print(numero + " " + numero + " ");
        
        for (int i = 0; i < 10; i++) {
            int sum = a + b;
            System.out.print(sum + " ");
            a = b;
            b = sum;
        }
        
    }
}