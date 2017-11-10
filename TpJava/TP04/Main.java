import Mediatheque.*;


public class Main
{
  public static main(String [] arg)
  {
    Mediatheque Beauf = new Mediatheque();
    byte choice = 0;

    do
    {
      System.out.println("1. Add a work");
      System.out.println("2. Print a work");
      System.out.println("3. Quit");
      System.out.print(">");
      choice = scan.nextByte();

      switch(choice)
      {
        case 1 :
          Beauf.fillMediatheque();
          break;
        case 2 :
          Beauf.printMediatheque();
          break;
        case 3 :
          System.exit(0);
        default :
          System.out.println("Unknown operation");
          break;
      }
    } while(choice != 3);
  }
}
