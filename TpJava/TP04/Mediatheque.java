import java.util.*;


public class Mediatheque
{
  private Vector<Ouvrage> ouvrage_list;
  private Vector<Boolean> whatIs;     //permet de savoir si on ajoute un livre ou un DVD


  public Mediatheque()
  {
    ouvrage_list = new Vector<Ouvrage>();
    whatIs = new Vector<Boolean>();
  }


  public void fillMediatheque()
  {
    String work = "";
    Scanner scan = new Scanner(System.in);

    System.out.println("Type book or DVD to add a work" );
    System.out.print(">" );
    work = scan.nextLine();

    if(work.equals("book"))
    {
      whatIs.addElement(true);  //Vrai si l'on ajoute un livre

      String [] info = {"Id : ", "Is he already took ? true/false : ", "Title : ", "Author : "};
      int _id; boolean _isTook; String _title; String _author;

      System.out.print(info[0]);
      _id = scan.nextInt();

      System.out.print(info[1]);
      _isTook = scan.nextBoolean();

      System.out.print(info[2]);
      _title = scan.nextLine();

      System.out.print(info[3]);
      _author = scan.nextLine();

      Livre B = new Livre(_id, _isTook, _title, _author);
      ouvrage_list.addElement(B);
    }

    else if(work.equals("DVD"))
    {
      whatIs.addElement(false);

      String [] info = {"Id : ", "Is he already took ? true/false : ", "Title : ", "Duration : "};
      int _id; boolean _isTook; String _title; int _minute;

      System.out.print(info[0]);
      _id = scan.nextInt();

      System.out.print(info[1]);
      _isTook = scan.nextBoolean();

      System.out.print(info[2]);
      _title = scan.nextLine();

      System.out.print(info[3]);
      _minute = scan.nextInt();

      DVD B = new DVD(_id, _isTook, _title, _minute);
      ouvrage_list.addElement(B);
    }

    else
      System.out.println("Work type unknown");
  }


  public void printMediatheque()
  {
    if(ouvrage_list.size() < 1)
      System.out.println("No elements detected");

  //  Ouvrage tmp;
  //  Livre L;


    for(int i = 0; i < ouvrage_list.size(); i++)
    {
      //Ouvrage tmp;
      //tmp = ouvrage_list.elementAt(i);

      

      if(whatIs.elementAt(i) == true)
      {
        L = ouvrage_list.elementAt(i);
        L.print_livre();
      }

      /*else if(whatIs.elementAt(i) == false)
      {
        D = ouvrage_list.elementAt(i);
        D.print_DVD();
      }*/

      //tmp.print_Ouvrage()
    }
  }
}
