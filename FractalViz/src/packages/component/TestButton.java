// Do not forgot to make public function
// if you want to use them outside of the package

package packages.component;
import java.awt.*;
import java.awt.event.*;


public class TestButton extends Frame
                        implements ActionListener
{
  Button button;


  public TestButton(String s)
  {
    super(s);
    setSize(320,200);
    setLayout(new FlowLayout() );

    button = new Button("Send_nudes");
    button.setActionCommand("send nudes button");
    button.addActionListener(this);
    add(button);

    setVisible(true);
  }


  public void actionPerformed(ActionEvent event)
  {
    if(event.getActionCommand().equals("send nudes button") )
      System.out.println("You're about to send some cool nudes");
  }
}
