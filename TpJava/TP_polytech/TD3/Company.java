import java.util.*;


public class Company
{
  private ArrayList<Employee> empList;


  //CONSTRUCTEUR
  public Company(ArrayList<Employee> _empList)
  {
    this.empList = _empList;
  }

  //CONSTRUCTEUR PAR DEFAUT
  public Company()
  {
    this.empList = new ArrayList<Employee>();
  }


  //AJOUTER UN EMPLOYE
  public boolean addEmployee(Employee emp)
  {
    return this.empList.add(emp);
  }


  //CALCULER LES COUTS SALARIALS TOTAUX
  public float getCosts()
  {
    float totalCosts = 0.0f;
    Iterator<Employee> it = this.empList.iterator();
    while(it.hasNext()) {
      totalCosts += it.next().getSalary();
    }

    return totalCosts;
  }


  //AFFICHER LA LISTE DES EMPLOYES
  public void printEmployees()
  {
    int empID         = 0;
    String empName    = "";
    String empSurname = "";
    Iterator<Employee> it = this.empList.iterator();

    while(it.hasNext()){
      empID      = it.next().getID();
      empName    = it.next().getName();
      empSurname = it.next().getSurname();

      System.out.println(Integer.toString(empID) +
                         " " + empName
                         + " " + empSurname);
    }
  }
}
