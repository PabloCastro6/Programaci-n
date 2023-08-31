
import java.util.Comparator;

public class OrdenacionEdad implements Comparator<Propietario>{



	@Override
	public int compare(Propietario o1, Propietario o2) {
		return o1.getEdad().compareTo(o2.getEdad());
	}

}

