package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame{

	private PanelTitulo p1;
	private PanelResultados p3;
	
	private JMenuBar menubar;
	private JMenu menu;
	private JMenu contactos;
	private JMenuItem buscar;
	private JMenuItem salir;
	
	
	public Ventana() {
		setTitle("Programa Directorio");
		setSize(600, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(new BorderLayout(5,5));

		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		p1 = new PanelTitulo();
		getContentPane().add(p1 , BorderLayout.NORTH);
		
		p3 = new PanelResultados();
		getContentPane().add(p3, BorderLayout.CENTER);
		
		menubar = new JMenuBar();
		menubar.setBackground(Color.green);
		setJMenuBar(menubar);
		
		menu = new JMenu("Opciones");
		menubar.add(menu);
		
		contactos = new JMenu("Contactos");
		menu.add(contactos);
		
		buscar = new JMenuItem("Buscar");
		buscar.setActionCommand("BUSCAR");
		contactos.add(buscar);
		
		salir = new JMenuItem("Salir");
		salir.setActionCommand("SALIR");
		menu.add(salir);
		
	}

	public PanelTitulo getP1() {
		return p1;
	}

	public void setP1(PanelTitulo p1) {
		this.p1 = p1;
	}

	public PanelResultados getP3() {
		return p3;
	}

	public void setP3(PanelResultados p3) {
		this.p3 = p3;
	}

	public JMenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenu getContactos() {
		return contactos;
	}

	public void setContactos(JMenu contactos) {
		this.contactos = contactos;
	}

	public JMenuItem getBuscar() {
		return buscar;
	}

	public void setBuscar(JMenuItem buscar) {
		this.buscar = buscar;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}
	
}
