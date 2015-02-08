package GUI;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class PetiteFenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetiteFenetre(){
		super();
 
		build();//On initialise notre fenêtre
	}
 
	private void build(){
		setTitle("Fonctionnalitée non implémenté"); //On donne un titre à l'application
		setSize(200,100); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
		setVisible(true);
	}
 
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
 
		JLabel label = new JLabel("Fonctionnalitée non implémenté");
 
		panel.add(label);
 
		return panel;
	}
  
}