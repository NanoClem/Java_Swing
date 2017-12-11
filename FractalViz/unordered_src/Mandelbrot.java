import java.lang.Math;
import Complex;

public class Mandelbrot
{
  int img_x     = 270;    // Valeurs par défaut de la taille de
  int img_y     = 240;    // la zone de dessin (ou de l'image)
  int[] pts_x;            // stockage des points qui
  int[] pts_y;            // devront être dessinés


  public Mandelbrot(int img_x, int img_y, int iteration)
  {
    this.img_x     = img_x;
    this.img_y     = img_y;
    this.pts_x     = new int[img_x];
    this.pts_y     = new int[img_y];
  }


  public void calcPts(int xmin, int xmax, int ymin, int ymax, int n)
  {
    double zoom_x             = img_x / (xmax-xmin);
    double zoom_y             = img_y / (ymax-ymin);
    double c_r, c_i, z_r, z_i = 0;


    for(int x = 0; x < img_x; x++)
      for(int y = 0; y < img_y; y++)
      {
        c_r = x / zoom_x + xmin;
        c_i = y / zoom_y + ymin;
        int i = 0;

        while( Math.pow(z_r, z_r) + Math.pow(z_i, z_i) < 4  &&  i < n )
        {
          double tmp = z_r;
          z_r  = Math.pow(z_r, z_r) - Math.pow(z_i, z_i) + c_r;
          z_i  = 2 * z_i * tmp + c_i;
          i   += 1;
        }

        if(i == n)
        {
          pts_x[] = x;  //mettre l'indice
          pts_y[] = y;  //mettre l'indice 
        }
      }
  }
}
