import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;



public class GraphicWindow extends JFrame
                           implements ActionListener
{
  DrawArea drawPane;

  public GraphicWindow(String s) throws Exception
  {
    super(s);
    setSize(700,700);
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
    JMenu draw = new JMenu("Dessin");
    menuBar.add(draw);


    //Les items contenus dans les éléments

    //FICHIER
    JMenuItem load = new JMenuItem("Charger");
    file.add(load);
    JMenuItem save = new JMenuItem("Sauver");
    file.add(save);
    file.add(new JSeparator());                          //ligne séparatrice
    JMenuItem quit = new JMenuItem("Quitter");
    file.add(quit);

    //DESSINER
    JMenuItem drawWB = new JMenuItem("Noir_Blanc");
    draw.add(drawWB);
    JMenuItem drawColor = new JMenuItem("Couleur");
    draw.add(drawColor);


    // AJOUTS DES ACTION DE CLIC SUR LES ITEMS
    quit.setActionCommand("quit");                       // lorsque l'on clique sur "Quitter"
    quit.addActionListener(this);

    load.setActionCommand("load");                       // lorsque l'on clique sur "Charger"
    load.addActionListener(this);

    save.setActionCommand("save");                       // Lorsque l'on clique sur "Sauver"
    save.addActionListener(this);

    drawWB.setActionCommand("drawWB");
    drawWB.addActionListener(this);

    setVisible(true);
  }



  public int getInputIteration()
  {
    JOptionPane pane = new JOptionPane();
    int iteration = Integer.valueOf( pane.showInputDialog(this,
              "Saisir le nombre d'itération(s) :",
              "Combien d'itération(s) ?",
              JOptionPane.QUESTION_MESSAGE) );

    return iteration;
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

    // ACTION POUR DESSINER LA FRACTALE EN NOIR ET BLANC
    if ( event.getActionCommand().equals("drawWB") )
    {
      // FRACTALES DE MANDELBROT
      int userIteration = getInputIteration();
      int width     = 700;
      int height    = 640;
      Mandelbrot myFract = new Mandelbrot(width, height, userIteration);

      // LA FENÊTRE DE DESSIN
      drawPane = new DrawArea(myFract.draw_WB(width, height));
      getContentPane().add(drawPane);                           // on l'ajoute avec son contenu dans notre fenêtre graphique
      //JScrollPane scrollBar = new JScrollPane(drawPane);      // Barre de scrolling verticale
      //getContentPane().add(scrollBar);

      setVisible(true);
    }


    // ACTION LORSQUE L'ON CLIQUE SUR "Charger"
    /*if ( event.getActionCommand().equals("load") )
    {
      JFileChooser select = new JFileChooser();                                                       // Sélecteur de fichier
      select.addChoosableFileFilter( new FileNameExtensionFilter("Pictures Files(.png)", "png") );    // On ne peut sélectionner que les fichiers texte
      int result = select.showOpenDialog(this);                                                       // On affiche une fenêtre de dialog

      if(result == JFileChooser.APPROVE_OPTION)                                                       // Si on a confirmé le chargement du fichier
      {
        File choosed_file = new File( select.getSelectedFile().getAbsolutePath() );                   // le fichier choisi avec le chemin complet
        try {
          drawPane.setPage( choosed_file.toURI().toURL() );                                           // on ajoute le contenu du fichier dans la fenêtre de texte
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
      int result = save.showSaveDialog(this);                                   // Nouvelle fenêtre de sauvegarde de fichiers

      if(result == JFileChooser.APPROVE_OPTION)
       {
         File saved_file = new File( save.getSelectedFile().getAbsolutePath() );
         String s = saved_file.getPath();                                       // Nom du fichier sauvé
         int i = s.indexOf(".");                                                // index du caractère "." juste avant l'extension du fichier
         //String txt = textPane.getText();                                       // contenu de la fenêtre de dessin
         PrintWriter writer;

         if ( i == -1 || !s.substring(i).equals(".png") )                       // si il n'y a pas de "." en fin de nom ou si le nom n'est pas consittué de ".txt"
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
   }*/
  }
}
