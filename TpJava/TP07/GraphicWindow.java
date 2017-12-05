import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class GraphicWindow extends JFrame
                           implements ActionListener
{
  TextArea textPane;

  public GraphicWindow(String s) throws Exception
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
    JMenuItem custom = new JMenuItem("Personnaliser");
    color.add(custom);


    // AJOUTS DES ACTION DE CLIC SUR LES ITEMS
    quit.setActionCommand("quit");                       // lorsque l'on clique sur "Quitter"
    quit.addActionListener(this);

    load.setActionCommand("load");                       // lorsque l'on clique sur "Charger"
    load.addActionListener(this);

    save.setActionCommand("save");                       // Lorsque l'on clique sur "Sauver"
    save.addActionListener(this);

    black.setActionCommand("black_text");
    black.addActionListener(this);

    red.setActionCommand("red_text");
    red.addActionListener(this);

    blue.setActionCommand("blue_text");
    blue.addActionListener(this);

    custom.setActionCommand("customised_text");
    custom.addActionListener(this);


    // LA FENÊTRE DE TEXTE
    textPane = new TextArea();                            // la fenêtre de texte
    getContentPane().add(textPane);                       // on l'ajoute avec son contenu dans notre fenêtre graphique

    JScrollPane scrollBar = new JScrollPane(textPane);    // Barre de scrolling verticale
    getContentPane().add(scrollBar);


    setVisible(true);
  }



  public void actionPerformed(ActionEvent event)
  {

    // ACTION LORSQUE L'ON CLIQUE SUR "Quitter"
    if ( event.getActionCommand().equals("quit") )                 // si on sélectionne "Quitter"
    {
      JOptionPane pane = new JOptionPane();
      if ( pane.showConfirmDialog(this,                            // on demande une confirmation en rapport
                "Voulez vous vraiment quitter ?",                  // avec la fenêtre qui a déclenché l'action (this)
                "Attention",
                pane.YES_NO_OPTION,
                pane.WARNING_MESSAGE) == JOptionPane.YES_OPTION )  // si on a confirmé
        System.exit(0);                                            // on quitte le programme
    }


    // ACTION LORSQUE L'ON CLIQUE SUR "Charger"
    if ( event.getActionCommand().equals("load") )
    {
      JFileChooser select = new JFileChooser();                                                       // Sélecteur de fichier
      select.addChoosableFileFilter( new FileNameExtensionFilter("Text Documents(.txt)", "txt") );    // On ne peut sélectionner que les fichiers texte
      int result = select.showOpenDialog(this);                                                       // On affiche une fenêtre de dialog

      if(result == JFileChooser.APPROVE_OPTION)                                                       // Si on a confirmé le chargement du fichier
      {
        File choosed_file = new File( select.getSelectedFile().getAbsolutePath() );                   // le fichier choisi avec le chemin complet
        try {
          textPane.setPage( choosed_file.toURI().toURL() );                                           // on ajoute le contenu du fichier dans la fenêtre de texte
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


    // ACTION LORQUE L'ON CLIQUE SUR "Sauver"
    if( event.getActionCommand().equals("save") )
    {
      JFileChooser save = new JFileChooser();
      int result = save.showSaveDialog(this);                                   // Nouvelle fenêtre de sauvegarde

      if(result == JFileChooser.APPROVE_OPTION)
       {
         File saved_file = new File( save.getSelectedFile().getAbsolutePath() );
         String s = saved_file.getPath();                                       // Nom du fichier sauvé
         int i = s.indexOf(".");                                                // index du caractère "." juste avant l'extension
         String txt = textPane.getText();                                       // contenu de la fenêtre de texte
         PrintWriter writer;

         if ( i == -1 || !s.substring(i).equals(".txt") )                       // si il n'y a pas de "." en fin de nom ou si le nom n'est pas consittué de ".txt"
         {
           try
           {
             writer = new PrintWriter( new FileWriter(s + ".txt"), true );      // on écrit un nouveau fichier avec la bonne extension
             writer.println(txt);                                               // on écrit le texte de la TextArea dans le fichier
             writer.close();                                                    // fermeture du fichier
           }
           catch (IOException e)
           {
             e.printStackTrace();
           }
         }
        else                                                                    // Si l'extension est bien ".txt"
        {
          try {
            writer = new PrintWriter( new FileWriter(s), true );
            writer.println(txt);
            writer.close();
          }
          catch (IOException e) {
            e.printStackTrace();
          }
       }
     }
   }


   // METTRE LE TEXTE EN NOIR
   if ( event.getActionCommand().equals("black_text") )
     textPane.setTextStyle(Color.black);

   // METTRE LE TEXTE EN ROUGE
   if ( event.getActionCommand().equals("red_text") )
     textPane.setTextStyle(Color.red);

   // METTRE LE TEXTE EN BLEU
   if ( event.getActionCommand().equals("blue_text") )
     textPane.setTextStyle(Color.blue);


   // Personnaliser la couleur du texte
   if ( event.getActionCommand().equals("customised_text") )
   {
     JColorChooser custom_color = new JColorChooser();
     Color result = custom_color.showDialog(this, "Couleur personnalisée", Color.black);
     textPane.setTextStyle(result);
   }
  }
}
