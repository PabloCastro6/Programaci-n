import java.util.ArrayList;
import java.util.List;

public class Main {
	
    public static void main(String[] args) {
    
        Empleado empleado1 = new Gerente("Gerente1", 1, 3000.0, 500.0);
        Empleado empleado2 = new TrabajadorPorHoras("Trabajador1", 2, 12.0, 40);
        Empleado empleado3 = new TrabajadorPorHoras("Trabajador2", 3, 15.0, 30);

   
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

      
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Número de Empleado: " + empleado.getNumeroEmpleado());
            System.out.println("Sueldo: " + empleado.calcularSalario());
            System.out.println();
        }
    }
}
