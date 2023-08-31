import java.util.Comparator;

public class AutorComparator implements Comparator<Cancion>{

	@Override
	public int compare(Cancion o1, Cancion o2) {
		
		return o1.getAutor().compareTo(o2.getAutor()); 
	}

	
	
}
