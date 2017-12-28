import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class DrawArea extends JPanel
{
  private BufferedImage img;

  public DrawArea(BufferedImage myFract)
  {
    setPreferredSize(new Dimension(300,300) );
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
    //BufferedImage drawImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB );
	  g.drawImage(img, 0, 0, this);
  }
}
