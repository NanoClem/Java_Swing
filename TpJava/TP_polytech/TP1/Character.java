import java.util.*;


public class Character
{
  private String name;
  private String description;

  // CONSTRUCTEUR
  public Character(String _name, String _description)
  {
    this.name        = _name;
    this.description = _description;
  }

  // CONSTRUCTEUR PAR DEFAUT
  public Character()
  {
    this.name        = "John Doe";
    this.description = "";
  }

  // AFFICHAGE
  public String toString()
  {
    return "Personnage : " + this.name + "\n" +
           "Description : " + this.description;
  }

  // VERIFIER L'IDENTITE DU PERSONNAGE
  public boolean isCharacter(String charName)
  {
    return this.name == charName;
  }

  // GETTER / SETTER
  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }
}
