import java.util.Scanner;

public class MenuPoligonoRegular {
	Scanner sc = new Scanner(System.in);
	FincaPoligonoRegular pObj;
	int option;
	public void mostrarMenu(){
		do {System.out.println("******MENÚ de gestión FINCAS CON FORMA DE POLÍGONO REGULAR******");
		System.out.println("Indique la operación a realizar: ");
		System.out.println("1.Crear finca.");
		System.out.println("2.Calcular área.");
		System.out.println("3.Calcular perímetro.");
		System.out.println("4.Salir.");
		option = sc.nextInt();
		switch(option) {
		case 1:{				
			System.out.println("Introduzca la apotema de la finca: ");
			double apotema = sc.nextInt();
			System.out.println("Introduzca el lado de la finca: ");
			double lado = sc.nextInt();
			System.out.println("Introduzca el número de lados de la finca: ");
			int numeroLados = sc.nextInt();
			pObj = new FincaPoligonoRegular(apotema, lado, numeroLados);
			break;
		}
		case 2:	{
			if (estaCreadoObjeto(pObj)) {
				System.out.println(pObj.calculaArea());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca con forma de polígono regular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca con forma de polígono regular.");
				break;
			}
		}
		case 3:{
			if (estaCreadoObjeto(pObj)) {
				System.out.println(pObj.calculaPerimetro());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca con forma de polígono regular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca con forma de polígono regular.");
				break;
			}
		}
		case 4: break;
		default: System.out.println("Eliga número entre 1 y 4.");
		}
	}while(option != 4);
}
private boolean estaCreadoObjeto(FincaPoligonoRegular value) {
		return (value != null);
	}
}
