import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Alumnos implements Comparable<Alumnos> {
 
	private String dni;
	private String nombreA;
	private String edad;
	private List<Asignaturas> Asignaturas = new ArrayList<>();
	private Integer notaMedia;
	private Integer suspensos;
	
	public void Asignaturas() {
	
	}

	public Alumnos(String dni, String nombreA, String edad, List<Asignaturas> asignaturas) {
		super();
		this.dni = dni;
		this.nombreA = nombreA;
		this.edad = edad;
		this.Asignaturas = asignaturas;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreA() {
		return nombreA;
	}
	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumnos [dni=" + dni + ", nombreA=" + nombreA + ", edad=" + edad + "]";
	}

	@Override
	public int compareTo(Alumnos o) {
		
		return 0;
	}


	
	}
	

