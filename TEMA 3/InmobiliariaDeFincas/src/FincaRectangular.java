import java.math.*; 

public class FincaRectangular {
	private double ladoA;
	private double ladoB;
	
	//Constructors
	public FincaRectangular() {}
	public FincaRectangular(int ladoA, int ladoB) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}
	
	//Getters
	public double getLadoA() {
		return ladoA;
	}
	public double getLadoB() {
		return ladoB;
	}
	
	//Setters
	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}
	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}
	
	//Methods
	//Calculate the area
	public double calculaArea() {
		double area = ladoA * ladoB;
		return area;
	}
	//Calculate the perimeter
	public double calculaPerimetro() {
		double p = 2 * (ladoA + ladoB);
		return p;
	}
	//Calculate the diagonal 
	public double calculaDiagonal() {
		double diagonal = Math.pow(((ladoA * ladoA) + (ladoB * ladoB)), 0.5);
		return diagonal;
	}
}
