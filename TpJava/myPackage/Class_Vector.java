
package myPackage;
import java.util.*;
import java.io.*;


public class Class_Vector
{
	private Vector list;


	public Class_Vector()
	{
		list = new Vector();
	}


	public void printVector()
	{
		if(list.size() < 1)
			System.out.println("No elements detected");

		for(int i=0; i<list.size(); i++)
		System.out.print(list.elementAt(i) + ", ");

		System.out.println(" ");
	}


/*	public void fillVector()
	{
		Object o;
		//Scanner scan = new Scanner(System.in);

		//System.out.print("Enter element >");
		//o = scan.nextLine();
		list.addElement(o);
	} */


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
		Vector<Object> list2 = new Vector<Object>();

		for(int i=0; i<list.size(); i++)
		{
			Object o = list.elementAt(i);
			list2.addElement(o);
			if(list2.contains(o))
				duplicate+=1;
		}

		duplicate -= 1;
		System.out.println(duplicate + " duplicate");
	}


	public void RemoveDuplication()
	{
		if(list.size() < 1)
			System.out.println("Not enought elements");

		Vector<Object>list2 = new Vector<Object>();

        for (int i=0; i<list.size(); i++)
		{
           	Object o = list.elementAt(i);
            if (!list2.contains(o))
                list2.addElement(o);
        }

		clearVector();

		for(int i=0; i<list.size(); i++)
		{
			Object o = list2.elementAt(i);
			list.addElement(o);
		}
	}






}
