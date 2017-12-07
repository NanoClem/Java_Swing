import java.awt.*;
import javax.swing.*;

abstract class Forme
{
  protected Color color;               // Couleur de la forme

  Forme(Color c)
  {color = c;}

  abstract void Print(Graphics g);     // Afficher la forme
}
