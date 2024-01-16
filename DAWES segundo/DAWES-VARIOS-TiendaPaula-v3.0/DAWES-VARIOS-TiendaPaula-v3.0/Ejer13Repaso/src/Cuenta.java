
public class Cuenta {

	protected Double saldo; 
	private Integer numeroCuenta; 
	
	public Cuenta(Double saldo, Integer numeroCuenta) {
		super();
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Cuenta(Integer a, Double saldo) {
		saldo = 0.0;
		numeroCuenta = a;
	}

	public void ingresarDinero(Double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        } else {
            System.out.println("No se puede ingresar una cantidad negativa");
        }
    }

    public void retirarDinero(Double cantidad) {
        if (cantidad > 0) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
            } else {
                System.out.println("Saldo insuficiente para realizar el retiro");
            }
        } else {
            System.out.println("No se puede retirar una cantidad negativa");
        }
    }


	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numeroCuenta=" + numeroCuenta + "]";
	}
}
