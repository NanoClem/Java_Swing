import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.Math;
//import Complex;

public class Mandelbrot
{
  private Vector<Integer> pts_x;            // stockage des points qui
  private Vector<Integer> pts_y;            // devront être dessinés


  public Mandelbrot(int img_x, int img_y, int iteration)
  {
    this.pts_x      = new Vector<Integer>(img_x);
    this.pts_y      = new Vector<Integer>(img_y);
    double xmin     = -2.1;
    double xmax     = 0.6;
    double ymin     = -1.2;
    double ymax     = 1.2;

    calcPts(img_x, img_y, xmin, xmax, ymin, ymax, iteration);
    System.out.println( pts_x.size() + " " + pts_x.isEmpty() );
  }


  public Vector<Integer> getPts_x()
  {return pts_x;}

  public Vector<Integer> getPts_y()
  {return pts_y;}



  public void calcPts(int img_x, int img_y, double xmin, double xmax, double ymin, double ymax, int n)
  {
    double zoom_x             = (double) img_x / (xmax-xmin);
    double zoom_y             = (double) img_y / (ymax-ymin);
    double c_r, c_i, z_r, z_i;
    c_r = 0;    c_i = 0;

    for(int x = 0; x < img_x; x++)
      for(int y = 0; y < img_y; y++)
      {
        c_r = (double) x / zoom_x + xmin;
        c_i = (double) y / zoom_y + ymin;
		    z_r = 0;    z_i = 0;
        int i = 0;

        do
        {
          double tmp = z_r;
          z_r  = (z_r*z_r - z_i * z_i) + c_r;
          z_i  = 2 * z_i * tmp + c_i;
          i    = i + 1;
        }
        while( (z_r * z_r + z_i * z_i) < 4  &&  i < n );

        if(i == n)
        {
          pts_x.addElement(x);
          //System.out.println("x se rempli");
          pts_y.addElement(y);
          //System.out.println("y se rempli");
        }
      }
  }



  public BufferedImage draw_WB(int width, int height)
  {
    BufferedImage WB_fractal = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = WB_fractal.getGraphics();
    g.setColor(Color.white);
    g.fillRect(0, 0, width, height);

    for(int coords = 0; coords < pts_x.size(); coords++)
      WB_fractal.setRGB(pts_x.elementAt(coords), pts_y.elementAt(coords), 00);

    return WB_fractal;
  }
}
