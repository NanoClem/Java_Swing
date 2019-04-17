import java.util.*;


public class Main
{
  public static void main(String[] args)
  {
    //EMPLOYES DE LA SOCIETE
    Employee Dave     = new Holder("Pattinson", "Dave");
    Employee Rick     = new Intervener("Bucklemore", "Rick");
    Employee Mirranda = new Holder("Mackintosh", "Mirranda");

    //ENTREPRISE
    Company SuperToys = new Company();

    //AJOUT ET AFFICHAGE DES EMPLOYEES
    SuperToys.addEmployee(Dave);
    SuperToys.addEmployee(Rick);
    SuperToys.addEmployee(Mirranda);
    SuperToys.printEmployees();
  }
}
