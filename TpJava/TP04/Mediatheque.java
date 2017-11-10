import Tp.Java.myPackage.Class_StringVector;
import Ouvrage.*;


public class Mediatheque
{
  private Vector ouvrage_list;


  public Class_Mediatheque()
  {
    ouvrage_list = new Vector();
  }


  public void fillMediatheque()
  {
    String work;
    Scanner scan = new Scanner(System.in);

    System.out.println("Type book or DVD to add a work" );
    System.out.print(">" );
    work = scan.nextLine();

    if(work == "book")
    {
      int book_id; boolean book_isTook; String book_title; String author_name;
      Livre B = new Livre(book_id, book_isTook, book_title, author_name);
      ouvrage_list.addElement();
    }

  }


  public void printMediatheque()
  {
    Class_Vector V = new Class_Vector();
    V.printVector();
  }
}
