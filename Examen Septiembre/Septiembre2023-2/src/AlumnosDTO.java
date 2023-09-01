import java.util.Comparator;

public class AlumnosDTO implements Comparable<AlumnosDTO> {
	
	private int idAlumno;
	private String idMunicipio;
	
	@Override
	public int compareTo(AlumnosDTO o) {
		
		return 0;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int id) {
		this.idAlumno = id;
	}
	
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public AlumnosDTO(int id, String nombre, int edad, String idMunicipio) {
		super();
		this.idAlumno = idAlumno;
		this.idMunicipio = idMunicipio;
	}
	
}

 

