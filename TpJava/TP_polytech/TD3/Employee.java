
abstract class Employee
{
  public static final float percentSecu = 0.10f;  //pourcentage de securite sociale
  public static int id;                           //numero employe
  protected String name;                          //nom employe
  protected String surname;                       //prenom employee

  Employee(String _name, String _surname) {
    id++;
    this.name    = _name;
    this.surname = _surname;
  }

  //METHODE ABSTRAITE : calculer le salaire de l'employe
  abstract float getSalary();

  //GETTERS / SETTERS
  public float getPercentSecu() {return percentSecu;}
  public int getID()            {return id;}
  public String getName()       {return this.name;}
  public String getSurname()    {return this.surname;}
}
