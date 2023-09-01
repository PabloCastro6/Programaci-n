import java.util.Comparator;

public class idMunicipio implements Comparator <AlumnosDTO> {

	@Override
	public int compare(AlumnosDTO o1, AlumnosDTO o2) {
		
		return o1.getIdAlumno() - o2.getIdAlumno();
	}



}
