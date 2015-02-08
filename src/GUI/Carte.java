package GUI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
			BufferedImage img = ImageIO.read(new File(linkImage));
			//Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
