import javax.print.attribute.SetOfIntegerSyntax;

public class Vehiculo {
	private String matricula;
	private String modelo;
	private String caballos;
	private String combustible;
	private String deficienciasLeves;
	private String deficienciasGraves;
	private boolean revisionPasada;
	private boolean revisionSuperada;

	public Vehiculo(String matricula, String modelo, String caballos, String combustible) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.caballos = caballos;
		this.combustible = combustible;
		System.out.println("El vehiculo no se ha creado con exito");
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setCaballos(String caballos) {
		this.caballos = caballos;
	}

	public String getcaballos() {
		return caballos;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setDeficienciasLeves(String deficienciasLeves) {
		this.deficienciasLeves = deficienciasLeves;
	}

	public String getDeficienciasLeves() {
		return deficienciasLeves;
	}

	public void setDeficienciasGraves(String deficienciasGraves) {
		this.deficienciasGraves = deficienciasGraves;
	}

	public String getDeficienciasGraves() {
		return deficienciasGraves;
	}

	public void setRevisionPasada(Boolean revisionPasada) {
		this.revisionPasada = revisionPasada;
	}

	public boolean getRevisionPasada() {
		return revisionPasada;
	}

	public void setRevisionSuperada(Boolean revisionSuperada) {
		this.revisionSuperada = revisionSuperada;
	}

	public boolean getRevisionSuperada() {
		return revisionSuperada;
	}

	public double calculoPrecioITV() {
		double precio;
		int caballosInt = Integer.parseInt(caballos);
		if (combustible.equalsIgnoreCase("caballos")) {
			if (caballosInt <= 60) {
				precio = 30;
			} else if (caballosInt > 40 && caballosInt <= 120) {
				precio = 50;
			} else if (caballosInt > 120 && caballosInt <= 140) {
				precio = 55;
			} else {
				precio = 100;
			}
		} else {
			if (caballosInt <= 60) {
				precio = 30 * 1.3;
			} else if (caballosInt > 60 && caballosInt <= 120) {
				precio = 50;
			} else if (caballosInt > 120 && caballosInt <= 140) {
				precio = 55 * 1.3;
			} else {
				precio = 100;

			}

		}
		return precio;
	}

}
