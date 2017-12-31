package packages.component.calculation;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.Math;


public class Mandelbrot
{
  private Vector<Integer> pts_x;            // stockage des points
  private Vector<Integer> pts_y;            // appartenant à l'ensemble de Mandelbrot

  private Vector<Integer> pts_out_x;        // sotckage des points
  private Vector<Integer> pts_out_y;        // n'appartenant pas à l'ensemble (pour le dessin en couleur)

  private Vector<Color> pts_out_color;



  public Mandelbrot(int img_x, int img_y, int iteration, int r, int g, int b)
  {
    this.pts_x         = new Vector<Integer>(img_x);
    this.pts_y         = new Vector<Integer>(img_y);
    this.pts_out_x     = new Vector<Integer>();        // on ne connait pas à l'avance
    this.pts_out_y     = new Vector<Integer>();        // les points n'appartenant pas à l'ensemble
    this.pts_out_color = new Vector<Color>();
    double xmin        = -2.1;
    double xmax        = 0.6;
    double ymin        = -1.2;
    double ymax        = 1.2;

    calcPts(img_x, img_y, xmin, xmax, ymin, ymax, iteration, r, g, b);
  }


 // CALCUL ET STOCKAGE :
 // - des points appartenant à l'ensemble de Mandelbrot
 // - des points n'appartenant pas à l'ensemble
 // - de la couleur des pixels représentés par chaque point en dehors de l'ensemble
  public void calcPts(int img_x, int img_y, double xmin, double xmax, double ymin, double ymax, int n, int r, int g, int b)
  {
    double zoom_x = (double) img_x / (xmax-xmin);
    double zoom_y = (double) img_y / (ymax-ymin);
    double c_r = 0;
	double c_i = 0;
    double z_r, z_i;

    for(int x = 0; x < img_x; x++)
      for(int y = 0; y < img_y; y++)
      {
        c_r = (double) x / zoom_x + xmin;
        c_i = (double) y / zoom_y + ymin;
		    z_r = z_i = 0;
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
          pts_y.addElement(y);
        }
        else          // on stocke les points hors de l'ensemble ainsi que la couleur du pixel
        {
          pts_out_x.addElement(x);
          pts_out_y.addElement(y);

          Color myColor = new Color(i*r/n, i*g/n, i*b/n);   // la couleur est déterminée en fonction du nombre d'itération pour y parvenir
          pts_out_color.addElement(myColor);
        }
      }
  }


  // DESSIN DE LA FRACTALE EN NOIR ET BLANC SUR UNE IMAGE
  // on dessine un pixel en noir si ses coordonnées appartiennent à l'ensemble
  // le reste est en blanc
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


  // DESSIN DE LA FRACTALE EN NOIR AVEC UN DEGRADE DE COULEUR
  // on dessine un pixel en noir si ses coordonnées appartiennent à l'ensemble
  // le reste forme un dégradé de couleur (choisies par l'utilisateur)
  public BufferedImage draw_Color(int width, int height)
  {
    BufferedImage Color_fractal = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics gr = Color_fractal.getGraphics();
    gr.setColor(Color.white);                // Couleur de fond
    gr.fillRect(0, 0, width, height);        // On dessine le fond

    for(int coords = 0; coords < pts_x.size(); coords++)
      Color_fractal.setRGB(pts_x.elementAt(coords), pts_y.elementAt(coords), 00);

    for(int outCoord = 0; outCoord < pts_out_x.size(); outCoord++)
      {
        int rgb = pts_out_color.elementAt(outCoord).getRGB();
        Color_fractal.setRGB(pts_out_x.elementAt(outCoord), pts_out_y.elementAt(outCoord), rgb);
      }

    return Color_fractal;
  }
}
