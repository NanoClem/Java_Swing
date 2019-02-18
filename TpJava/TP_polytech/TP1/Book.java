import java.util.*;


public class Book {
  private String title;
  private String author;
  private int releaseYear;
  private ArrayList<Character> charTab;


  // CONSTRUCTEUR
  public Book(String _title, String _author, int _releaseYear, ArrayList<Character> _charTab)
  {
    // Si aucun personnage n'est renseigne
    if(_charTab.size() < 1) {
      this.charTab = new ArrayList<Character>();
      this.charTab.add(new Character());
    }
    else {
      this.charTab   = _charTab;
    }

    this.title       = _title;
    this.author      = _author;
    this.releaseYear = _releaseYear;
  }


  // CONSTRUCTEUR PAR DEFAUT
  public Book() {
    this.title       = "Untilted";
    this.author      = "John Doe";
    this.releaseYear = 2002;
    this.charTab     = new ArrayList<Character>();
    this.charTab.add(new Character());
  }


  // AFFICHAGE DES PERSONNAGES DU LIVRE
  public void printCharacters()
  {
    Iterator it = this.charTab.iterator();
    while(it.hasNext()) {
      System.out.println(it.toString());
    }
  }


  // AJOUTER UN PERSONNAGE
  public void addCharacter(Character charact)
  {
    this.charTab.add(charact);
  }


  // SAVOIR SI LA LISTE CONTIENT UN PERSONNAGE
  public boolean containsCharacter(String charName)
  {
    boolean contains = false;
    Iterator<Character> it = this.charTab.iterator();

    while(it.hasNext()) {
      if(it.next().getName() == charName) {
        contains = true;
        break;
      }
    }

    return contains;
  }


  // PREPARE L'AFFICHAGE D'UN LIVRE
  public String toString()
  {
    String bookStr = "Titre : " + this.title + "\n" +
                     "Auteur : " + this.author + "\n" +
                     "Parution : " + Integer.toString(this.releaseYear) + "\n";

    Iterator<Character> it = this.charTab.iterator();
    String pers = "Personnages : ";
    while(it.hasNext()) {
      pers += it.next().getName() + " ";
    }

    return bookStr + pers;
  }
}
