// For compilation add "-classpath /Full_path/FractalViz/src"

import packages.component.TestButton;
import java.awt.*;
import javax.swing.*;


public class Main
{
  public static void main(String[] args)
  {
    JFrame window = new JFrame("FractalViz");

    window.setLocationRelativeTo(null);                         // put the window in center of the physical screen
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // end the program on closing
    window.setResizable(false);                                 // resize the window is forbidden
    window.setSize(400,300);

    // Container paneContent = window.getContentPane();
    // TestButton myButton = new TestButton("Test button");
    // paneContent.add(myButton);

    window.setVisible(true);
  }
}
