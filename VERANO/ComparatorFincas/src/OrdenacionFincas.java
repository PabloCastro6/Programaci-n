import java.util.Comparator;

public class OrdenacionFincas implements Comparator<Propietario> {

	@Override
	public int compare(Propietario o1, Propietario o2) {
		
		return o1.getNumeroFincas().compareTo(o2.getNumeroFincas());
	}
	

}
