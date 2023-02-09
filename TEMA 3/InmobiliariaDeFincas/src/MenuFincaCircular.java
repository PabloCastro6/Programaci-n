import java.util.Scanner;

public class MenuFincaCircular {
	Scanner sc = new Scanner(System.in);
	FincaCircular cObj;
	int option;
	public void mostrarMenu(){
		do {System.out.println("******MENÚ de gestión FINCAS CIRCULARES******");
		System.out.println("Indique la operación a realizar: ");
		System.out.println("1.Crear finca.");
		System.out.println("2.Calcular área.");
		System.out.println("3.Calcular perímetro.");
		System.out.println("4.Salir.");
		option = sc.nextInt();
		switch(option) {
		case 1:{				
			System.out.println("Introduzca el radio de la finca: ");
			double radio = sc.nextInt();
			cObj = new FincaCircular(radio);
			break;
		}
		case 2:	{
			if (estaCreadoObjeto(cObj)) {
				System.out.println(cObj.calculaArea());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca circular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca circular.");
				break;
			}
		}
		case 3:{
			if (estaCreadoObjeto(cObj)) {
				System.out.println(cObj.calculaPerimetro());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca circular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca circular.");
				break;
			}
		}
		case 4: break;
		default: System.out.println("Eliga número entre 1 y 4.");
		}
	}while(option != 4);
}
private boolean estaCreadoObjeto(FincaCircular value) {
		return (value != null);
	}
}
