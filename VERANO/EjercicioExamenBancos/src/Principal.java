import java.sql.SQLException;
import java.util.Scanner;

import dto.BancoDTO;
import model.ClientesModelo;

public class Principal {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc =new Scanner (System.in);
		
		int n=0;
		
		do {
			
		    System.out.println(" MENU PRINCIPAL PARA DE GESTION DE CLIENTES");
		    System.out.println("===============================================");
		    System.out.println("1. crear cliente");
		    System.out.println("2. Buscar cliente por id");
		    System.out.println("3. Actualizar cliente");
		    System.out.println("4. Borrar cliente");
		    System.out.println("5. Salir");
		    System.out.println("===============================================");
		    
		
		    n = Integer.parseInt(sc.nextLine()); 
		    
		    if (n == 1) {
		    	System.out.println("Dime el id del cliente");
		    	int id = Integer.parseInt(sc.nextLine());
		    	BancoDTO banco = new BancoDTO(); // Crear variables 
		    	 ClientesModelo.crearCliente(banco);
		    	System.out.println("Cliente creado");
		    	
		    } else if (n == 2) {
		    	System.out.println("Dime el id del cliente");
		    	int id = Integer.parseInt(sc.nextLine());
		    	BancoDTO banco = ClientesModelo.buscarCliente(id);
		    	System.out.println("Cliente encontrado");
		    	System.out.println(banco.getNombre());
		    	
		    	
		    } else if (n == 3) {
		    	
		    } else if ( n == 4) {
		    	
		    } else if ( n == 5) {
		    	
		    }
		    
		    
		    } while(n != 5);
		
}
			
	}

	
