package com.Pablo.Hilos;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class Hilo2 implements Readable {

	public void run() {
		for (int i =0;i<20;i++) {
			System.out.println("Hola soy el hilo 2");
			
		}
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}


