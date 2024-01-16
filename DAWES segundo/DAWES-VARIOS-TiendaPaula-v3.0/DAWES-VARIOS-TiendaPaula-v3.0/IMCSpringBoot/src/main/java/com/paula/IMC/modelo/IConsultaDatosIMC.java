package com.paula.IMC.modelo;

import java.io.IOException;

public interface IConsultaDatosIMC {

	public Integer[] consultaPesoAltura(String nombre) throws IOException;
}
