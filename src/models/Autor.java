package models;

public class Autor extends Persona{
	private String nacionalidad;
	private String fechaNacimiento;

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String toString() {
		return this.getNombre();
	}
	
}
