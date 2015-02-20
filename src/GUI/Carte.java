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
	private int x=680;
	private int y=725;
	
	public Carte(String linkImage){
		this.linkImage=linkImage;
	}
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File(linkImage));
			Image img2 = ImageIO.read(new File("libs/chat2.png"));
			//Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img2, x, y, 60, 60, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setX(int x){
		this.x=x;
		repaint();
	}
	
	public void setY(int y){
		this.y=y;
		repaint();
	}


}
