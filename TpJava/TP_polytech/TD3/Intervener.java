import java.util.*;


public class Intervener extends Employee
{
  private Date firstIntervention;

  //CONSTRUCTEUR
  public Intervener(String _name, String _surname, Date _firstIntervention)
  {
    super(_name, _surname);
    this.firstIntervention = _firstIntervention;
  }

  //REDEFINITION METHODE : calculer le salaire
  public float getSalary()
  {
    float test = 10.0;
    return test;
  }

  //GETTERS / SETTERS
  public Date getFirstIntervention()            {return this.firstIntervention;}
  public void firstIntervention(Date new_date)  {this.firstIntervention = new_date;}
}
