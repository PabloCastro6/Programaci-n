package com.Pablo.app.dto;

public class Persona {
		private String dni;
		private String Nombre;
		private String Apellido;
		
		
		public Persona() {
			super();
		}


		public Persona(String dni, String nombre, String apellido) {
			super();
			this.dni = dni;
			Nombre = nombre;
			Apellido = apellido;
		}


		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public String getNombre() {
			return Nombre;
		}


		public void setNombre(String nombre) {
			Nombre = nombre;
		}


		public String getApellido() {
			return Apellido;
		}


		public void setApellido(String apellido) {
			Apellido = apellido;
		}

	

}
