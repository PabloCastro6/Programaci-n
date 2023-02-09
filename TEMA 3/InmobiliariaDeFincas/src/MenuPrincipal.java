import java.util.Scanner;

public class MenuPrincipal {
	public void muestraMenuPrincipal() {
		Scanner sc = new Scanner(System.in);
		int option;
		
		do{System.out.println("*****APLICACIÓN DE GESTIÓN DE FINCAS*****");
		System.out.println("*************MENÚ PRINCIPAL*************");
		System.out.println("Introduzca la acción que quiera realizar:");
		System.out.println("1.Gestion de fincas rectangulares.");
		System.out.println("2.Gestion de fincas circulares.");
		System.out.println("3.Gestion de fincas con forma de polígono regular.");
		System.out.println("4.Salir.");
		option = sc.nextInt();		
		switch(option) {
		case 1:{ 
			MenuFincaRectangular obj = new MenuFincaRectangular();
			obj.mostrarMenu();
			break;
			}
		case 2:{ 
			MenuFincaCircular obj = new MenuFincaCircular();
			obj.mostrarMenu();
			break;
			}
		case 3:{ 
			MenuPoligonoRegular obj = new MenuPoligonoRegular();
			obj.mostrarMenu();
			break;
			}
		case 4: break;
		default: 
			System.out.println("Eliga número entre 1 y 4.");
		}
	}while(option != 4);
	}
}
