import java.util.Scanner;

public class MenuFincaRectangular {
	Scanner sc = new Scanner(System.in);
	FincaRectangular recObj;
	int option;
	public void mostrarMenu(){
		do {System.out.println("******MENÚ de gestión FINCAS RECTÁNGULARES******");
		System.out.println("Indique la operación a realizar: ");
		System.out.println("1.Crear finca.");
		System.out.println("2.Calcular área.");
		System.out.println("3.Calcular perímetro.");
		System.out.println("4.Salir.");
		option = sc.nextInt();
		switch(option) {
		case 1:{				
			System.out.println("Introduzca el primer lado de la finca: ");
			int ladoA = sc.nextInt();
			System.out.println("Introduzca el segundo lado de la finca: ");
			int ladoB = sc.nextInt();
			recObj = new FincaRectangular(ladoA, ladoB);
			break;
		}
		case 2:	{
			if (estaCreadoObjeto(recObj)) {
				System.out.println(recObj.calculaArea());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca rectangular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca rectangular.");
				break;
			}
		}
		case 3:{
			if (estaCreadoObjeto(recObj)) {
				System.out.println(recObj.calculaPerimetro());
				break;
			}else {
				System.out.println("ERROR: No ha creado ningún objeto de tipo Finca rectangular.");
				System.out.println("Antes de hacer el cálculo debe crear un objeto de tipo finca rectangular.");
				break;
			}
		}
		case 4: break;
		default: System.out.println("Eliga número entre 1 y 4.");
		}
	}while(option != 4);
}
private boolean estaCreadoObjeto(FincaRectangular value) {
		return (value != null);
//	if(value != null) return true;
//	else return false;
// SonarLint
	}
}
