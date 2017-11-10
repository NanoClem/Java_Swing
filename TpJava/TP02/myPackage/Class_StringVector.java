
package myPackage;
import java.util.*;
import java.io.*;


public class Class_StringVector
{
	private Vector<String> list;


	public Class_StringVector()
	{
		list = new Vector<String>();
	}


	public void printVector()
	{
		if(list.size() < 1)
			System.out.println("No elements detected");

		for(int i=0; i<list.size(); i++)
		System.out.print(list.elementAt(i) + ", ");

		System.out.println(" ");
	}


	public void fillVector()
	{
		String chain;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter element >");
		chain = scan.nextLine();
		list.addElement(chain);
	}


	public void clearVector()
	{
		if(list.size() < 1)
			System.out.println("No elements detected");

		list.clear();
	}


	public void sortVector()
	{
		if(list.size() <= 1)
			System.out.println("Not enought elements to make a sort");

		Collections.sort(list);
	}


	public void NbDuplication()
	{
		if(list.size() < 1)
			System.out.println("Not enought elements");

		int duplicate = 0;
		Vector<String> list2 = new Vector<String>();

		for(int i=0; i<list.size(); i++)
		{
			String s = list.elementAt(i);
			list2.addElement(s);
			if(list2.contains(s))
				duplicate+=1;
		}

		duplicate -= 1;
		System.out.println(duplicate + " duplicate");
	}


	public void RemoveDuplication()
	{
		if(list.size() < 1)
			System.out.println("Not enought elements");

		Vector<String>list2 = new Vector<String>();

        for (int i=0; i<list.size(); i++)
		{
            String s = list.elementAt(i);
            if (!list2.contains(s))
                list2.addElement(s);
        }

		clearVector();

		for(int i=0; i<list.size(); i++)
		{
			String s = list2.elementAt(i);
			list.addElement(s);
		}
	}






}
