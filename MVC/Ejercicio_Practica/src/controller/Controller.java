package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Contacto;
import model.Directorio;
import view.Ventana;

public class Controller implements ActionListener{

	private Ventana ventana;
	private Directorio directorio;
	
	public Controller() {
		directorio = new Directorio();
		ventana = new Ventana();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		ventana.getBuscar().addActionListener(this);
		ventana.getSalir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("BUSCAR")) {
			String nom = JOptionPane.showInputDialog(null, "Digite nombre de la persona a buscar: ", "Buscar contacto", JOptionPane.QUESTION_MESSAGE );
			nom = nom.toLowerCase();
			Contacto aux = new Contacto();
			for(int i = 0; i<directorio.getListado().size();i++) {
				if(nom.equals(directorio.getListado().get(i).getNombre())) {
					aux = directorio.getListado().get(i);
				}
			}
			ventana.getP3().getNombre().setText("Nombre: "+ aux.getNombre());
			
			ventana.getP3().getEdad().setText("Edad: "+aux.getEdad());
			ventana.getP3().cambiarImagen(aux.getNombre());
			
		}else if (comando.equals("SALIR")) {
			JOptionPane.showMessageDialog(null, "Hasta pronto",	"Salir", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
}
