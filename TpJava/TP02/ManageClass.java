
import java.util.*;
import Tp.Java.myPackage.Class_StringVector;


public class ManageClass
{
	public static void main(String [] arg)
	{
		byte choice = 0;
		Scanner scan = new Scanner(System.in);
		Class_Vector V = new Class_Vector();

		do
		{
			System.out.println("1. Add a string");
			System.out.println("2. Print elements");
			System.out.println("3. Clear the container");
			System.out.println("4. Sort the container");
			System.out.println("5. Print the number of duplication(s)");
			System.out.println("6. Remove duplication(s)");
			System.out.println("7. Quit");
			System.out.print(">");
			choice = scan.nextByte();

			switch(choice)
			{
				case 1 :
					V.fillVector();
					break;
				case 2 :
					V.printVector();
					break;
				case 3 :
					V.clearVector();
				case 4 :
					V.sortVector();
					break;
				case 5 :
					V.NbDuplication();
					break;
				case 6 :
					V.RemoveDuplication();
					break;
				case 7 :
					System.exit(0);
				default :
					System.out.println("Unknown operation");
					break;
			}
		} while(choice != 3);

	}
}
