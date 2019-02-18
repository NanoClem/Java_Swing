import java.util.*;


public class Company
{
  private ArrayList<Employee> empList;


  public Company(ArrayList<Employee> _emplist)
  {
    this.empList = _empList;
  }


  //CALCULER LES COUTS SALARIALS TOTAUX
  public float getCosts()
  {
    float totalCosts = 0.0;
    Iterator<Employee> it = this.empList.iterator();
    while(it.hasNext()) {
      totalCosts += it.next().getSalary();
    }
    
    return totalCosts;
  }
}
