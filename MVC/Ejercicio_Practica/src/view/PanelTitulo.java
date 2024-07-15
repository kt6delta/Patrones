package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitulo extends JPanel{

	private JLabel titulo;
	
	public PanelTitulo() {
		setLayout(new FlowLayout());
		inicializarComponentes();
		setBackground(new Color(241, 243,123));
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		titulo = new JLabel("PROGRAMA QUE PERMITE MOSTRAR LA INFORMACIÓN DE UN CONTACTO");
		Font letra = new Font("arial", Font.BOLD, 14);
		titulo.setFont(letra);
		add(titulo);
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	
}
