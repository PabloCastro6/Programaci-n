import java.util.Scanner;

public class EmisionInforme {

private void imprimirDeficienciasGraves(Vehiculo vehiculo) {
	if(vehiculo.getDeficienciasLeves() == null) {
		System.out.println("ITV no superada");
		System.out.println("Deficiencias Graves: " + vehiculo.getDeficienciasGraves());
	}else {
		System.out.println("ITV no superada");
		System.out.println("Deficiencias Graves: " + vehiculo.getDeficienciasGraves());
		System.out.println("Deficiencias Leves: " + vehiculo.getDeficienciasLeves());
	}
}
private void imprimirDeficienciasLeves(Vehiculo vehiculo) {
	if(vehiculo.getDeficienciasLeves() == null) {
		System.out.println("No hay deficiencias Leves");
		System.out.println("ITV superada");
	}else {
		System.out.println("Deficiencias Leves: " + vehiculo.getDeficienciasLeves());
		System.out.println("ITV superada");
		
		
	}
}

	Scanner sc = new Scanner(System.in);
	
	public void emiteInforme(Vehiculo v, Propietario p) { 
		System.out.println("*************************IMFORME ITV*******************");
		
		System.out.println("**************************************");
		System.out.println("***********Datos del propietario***************");
		System.out.println("******************************");
		System.out.println("");
		System.out.println("DNI: "+p.getdni());
		System.out.println("Apellidos: "+p.getapellidos());
		System.out.println("Nombre: " +p.getNombre());
		System.out.println("");
		System.out.println("************************************************");
		System.out.println("*******************Datos del vehículo*************");
		System.out.println("*********************************************");
		System.out.println("Matricula " +v.getMatricula());
		System.out.println("Modelo " +v.getModelo());
		System.out.println("Tipo combustible " +v.getCombustible());
		System.out.println("***************************************************");
		System.out.println("*****************Datos de la ITV******************");
		System.out.println("*************************************************");
		
		EmisionInforme emision=new EmisionInforme();
		
	
	
		if (!v.getRevisionPasada()) {
			System.out.println("Todavia no ha pasado la ITV");
		}else if (v.getRevisionPasada() && v.getRevisionSuperada()) {
		emision.imprimirDeficienciasLeves(v);
		}else {
			emision.imprimirDeficienciasGraves(v);
		}
		
		System.out.println("Precio de la ITV es: " + v.calculoPrecioITV());
		
		

	}
}
	

