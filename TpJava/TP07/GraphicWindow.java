import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class GraphicWindow extends JFrame
                           implements ActionListener
{
  TextArea textPane;

  public GraphicWindow(String s)
  {
    super(s);
    setSize(600,400);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setAlwaysOnTop(true);

    //Nouvelle barre de menu
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    //Les éléments de la barre de menu
    JMenu file = new JMenu("Fichier");
    menuBar.add(file);
    JMenu color = new JMenu("Couleur");
    menuBar.add(color);

    //Les items contenus dans les éléments
    //FICHIER
    JMenuItem load = new JMenuItem("Charger");
    file.add(load);
    JMenuItem save = new JMenuItem("Sauver");
    file.add(save);
    file.add(new JSeparator());                 //ligne séparatrice
    JMenuItem quit = new JMenuItem("Quitter");
    file.add(quit);

    //COULEUR
    JMenuItem black = new JMenuItem("Noir");
    color.add(black);
    JMenuItem red = new JMenuItem("Rouge");
    color.add(red);
    JMenuItem blue = new JMenuItem("Bleu");
    color.add(blue);
    color.add(new JSeparator());
    JMenuItem custom = new JMenuItem("Personnalisee");
    color.add(custom);


    //Les actions lorsque l'on sélectionne les items
    quit.setActionCommand("quit");      // lorsque l'on clique sur "Quitter"
    quit.addActionListener(this);

    load.setActionCommand("load");      // lorsque l'on clique sur "Charger"
    load.addActionListener(this);


    // LA FENÊTRE DE TEXTE
    textPane = new TextArea();
    getContentPane().add(textPane);


    setVisible(true);
  }


  public void actionPerformed(ActionEvent event)
  {
    // ACTION LORSQUE L'ON CLIQUE SUR "Quitter"
    if ( event.getActionCommand().equals("quit") )       // si on sélectionne "Quitter"
    {
      JOptionPane pane = new JOptionPane();
      if ( pane.showConfirmDialog(this,                  // on demande une confirmation en rapport
                "Voulez vous vraiment quitter ?",        // avec la fenêtre qui a déclenché l'action (this)
                "Attention",
                pane.YES_NO_OPTION,
                pane.WARNING_MESSAGE) == JOptionPane.YES_OPTION )
        System.exit(0);
    }

    // ACTION LORSQUE L'ON CLIQUE SUR "Charger"
    if ( event.getActionCommand().equals("load") )
    {
      JFileChooser select = new JFileChooser();                               // Sélecteur de fichier
      select.addChoosableFileFilter( new FileNameExtensionFilter("Text Documents(.txt)", "txt") );    // On ne peut sélectionner que les fichiers texte
      int result = select.showOpenDialog(this);                               // On affiche une fenêtre de dialog

      if(result == JFileChooser.APPROVE_OPTION)                               // Si on a confirmé le chargement du fichier
      {
        System.out.println("Fichier choisi = " + select.getSelectedFile().getAbsolutePath() );
        // Remplacer par l'affichage du fichier dans le JTextPane
      }
    }
  }
}
