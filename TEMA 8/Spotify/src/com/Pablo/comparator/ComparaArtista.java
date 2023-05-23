package com.Pablo.comparator;

import java.util.Comparator;

import com.Pablo.comparator.*;
import com.Pablo.spotify.CancionDTO;

public class ComparaArtista  implements Comparator<CancionDTO>{

	
	public int compare(CancionDTO o1,CancionDTO o2) {
		
		return o1.getAutor().compareTo(o2.getAutor());
	}
}
