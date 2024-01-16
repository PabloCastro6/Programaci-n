import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Cuenta> cuentas = new ArrayList<>();

		CuentaCorriente cc1 = new CuentaCorriente(1);
		CuentaCorriente cc2 = new CuentaCorriente(2);
		CuentaAhorro ca1 = new CuentaAhorro(3);
		CuentaAhorro ca2 = new CuentaAhorro(4);

		cuentas.add(cc1);
		cuentas.add(cc2);
		cuentas.add(ca1);
		cuentas.add(ca2);

		for (Cuenta cuenta : cuentas) {
			cuenta.retirarDinero(50.0);
			System.out.println(cuenta.toString());
		}
	}

}
