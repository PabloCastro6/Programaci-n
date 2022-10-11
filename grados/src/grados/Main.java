package grados;

public class Main {
	
	public static void main(String[] args) {
		float fahrenheit = 98.6f; //Los tipos float los tenemos que declarar con una f junto al número
		
		float grados;
		
		grados = (fahrenheit - 32)* 5 / 9 ;
		System.out.println(fahrenheit + "grados fahrenheit son: "+grados+" grados centígrados");
		
	}

}
