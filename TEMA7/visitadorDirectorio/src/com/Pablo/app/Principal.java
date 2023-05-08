package com.Pablo.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("C:\\Users\\Daw2223\\Documents");
		Visitador v = new Visitador ();
		
		Files.walkFileTree(path, v);

	}
	
	
}
