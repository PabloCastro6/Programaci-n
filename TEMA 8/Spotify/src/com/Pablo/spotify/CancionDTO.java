package com.Pablo.spotify;

public class CancionDTO implements Comparable<CancionDTO>{
	
	private String titulo;
	private String autor;
	private String usuario;
	public CancionDTO(String titulo, String autor, String usuario) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.usuario = usuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuariO(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public int compareTo(CancionDTO o) {
		return this.getUsuario().compareTo(o.getUsuario());
		
	}
	@Override
	public String toString() {
		return "CancionDTO [titulo=" + titulo + ", autor=" + autor + ", usuario=" + usuario + "]";
	}
	
	
	

}
