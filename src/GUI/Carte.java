package GUI;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Carte extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String linkImage;
	
	public Carte(String linkImage){
		this.linkImage=linkImage;
	}
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File(linkImage));
			Image img2 = ImageIO.read(new File("libs/dees1.jpg"));
			//Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img2, 680, 725, 40, 40, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
