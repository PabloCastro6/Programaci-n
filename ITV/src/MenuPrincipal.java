import java.util.Scanner;



public class MenuPrincipal {
	int menuElegido; 
	private Vehiculo vehiculo;
	private Propietario propietario;
     private Boolean hayPropietario (Propietario propietario) {
    	  return (propietario != null);
     }
	
	public boolean Vehiculo() {
		return (vehiculo != null);
	}
	
	public void IntroducirMenu() {
		
		do {
			System.out.println("*********APLICACION ITV*************");
			System.out.println("Introduzca la opción elegida"); 
			System.out.println("1.Introducir vehículo");
			System.out.println("2.Introducir propietario");
			System.out.println("3.Dar precio ITV");
			System.out.println("4.Pasar la ITV");
			System.out.println("5.Imprimir informe de ITV");
			System.out.println("Salir de la aplicación ITV");
			Scanner sc = new Scanner(System.in);
			menuElegido = sc.nextInt();
			sc.nextLine();
			switch (menuElegido) {
			case 1: 
				if(hayVehiculo(vehiculo)) {
					String sobreescribe = null;
					do{
						
					System.out.println("El vehiculo ha sido creado ¿desea sobreescribirlo?");
					String sobreescribe1 = sc.nextLine();
					if(!sobreescribe1.equalsIgnoreCase("si") && !sobreescribe1.equalsIgnoreCase("no")) {
						System.out.println("Debes escribir si o no");
					}else if(sobreescribe1.equalsIgnoreCase("si")) {
						MenuCreacionVehiculo MenuCreacionVehiculo = new MenuCreacionVehiculo();
						Object menuVehiculo = null;
						vehiculo=((MenuCreacionVehiculo) menuVehiculo).MenuCreacionVehiculo();
					}else {
						System.out.println("No creamos un vehiculo nuevo");
					}
					}while(!sobreescribe.equalsIgnoreCase("no") && !sobreescribe.equalsIgnoreCase("no"));
					break;
					
				
			}else{
				MenuCreacionVehiculo menuvehiculo = new MenuCreacionVehiculo();
				vehiculo = menuvehiculo.MenuCreacionVehiculo();
				break;}
			case 2: {
				
				MenuCreacionPropietario menupropietario = new MenuCreacionPropietario();
				propietario = menupropietario.muestraMenuCreacionPropietario();
				break;
			}
			case 3: {
				if(hayVehiculo(vehiculo)) {
					System.out.println("ERROR:Debes traer un vehiculo para calcular la ITV");
				}else {
					System.out.println("El precio de tu ITV es:" + vehiculo.calculoPrecioITV());
				}
				break; 
			}
			case 4: {
				MenuPasarITV pasarITV = new MenuPasarITV();
				pasarITV.mostrarMenuPasarITV(vehiculo);
			}
				break;
			
			case 5: {
				EmisionInforme informe = new EmisionInforme();
				informe.emiteInforme(vehiculo, propietario);
				
				break;
			}
			case 6: {
				System.out.println("Cerrado.....");
				
				break; 
			}
			default: {
				System.out.println("El numero no esta entre 1 y 6");
				
				break;
			}
			}
		} while (menuElegido != 6);
	

	
		
	}

	private boolean hayVehiculo(Vehiculo vehiculo2) {
		
		return false;
	}
}


