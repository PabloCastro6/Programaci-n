package RecursosHumanos;

public class Main {
	
	public static void main (String[] args) {
		
		Programador p = new Programador ("Pablo", 1, 2000.00,200.00);
		Administrativo a = new Administrativo ("Juan", 2, 3000.0,300.00);
		Freelance f = new Freelance("Sergio", 3,300.0,5);
		
		System.out.println("La nomina neta del programador" +p.getNombre() + "es" p.calculoSalario());
		System.out.println("La nomina neta del administrativo" +a.getNombre() + "es" p.calculoSalario());
		System.out.println("La nomina neta del freelance" +p.getNombre() + "es" p.calculoSalario());
	
	}
	

}
