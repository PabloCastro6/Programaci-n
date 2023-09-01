import java.util.Comparator;

public class Alumno  implements Comparator <AlumnosDTO>  {
	@Override
	public int compare(AlumnosDTO o1, AlumnosDTO o2) {
		
		return Integer.compare(o1.getIdMunicipio(), o2.getIdMunicipio());
	}
	
}

