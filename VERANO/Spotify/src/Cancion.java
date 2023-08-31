

	public class Cancion implements Comparable<Cancion>{

		private String titulo;
		private String autor;
		private String usuario;
		
		public Cancion(String titulo, String autor, String usuario) {
			super();
			this.titulo = titulo;
			this.autor = autor;
			this.usuario = usuario;
		}
		
		public Cancion() {
			super();
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

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		@Override
		public int compareTo(Cancion o) {
			// TODO Auto-generated method stub
			return this.getTitulo().compareTo(o.titulo);
		}

		@Override
		public String toString() {
			return "CancionDTO [titulo=" + titulo + ", autor=" + autor + ", usuario=" + usuario + "]";
		}
		
		
	}


