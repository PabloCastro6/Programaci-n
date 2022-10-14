package elseif;

class ejemploswicht {
	public static void main(String[] args) {
		
		int numero = 44;
		String talla; 
		
		//Usamos switch para comprobar a qué talla pertenece
		switch (numero) {
		
		case 29:
			talla = "S";
			break;
			
		case 42:
			talla = "M";
			break;
			
		case 44:
			talla = "L";
			break;
			
		case 48:
			talla = "XL";
			break;
			
			default: 
				talla = "Desconocida";
				break;
				
		}
		System.out.println("talla: " + talla);
				
		
		}
	}


