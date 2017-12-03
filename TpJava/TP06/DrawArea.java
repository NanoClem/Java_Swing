import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class DrawArea extends JPanel {

  Image img;


  public DrawArea(String pic_name)
  {
    setPreferredSize(new Dimension(300,300) );

    try {
      img = ImageIO.read(new File(pic_name));
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }


  public void paint(Graphics g)
  {
    print_background(g);
    //print_graduation(g);
    //print_clockHand(g);
  }


  public void print_background(Graphics g)
  {
    int x1 = 25;   int y1 = 25;
    int x2 = 26;   int y2 = 26;
    int w1 = 226;  int h1 = 226;
    int w2 = 224;  int h2 = 224;
    Color color = new Color(200,255,70);

    g.drawOval(x1, y1, w1, h1);
    g.setColor(color);
    g.fillOval(x2, y2, w2, h2);
    g.drawImage(img, x2*2, y2*2, null);
  }


  // public void print_graduation(Graphics g)
  // {
  //
  // }











}
