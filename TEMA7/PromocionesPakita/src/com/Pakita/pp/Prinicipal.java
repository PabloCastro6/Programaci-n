package com.Pakita.pp;

public class Prinicipal {
	
	public static void main (String[] args) {
		
		String mensaje = "camisas a 9,99, señoraaaaaa";
		Notificaciones n1 = new Notificaciones("Jonan", "eljoana@gmail.com", mensaje);
		Notificaciones n2 = new Notificaciones("Jessy", "jessy@gmail.com", mensaje);
		Notificaciones n3 = new Notificaciones("Jassan", "elJassanDeGarrido@gmail.com", mensaje);
		Notificaciones n4 = new Notificaciones("kike", "elkikeprogragamador@gmail.com", mensaje);
		
		Notificaciones[][] arrayNotificaciones = [n1,n2,n3,n4];
		
		NotificacionesServicios Ns = new NotificacionesServicios();
		
	}

}
