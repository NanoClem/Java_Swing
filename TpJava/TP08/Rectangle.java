import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Rectangle extends Forme
{
  int x1, y1, x2, y2;     // Point supérieur gauche (x1;y1) et inférieur droit (x2;y2)


  public Rectangle(int xa, int xb, int ya, int yb, Color c)
  {
    super(c);
    x1 = xa;  x2 = xb;
    y1 = ya;  y2 = yb;
  }

  public void Print(Graphics g)
  {
    g.setColor(color);
    g.fillRect(x1, y1, x2, x2);
  }

  public void printParam()
  {
    System.out.println(color);
  }
}
