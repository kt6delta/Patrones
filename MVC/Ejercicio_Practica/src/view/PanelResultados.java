package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel{
	
	private JLabel foto;
	private JLabel nombre;
	private JLabel edad;
	
	
	public PanelResultados() {
		setLayout(new GridLayout(1,2,5,5));
		setBorder( new TitledBorder( "Información" ) ) ;
		inicializarComponentes();
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	void inicializarComponentes() {
		
		JPanel aux1 = new JPanel();
		aux1.setLayout(new FlowLayout());
		foto = new JLabel();
		aux1.add(foto);
		add(aux1);
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(2, 1, 3, 3));
		
		nombre = new JLabel("Nombre: ");
		aux2.add(nombre);
		
		edad = new JLabel("Edad: ");
		aux2.add(edad);
		add(aux2);
		
	}
	
	public void cambiarImagen(String nom) {
		ImageIcon im = new ImageIcon(getClass().getResource("/imagenes/"+nom+".jpg"));
		ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(this.getWidth()-20, this.getHeight()-20, Image.SCALE_DEFAULT));
		foto.setIcon(icono);
	}

	public JLabel getFoto() {
		return foto;
	}

	public void setFoto(JLabel foto) {
		this.foto = foto;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

}
