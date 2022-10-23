package ejercicio22;

public class ejercicio22 {
int mes = 2;
int numeroDias = 0;
int año = 2020;


if (año % 4 == 0) {
	if (mes <= 12) {
		switch (mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			numeroDias = 31;
		break;
		case 4, 6, 9, 11:
			numeroDias = 30;
		break;
		case 2:
			numeroDias = 29;
			break;
			
			
		}
		System.out.println("este mes tiene" + numeroDias + "dias");
	}else {
		System.out.println("el mes introducido no coincide con ninguno del calendario");
	}
} else if (año % 4 == 0 && año % 1 != 0) {
	if (mes <= 12) {
		switch (mes) {
		case 1, 3, 5,  7, 8, 10, 12:
			numeroDias = 31;
		break;
		case 4, 6, 9, 11:
			numeroDias = 30;
		break;
		case 2:
			numeroDias = 29;
			break;
			
		}
		System.out.println("este mes tiene" + numeroDias + "dias");
	}else  {
		System.out.println("el mes introducido no coincide con ninguno del calendario");
		
	}

}
}
}


