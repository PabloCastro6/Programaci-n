
public class  TrabajadorPorHoras extends Empleado {
    private int horasTrabajadas;

    public TrabajadorPorHoras(String nombre, int numeroEmpleado, double sueldo, int horasTrabajadas) {
        super(nombre, numeroEmpleado, sueldo);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * horasTrabajadas;
    }
}
