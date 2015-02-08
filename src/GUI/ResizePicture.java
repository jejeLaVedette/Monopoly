package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ResizePicture extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String linkImage;
	private int taillex;
	private int tailley;
	
	public ResizePicture(String linkPicture, int taillex, int tailley){
		this.linkImage=linkPicture;
		this.taillex=taillex;
		this.tailley=tailley;
	}

	public void paintComponent(Graphics g){
		try {
			BufferedImage img = ImageIO.read(new File(linkImage));
			//Pour une image de fond
			g.drawImage(img, 0, 0, this.taillex, this.tailley, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
