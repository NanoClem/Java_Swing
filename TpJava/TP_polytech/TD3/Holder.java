import java.util.*;


public class Holder extends Employee
{
  private Date hireDate;
  private float netSalary;

  //CONSTRUCTEUR
  public Holder(String _name, String _surname, Date _hireDate, float _netSalary)
  {
    super(_name, _surname);
    this.hireDate  = _hireDate;
    this.netSalary = _netSalary;
  }

  //REDIFINITION METHODE : calculer le salaire
  public float getSalary()
  {
    float rawSalaray = this.netSalary + (this.netSalary * percentSecu);
    return rawSalaray;
  }

  //GETTERS / SETTERS
  public Date getHireDate()   {return this.hireDate;}
  public float getNetSalary() {return this.netSalary;}
}
