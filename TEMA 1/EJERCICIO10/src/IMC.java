
public class IMC {
public static void main(String[] args) {
	float peso = (float) 70.5; //Esto es crear la variable float.
	//Inicializarla es darle el numero que tu quieras, y darle valor.
	
	float altura = (float) 1.80; //Crear variable y incializo
	
	float resultado; //En este caso lo que creo que una variable que la llamo resultado.
	//Esto es como crear un hueco donde vas a meter el resultado.
	//En la siguiente línea lo puedes ver.Aquí lo creo, y abajo lo utilizo con
	//el igual para guardar en resultado esa operación
	
	resultado = peso * (float)Math.pow(altura,2); //Hacer la formula
	//Lo de Math.pow es una función que tiene java de por sí.
	//Al poner Math.pow y lo de los parentesis estoy haciendo la altura al cuadrado
	
	System.out.println("El Indice de masa corporal es: " + resultado);
	//Esto del System. out.println sirve para que cuando le des a que empiecec el programa te salga el mensaje que 
	//has puesto entre parentesis. Luego el "+ resultado" sirve para que despues de los dos puntos salga el resultado
	//que he calculado arriba
	
}
}
