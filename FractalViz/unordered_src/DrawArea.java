import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class DrawArea extends JPanel
{
  private BufferedImage img;

  public DrawArea(BufferedImage myFract)
  {
    setPreferredSize(new Dimension(690, 640) );
    img = new BufferedImage(myFract.getWidth(), myFract.getHeight(), BufferedImage.TYPE_INT_RGB );
    setImg(myFract);
  }


  public void setImg(BufferedImage new_img)
  {
    img = new_img;
  }


  public BufferedImage getImg()
  {
    return img;
  }


  public void paint(Graphics g)
  {
	  g.drawImage(getImg(), 0, 0, this);
  }

  // METHODE APPELEE POUR REDESSINER LE CONTENU
  public void repaint(Graphics g)
  {
    paint(g);
  }
}
