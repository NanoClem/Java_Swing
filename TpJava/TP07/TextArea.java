import java.awt.*;
import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;



public class TextArea extends JTextPane
{
  public TextArea() throws Exception
  {
    setTextStyle(Color.black);      // Couleur du texte noire par défaut
  }


  public void setTextStyle(Color color)
  {
    //STYLE DU textPane
    StyledDocument doc = (StyledDocument) this.getDocument();
    Style style = doc.addStyle("BasicText", null);                          // Objet de style
    StyleConstants.setForeground(style, color);                             // Attributs du premier plan
    this.setCharacterAttributes(style, true);                               // Attributs du texte

    try {
      doc.insertString(doc.getLength(), "Texte par defaut", style);         // Insertion du texte de base
    }
    catch(Exception e) {
      e.getMessage();
      //e.offSetRequested();                // retourne le déplacement demandé dans l'emplacement mémoire concerné
    }
  }
}
