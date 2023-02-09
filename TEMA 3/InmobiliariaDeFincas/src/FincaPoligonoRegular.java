
public class FincaPoligonoRegular {
	private double apotema;
	private double lado;
	private int numeroLados;
	
	//Constructors
	public FincaPoligonoRegular() {}
	public FincaPoligonoRegular(double apotema, double lado, int numeroLados) {
		this.apotema = apotema;
		this.lado = lado;
		this.numeroLados = numeroLados;
	}
	
	//Getters
	public double getApotema() {
		return apotema;
	}
	public double getLado() {
		return lado;
	}
	public int getNumeroLados() {
		return numeroLados;
	}
	//Setters
	public void setApotema(double apotema) {
		this.apotema = apotema;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public void setNumeroLados(int numeroLados) {
		this.numeroLados = numeroLados;
	}
	
	//Methods
	public double calculaArea() {
		double area = (numeroLados * lado * apotema) / 2;
		return area;
	}
	public double calculaPerimetro() {
		return (lado * numeroLados);
	}
}
