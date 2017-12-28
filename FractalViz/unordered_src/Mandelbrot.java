import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.Math;
//import Complex;

public class Mandelbrot
{
  private Vector<Integer> pts_x;            // stockage des points
  private Vector<Integer> pts_y;            // appartenant à l'ensemble de Mandelbrot

  private Vector<Integer> pts_out_x;        // sotckage des points
  private Vector<Integer> pts_out_y;        // n'appartenant pas à l'ensemble (pour le dessin en couleur)


  public Mandelbrot(int img_x, int img_y, int iteration)
  {
    this.pts_x      = new Vector<Integer>(img_x);
    this.pts_y      = new Vector<Integer>(img_y);
    this.pts_out_x  = new Vector<Integer>();        // on ne connait pas à l'avance
    this.pts_out_y  = new Vector<Integer>();        // les points n'appartenant pas à l'ensemble
    double xmin     = -2.1;
    double xmax     = 0.6;
    double ymin     = -1.2;
    double ymax     = 1.2;

    calcPts(img_x, img_y, xmin, xmax, ymin, ymax, iteration);
    //System.out.println( pts_x.size() + " " + pts_x.isEmpty() );
  }


  public Vector<Integer> getPts_x()
  {return pts_x;}

  public Vector<Integer> getPts_y()
  {return pts_y;}

  public Vector<Integer> getPts_out_x()
  {return pts_out_x;}

  public Vector<Integer> getPts_out_y()
  {return pts_out_y;}



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

        if(i == n)    // on stocke les points dans l'ensemble
        {
          pts_x.addElement(x);
          //System.out.println("x se rempli");
          pts_y.addElement(y);
          //System.out.println("y se rempli");
        }
        else          // on stocke les points hors de l'ensemble
        {
          pts_out_x.addElement(x);
          pts_out_y.addElement(y);
        }
      }
  }



  public BufferedImage draw_WB(int width, int height)
  {
    BufferedImage WB_fractal = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = WB_fractal.getGraphics();
    g.setColor(Color.white);                // Couleur de fond
    g.fillRect(0, 0, width, height);        // On dessine le fond

    for(int coords = 0; coords < pts_x.size(); coords++)
      WB_fractal.setRGB(pts_x.elementAt(coords), pts_y.elementAt(coords), 00);

    return WB_fractal;
  }



  public BufferedImage draw_Color(int width, int height, int r, int g, int b)
  {
    BufferedImage Color_fractal = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = Color_fractal.getGraphics();
    g.setColor(Color.white);                // Couleur de fond
    g.fillRect(0, 0, width, height);        // On dessine le fond

    for(int coords = 0; coords < pts_x.size(); coords++)
      Color_fractal.setRGB(pts_x.elementAt(coords), pts_y.elementAt(coords), 00);

    for(int outCoord = 0; outCoord < pts_out_x.size(); outCoord++)
    {
      
      Color_fractal.setRGB(pts_out_x.elementAt(outCoord), pts_out_y.elementAt(outCoord), 255);
    }

    return Color_fractal;
  }
}
