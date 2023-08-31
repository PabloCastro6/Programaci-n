
public class examen {

	public static void main(String[] args) {
		int saltos = 5; 
		System.out.println("Bucle saltarin....");
		System.out.println("Pegando saltos de: "+ saltos + " en " + saltos);
		
		for (int i = 0; i<100; i += saltos) {
			if ((i + saltos) <100) {
				System.out.print (i + " , ") ;
			}else {
				System.out.print(i + ".");
				
			}
		}
		
	}

}
