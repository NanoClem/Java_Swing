import java.util.*;
import java.lang.Math;
//import Complex;

public class Mandelbrot
{
  Vector<Integer> pts_x;            // stockage des points qui
  Vector<Integer> pts_y;            // devront être dessinés


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
<<<<<<< HEAD
=======
    z_r = 0;    z_i = 0;
>>>>>>> fec131252e2a434ffec2df654a2e0377803d67b7

    for(int x = 0; x < img_x; x++)
      for(int y = 0; y < img_y; y++)
      {
        c_r = (double) x / zoom_x + xmin;
        c_i = (double) y / zoom_y + ymin;
<<<<<<< HEAD
		z_r = 0;    z_i = 0;
        int i = 0;

        do
        {
          double tmp = z_r;
          z_r  = (z_r*z_r - z_i * z_i) + c_r;
          z_i  = 2 * z_i * tmp + c_i;
          i    = i + 1;
        }while( (z_r * z_r + z_i * z_i) < 4  &&  i < n );
=======
        int i = 0;

        while( Math.pow(z_r, z_r) + Math.pow(z_i, z_i) < 4  &&  i == n )
        {
          double tmp = z_r;
          z_r  = Math.pow(z_r, z_r) - Math.pow(z_i, z_i) + c_r;
          z_i  = 2 * z_i * tmp + c_i;
          i   += 1;
        }
>>>>>>> fec131252e2a434ffec2df654a2e0377803d67b7

        if(i == n)
        {
          pts_x.addElement(x);
          System.out.println("x se rempli");
          pts_y.addElement(y);
          System.out.println("y se rempli");
        }
      }
  }
}
