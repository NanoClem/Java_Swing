import javax.swing.*;


public class GraphicWindow extends JFrame {

  DrawArea draw_area;

  public GraphicWindow(String s)
  {
    super(s);
    setSize(300,300);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setAlwaysOnTop(true);

    draw_area = new DrawArea("tux.png");
    setContentPane(draw_area);
    pack();

    setVisible(true);
  }
}
