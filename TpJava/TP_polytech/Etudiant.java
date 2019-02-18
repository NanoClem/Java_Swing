import java.util.*;


public class Etudiant
{
  private int id;
  private String name;
  private String surname;
  private String spe;


  //Constructeur par defaut
  public Etudiant()
  {
    this.id      = 0;
    this.name    = "";
    this.surname = "";
  }


  //Constructeur
  public Etudiant(int new_id, String new_name, String new_surname, String new_spe)
  {
    this.id      = new_id;
    this.name    = new_name;
    this.surname = new_surname;
    this.spe     = new_spe;
  }


  //GETTER SETTER
  public int getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getSpe() {
    return this.spe;
  }


  //Afficher l'etudiant
  public void printEtudiant()
  {
    System.out.println("Etudiant num : " + getID());
    System.out.println(getName() + " " + getSurname());
    System.out.println("Spe : " + getSpe());
  }
}
