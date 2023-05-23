package com.Pablo.comparator;


import java.util.Comparator;

import com.Pablo.spotify.CancionDTO;

public class ComparaPorUsuario implements Comparator<CancionDTO> {

	@Override
	public int compare(CancionDTO o1, CancionDTO o2) {
		// TODO Auto-generated method stub
		return o1.getUsuario().compareTo(o2.getUsuario());
	}
	

}
