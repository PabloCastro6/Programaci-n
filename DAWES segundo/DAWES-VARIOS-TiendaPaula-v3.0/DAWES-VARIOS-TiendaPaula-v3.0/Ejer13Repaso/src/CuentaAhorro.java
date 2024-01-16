
public class CuentaAhorro extends Cuenta {

	public CuentaAhorro(Integer numeroCuenta) {
		super(0.0, numeroCuenta);
	}

	@Override
	public void retirarDinero(Double cantidad) {
		if (saldo - cantidad >= 0) {
			saldo -= cantidad;
		} else {
			System.err.println("No se puede retirar más dinero del disponible en una cuenta de ahorro.");
		}
	}
}