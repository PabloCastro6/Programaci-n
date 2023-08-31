
public class Finca {

	private String localidad;
	private Integer superficie;
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	
	public Finca(String localidad, Integer superficie) {
		super();
		this.localidad = localidad;
		this.superficie = superficie;
	}
	@Override
	public String toString() {
		return "Finca [localidad=" + localidad + ", superficie=" + superficie + "]";
	}
	

}


