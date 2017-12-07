import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Cercle extends Forme
{
  int x, y, rayon;    // position du centre et rayon

  public Cercle(int rx, int ry, int _rayon, Color c)
  {
    super(c);
    x = rx;
    y = ry;
    rayon = _rayon;
  }

  public void Print(Graphics g)
  {
    g.setColor(color);
    g.fillOval(x-rayon, y-rayon, 2*rayon, 2*rayon);
  }
}
