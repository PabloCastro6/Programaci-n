package com.Pablo.Hilos;

import java.io.IOException;
import java.nio.CharBuffer;

public class Hilo1 implements Readable {

	public void run() {
		for (int i =0; i < 10; i++) {
			System.out.println("Hola soy el hilo");
			
		}
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
}


