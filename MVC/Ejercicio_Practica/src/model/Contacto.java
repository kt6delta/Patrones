package model;

public class Contacto {

	private String nombre;
	private int edad;
	
	public Contacto() {
		nombre = "";
		edad = 0;		
	}
	
	public Contacto(String n, int e) {
		nombre = n;
		edad = e;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nEdad: " + edad + "\n";
	}
	
	
}
