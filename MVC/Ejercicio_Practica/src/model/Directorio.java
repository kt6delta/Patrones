package model;

import java.util.ArrayList;

public class Directorio {

	private ArrayList<Contacto> listado;
	
	public Directorio() {
		listado = new ArrayList<Contacto>();
		
		Contacto aux = new Contacto("daniel vega", 20);
		listado.add(aux);
		
		aux = new Contacto("angie lozano", 19);
		listado.add(aux);
		
		aux = new Contacto("juan cuervo", 19);
		listado.add(aux);
	}

	public ArrayList<Contacto> getListado() {
		return listado;
	}

	public void setListado(ArrayList<Contacto> listado) {
		this.listado = listado;
	}
	
}
