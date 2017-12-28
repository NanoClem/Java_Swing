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
    quit.setActionCommand("quit");                       // Clic sur "Quitter"
    quit.addActionListener(this);

    load.setActionCommand("load");                       // Clic sur "Charger"
    load.addActionListener(this);

    save.setActionCommand("save");                       // Clic sur "Sauver"
    save.addActionListener(this);

    drawWB.setActionCommand("drawWB");                   // Clic sur "Noir_Blanc"
    drawWB.addActionListener(this);

    drawColor.setActionCommand("drawColor");             // Clic sur 'Couleur'
    drawColor.addActionListener(this);

    setVisible(true);
  }


  // FENETRE D'INPUT POUR LE NOMBRE D'ITERATION
  // renvoie la valeur entière saisie par l'user
  // si l'user n'a rien saisi, on renvoie une valeur par défaut choisie arbitrairement
  public int getInputIteration()
  {
    JTextField inputIteration = new JTextField();
    int iteration = 0;

    int option = JOptionPane.showConfirmDialog(this,
              inputIteration,
              "Saisir le nombre d'iteration(s) :",
              JOptionPane.OK_CANCEL_OPTION);

    if(option == JOptionPane.OK_OPTION)
    {
      if( inputIteration.getText().equals("") )
        iteration = 20;
      else
        iteration = Integer.valueOf( inputIteration.getText() );
    }

    return iteration;
  }


  // FENETRE D'INPUT MULTIPLE POUR LA COULEUR
  // renvoie un tableau contenant les valeures enières RGB choisies
  // si l'user n'a rien saisi ou si saisie est supérieure à 255, on affecte une valeur par défaut choisie arbitrairement à chaque entier RGB
  public int[] getInputColor()
  {
    int color[] = new int[3];
    JTextField red   = new JTextField();
    JTextField green = new JTextField();
    JTextField blue  = new JTextField();

    Object[] InputColor = {
      "r :", red,
      "g :", green,
      "b :", blue
    };

    int option = JOptionPane.showConfirmDialog(this,
                 InputColor,
                 "Choisissez votre couleur",
                 JOptionPane.OK_CANCEL_OPTION);

    if(option == JOptionPane.OK_OPTION)
    {
      if(red.getText().equals("") ||  Integer.valueOf( red.getText() ) > 255)
        color[0] = 255;
      else
        color[0] = Integer.valueOf( red.getText() );

      if(green.getText().equals("") ||  Integer.valueOf( green.getText() ) > 255)
        color[1] = 255;
      else
        color[1] = Integer.valueOf( green.getText() );

      if(blue.getText().equals("") ||  Integer.valueOf( blue.getText() ) > 255)
        color[2] = 255;
      else
        color[2] = Integer.valueOf( blue.getText() );
    }

    return color;
  }



  // ACTIONS
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
      // FRACTALE DE MANDELBROT
      int userIteration = getInputIteration();
      int width     = 690;
      int height    = 640;
      Mandelbrot myFract = new Mandelbrot(width, height, userIteration, 255, 255, 255);       // la couleur des points en dehors de l'ensemble n'a aucune incidence pour cette fonction

      // LA FENÊTRE DE DESSIN
      getContentPane().removeAll();                                                           // On éfface le contenu pour éviter la superposition des images
      drawPane = new DrawArea(myFract.draw_WB(width, height));
      getContentPane().add(drawPane);

      setVisible(true);
    }


    // ACTION POUR DESSINER LA FRACTALE EN COULEUR
    if ( event.getActionCommand().equals("drawColor") )
    {
      // FRACTALE DE MANDELBROT
      int userColor[] = new int[3];
      userColor = getInputColor();
      int userIteration = getInputIteration();
      int width     = 690;
      int height    = 640;
      Mandelbrot myFract = new Mandelbrot(width, height, userIteration, userColor[0], userColor[1], userColor[2] );

      // LA FENÊTRE DE DESSIN
      getContentPane().removeAll();
      drawPane = new DrawArea(myFract.draw_Color(width, height) );
      getContentPane().add(drawPane);

      setVisible(true);
    }


    // ACTION LORSQUE L'ON CLIQUE SUR "Charger"
    if ( event.getActionCommand().equals("load") )
    {
      JFileChooser select = new JFileChooser();                                                       // Sélecteur de fichier
      select.addChoosableFileFilter( new FileNameExtensionFilter("Pictures Files(.png)", "png") );    // On ne peut sélectionner que les fichiers image
      int result = select.showOpenDialog(this);                                                       // On affiche une fenêtre de dialog

      if(result == JFileChooser.APPROVE_OPTION)                                                       // Si on a confirmé le chargement du fichier
      {
        File choosed_file = new File( select.getSelectedFile().getAbsolutePath() );                   // le fichier choisi avec le chemin complet

        try {
          BufferedImage img = ImageIO.read(choosed_file);                                             // nouvelle image à partir de celle lue
          getContentPane().removeAll();
          drawPane = new DrawArea(img);
          getContentPane().add(drawPane);                                                             // on ajoute l'image chargée dans la zone de dessin
          setVisible(true);
        }
        catch(IOException e) {
          e.printStackTrace();
        }
      }
    }


    // ACTION LORQUE L'ON CLIQUE SUR "Sauver"
    if( event.getActionCommand().equals("save") )
    {
      JFileChooser save = new JFileChooser();
      int result = save.showSaveDialog(this);                                     // Nouvelle fenêtre de sauvegarde de fichiers

      if(result == JFileChooser.APPROVE_OPTION)
        {
         File saved_file = new File( save.getSelectedFile().getAbsolutePath() );  // Chemin complet du fichier sauvé
         try {
           ImageIO.write(drawPane.getImg(), "png", saved_file);                   // On écrit l'image dans un nouveau fichier png
         }
         catch(IOException e) {
           e.printStackTrace();
         }
       }
    }
  }
}
