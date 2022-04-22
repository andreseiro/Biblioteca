package models;

public class Libro {
	private String nombreLibro;
	private TipoLibro tipo;
	private String editorial;
	private Autor autorLibro;
	
	public Libro(String nombreLibro, TipoLibro tipo, String editorial, Autor autorLibro) {
		super();
		this.nombreLibro = nombreLibro;
		this.tipo = tipo;
		this.editorial = editorial;
		this.autorLibro = autorLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public TipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Autor getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(Autor autorLibro) {
		this.autorLibro = autorLibro;
	}
	
	
	
}
