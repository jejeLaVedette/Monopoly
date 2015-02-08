package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Fenetre extends JFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int tailleFx = 1000;
	private static int tailleFy = 850;
	private JMenuItem offLine;
	private JMenuItem onLine;
	private JMenuItem returnMenu;
	private JSplitPane split;
	private Carte carte;

	/**
	 * Definition des zones qui separe l ecran
	 */
	JPanel zone_gauche = new JPanel();
	JPanel zone_droite = new JPanel();


	public Fenetre(){                
		// TODO Auto-generated method stub

		//Définit un titre pour notre fenêtre
		try {
			this.setTitle(InetAddress.getLocalHost()+"- Monopoly");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setSize(tailleFx, tailleFy);

		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//modifie le logo en haut a gauche
		Image icone = new ImageIcon("libs/Logo.jpg").getImage();
		setIconImage(icone);


		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu();
		JMenu menu2 = new JMenu();
		offLine = new JMenuItem();
		onLine = new JMenuItem();
		returnMenu = new JMenuItem();

		menu.setText("Jeu");
		menu2.setText("Options");
		offLine.setText("Mode hors ligne");
		onLine.setText("Mode en ligne");
		returnMenu.setText("Retour au menu");


		// affecter le raccourci alt+M
		menu.setMnemonic(KeyEvent.VK_J);
		menu2.setMnemonic(KeyEvent.VK_O);
		returnMenu.setMnemonic(KeyEvent.VK_R);


		//on ajoute les sous menus au menu
		menu.add(offLine);
		menu.add(onLine);
		menu.add(returnMenu);

		//on ajoute le menu a la barmenu
		mb.add(menu);
		mb.add(menu2);

		onLine.addActionListener(this);
		offLine.addActionListener(this);
		returnMenu.addActionListener(this);

		this.setJMenuBar(mb);

		//this.setLayout(new BorderLayout());
		
		carte = new Carte("libs/menuIntro.jpg");
		
		zone_gauche.setLayout(new BorderLayout());
		zone_droite.setLayout(new BorderLayout());
		
		zone_gauche.add(carte);
		zone_gauche.setMinimumSize(new Dimension(800,tailleFy));
		//zone_droite.add(new JButton("test"));
		zone_droite.setMinimumSize(new Dimension(150,tailleFy));



		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		this.getContentPane().add(split, BorderLayout.CENTER);

		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==offLine){
			zone_gauche.remove(carte);
			carte = new Carte("libs/monopoly.jpg");
			zone_gauche.add(carte);
			this.setVisible(true);
		} else if(arg0.getSource()==onLine){
			JOptionPane.showMessageDialog(null, "Fonctionnalitée non implémenté\nDon't be pressed please... <3\n _@/'");
		} else if(arg0.getSource()==returnMenu){
			zone_gauche.remove(carte);
			carte = new Carte("libs/menuIntro.jpg");
			zone_gauche.add(carte);
			this.setVisible(true);
		}

	}     
}