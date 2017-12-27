import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class DrawArea extends JPanel {

  Vector<Integer> xtest;
  Vector<Integer> ytest;

  public DrawArea(String pic_name, Vector<Integer> x, Vector<Integer> y)
  {
    setPreferredSize(new Dimension(300,300) );
	
	Vector<Integer> xtest= new Vector<Integer>(x.size());
    Vector<Integer> ytest= new Vector<Integer>(y.size());
	
	xtest = x;
	ytest = y;

  }


  public void paint(Graphics g)
  {
    Image img = print_fract();
	g.drawImage(img, 0, 0, this);
  }
	
  public Image print_fract()
  {
	BufferedImage fractal= new BufferedImage(270, 240, BufferedImage.TYPE_INT_RGB);
	Graphics g = fractal.getGraphics();
	
	for (int i = 0 ; i<xtest.size() ; i++)
		for (int j = 0 ; j<ytest.size() ; j++)
		{
			g.drawLine(xtest.elementAt(i), ytest.elementAt(j), xtest.elementAt(i), ytest.elementAt(j)+1);
		}
		
	return fractal;
  }










}
