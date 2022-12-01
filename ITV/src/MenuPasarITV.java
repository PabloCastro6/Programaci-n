import java.util.Scanner;

public class MenuPasarITV {
	Scanner sc = new Scanner(System.in);
	public void mostrarMenuPasarITV (Vehiculo v) {
		int menu;
		String deficienciasLeves;
		
		System.out.println("***Menu Pasar ITV");
		System.out.println("Elija la opción que desee ejecutar");
		System.out.println("1.Pasar la ITV sin deficiencias");
		System.out.println("2.Pasar la ITV con deficiencias leves");
		System.out.println("3.No pasas la ITV");
		menu=sc.nextInt();
		sc.nextLine();
		
		
		
		switch(menu) {
		case 1:
			v.setRevisionPasada(true);
			v.setRevisionSuperada(true);
			break;
		case 2:
			System.out.println("Introduzca la deficiencia leve observada");
			deficienciasLeves=sc.nextLine();
			v.setDeficienciasLeves(deficienciasLeves);
			v.setRevisionPasada(true);
			v.setRevisionSuperada(true);
			break;
		case 3: 
			System.out.println("Introduzca la deficiencia grave observada");
			String deficienciasGraves=sc.nextLine();
			v.setDeficienciasGraves(deficienciasGraves);
			System.out.println("Introduzca la deficiencia leve observada");
			deficienciasLeves=sc.nextLine();
			
			if(deficienciasLeves.equals("")) {
			v.setDeficienciasLeves(null);
			
		}else {
			v.setDeficienciasLeves(deficienciasLeves);
		}
		v.setRevisionPasada(true);
		v.setRevisionSuperada(false);
		break;
		default:
			System.out.println("El numero no se encuentra entre 1 y 3");
		}
	
		}
	
}
	


