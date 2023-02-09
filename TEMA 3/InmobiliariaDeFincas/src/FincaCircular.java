import java.math.*;

public class FincaCircular {
	private double radio;
	
	//Constructor
	public FincaCircular() {}
	public FincaCircular(double radio) {
		this.radio = radio;
	}
	
	// Getters/Setters
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	//Calculate the area
	public double calculaArea() {
		double area = Math.PI * radio * radio;
		return area;
	}
	//Calculate the perimeter
	public double calculaPerimetro() {
		double p = Math.PI * 2*radio;
		return p;
	}
}

