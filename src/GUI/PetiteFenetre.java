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
 
		build();//On initialise notre fen�tre
	}
 
	private void build(){
		setTitle("Fonctionnalit�e non impl�ment�"); //On donne un titre � l'application
		setSize(200,100); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
		setResizable(false); //On interdit la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
		setVisible(true);
	}
 
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
 
		JLabel label = new JLabel("Fonctionnalit�e non impl�ment�");
 
		panel.add(label);
 
		return panel;
	}
  
}