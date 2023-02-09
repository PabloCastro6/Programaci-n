
public class Libro {
	private String titulo;
	private String autor;
	private int numEjemplares;
	private int numEjemplaresPrestados;
	
	public Libro(String titulo, String autor, int numEjemplares, int numEjemplaresPrestados) {
		this.titulo = titulo;
		this.autor = autor;
		this.numEjemplares = numEjemplares;
		this.numEjemplaresPrestados = numEjemplaresPrestados;
	}
	public Libro() {}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getNumEjemplares() {
		return numEjemplares;
	}
	public int getNumEjemplaresPrestados() {
		return numEjemplaresPrestados;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setNumEjemplares(int numEjemplares){
		this.numEjemplares = numEjemplares;
	}
	public void setNumEjemplaresPrestados(int numEjemplaresPrestados) {
		this.numEjemplaresPrestados = numEjemplaresPrestados;
	}
	
	public boolean prestamo() {
		numEjemplaresPrestados = 0;
		if(numEjemplaresPrestados < numEjemplares) {
			numEjemplaresPrestados += 1;
			numEjemplares -= 1;
			return true;
		}
		else {
			System.out.println("No hay más ejemplares para prestar.");
			return false;
		}
	}
	public boolean devolucion(){
		if(numEjemplaresPrestados > 0) {
			numEjemplaresPrestados -= 1;
			numEjemplares += 1;
			return true;
		}
		else {
			System.out.println("Hay todos ejemplares de libro.");
			return false;
		}
	}
	public void toString(Libro libro) {
		System.out.println("El título del libro: " + titulo);
		System.out.println("El autor del libro: " + autor);
		System.out.println("Número de ejemplares del libro: " + numEjemplares);
		System.out.println("Número de ejemplares prestados: " + numEjemplaresPrestados);
	}
}
