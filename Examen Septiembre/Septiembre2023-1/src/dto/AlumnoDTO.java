package dto;

public class AlumnoDTO {
	private int id;
	private String nombre;
	private int idMunicipio;
	private int familiaNumerosa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public int getFamiliaNumerosa() {
		return familiaNumerosa;
	}
	public void setFamiliaNumerosa(int familiaNumerosa) {
		this.familiaNumerosa = familiaNumerosa;
	}
	
	
	
	
	public AlumnoDTO(int id, String nombre, int idMunicipio, int familiaNumerosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMunicipio = idMunicipio;
		this.familiaNumerosa = familiaNumerosa;
	}
	
	
	
	
	public AlumnoDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
	public AlumnoDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AlumnoDTO [id=" + id + ", nombre=" + nombre + ", idMunicipio=" + idMunicipio + ", familiaNumerosa="
				+ familiaNumerosa + "]";
	}
	
	
	public void setIdMunicipio(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	public void setFamiliaNumerosa(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}