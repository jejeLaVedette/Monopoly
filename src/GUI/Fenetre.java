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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Elements.MatriceMap;
import Elements.Player;

public class Fenetre extends JFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int tailleFx = 1000;
	public static int tailleFy = 850;
	public static int tailleZoneGauche = 750;
	public static int tailleZoneDroite = 230;
	
	private JMenuItem offLine;
	private JMenuItem onLine;
	private JMenuItem returnMenu;
	
	private JSplitPane split;
	
	private Carte carte;
	
	private ResizePicture dee1;
	private ResizePicture dee2;
	
	private JLabel text1;
	private JLabel infoJoueur1;
	private JLabel infoJoueur2;
	private JLabel argentJoueur1;
	private JLabel argentJoueur2;
	
	private JButton dees;
	
//	private int espacement = 20;

	/**
	 * Definition des zones qui separe l ecran
	 */
	JPanel zone_gauche = new JPanel();
	JPanel zone_droite = new JPanel();
	JPanel zone_textePlayer = new JPanel();
	JPanel zone_dees = new JPanel();
	JPanel zone_hori_dees = new JPanel();
	JPanel zone_info_j1 = new JPanel();
	JPanel zone_info_j2 = new JPanel();
	


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
		
		/**
		 * texte de la partie de droite
		 */
		
		
//		Component verticalStrut_1 = Box.createVerticalStrut(espacement);
//		Component verticalStrut_2 = Box.createVerticalStrut(espacement/2);
		
		text1 = new JLabel("Au tour du player X");
		infoJoueur1 = new JLabel("Informations sur le joueur 1 :");
		infoJoueur2 = new JLabel("Informations sur le joueur 2 :");
		argentJoueur1 = new JLabel("Argent Joueur 1 :"); 
		argentJoueur2 = new JLabel("Argent Joueur 2 :"); 
		
		dees = new JButton("Shake");
		dees.setMaximumSize(new Dimension(30,30));
		
		zone_textePlayer.setLayout(new BoxLayout(zone_textePlayer, BoxLayout.PAGE_AXIS));
		zone_textePlayer.add(text1);
		zone_textePlayer.add(Box.createRigidArea(new Dimension(0,15)));
		
		zone_hori_dees.setLayout(new BoxLayout(zone_hori_dees, BoxLayout.LINE_AXIS));
		zone_dees.add(dees);
		zone_hori_dees.add(zone_dees);
		dee1 = new ResizePicture("libs/dees1.jpg", 30, 30);
		zone_hori_dees.add(dee1);
		dee2 = new ResizePicture("libs/dees6.jpg", 30, 30);
		zone_hori_dees.add(dee2);
		zone_hori_dees.add(Box.createRigidArea(new Dimension(0,15)));
		
		zone_info_j1.setLayout(new BoxLayout(zone_info_j1, BoxLayout.PAGE_AXIS));
		zone_info_j1.add(infoJoueur1);
		zone_info_j1.add(argentJoueur1);
		zone_info_j1.add(Box.createRigidArea(new Dimension(0,15)));

		
		zone_info_j2.setLayout(new BoxLayout(zone_info_j2, BoxLayout.PAGE_AXIS));
		zone_info_j2.add(infoJoueur2);
		zone_info_j2.add(argentJoueur2);
		zone_info_j2.add(Box.createRigidArea(new Dimension(0,15)));


		//on place tout sur la zone de droite
		zone_droite.setLayout(new BoxLayout(zone_droite, BoxLayout.PAGE_AXIS));
		zone_droite.add(zone_textePlayer);
		zone_droite.add(zone_hori_dees);
		zone_droite.add(zone_info_j1);
		zone_droite.add(zone_info_j2);
		

		zone_gauche.add(carte);
		
		zone_gauche.setMinimumSize(new Dimension(tailleZoneGauche,tailleFy));
		zone_droite.setMinimumSize(new Dimension(tailleZoneDroite,tailleFy));



		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		this.getContentPane().add(split, BorderLayout.CENTER);

		this.setVisible(true);
		
		
		new MatriceMap();
		new Player(1);
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