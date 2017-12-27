import java.util.*;

public class Main
 {

   public static void main(String[] args) throws Exception
   {
     // Complex test = new Complex(5,9);
     // //test.printComplex();
     // Complex test2 = new Complex();
     // test2 = test;
     // test2.printComplex();

     Mandelbrot myFract = new Mandelbrot(270, 240, 100);
     Vector<Integer> xtest = new Vector<Integer>();
     xtest = myFract.getPts_x();
	 Vector<Integer> ytest = new Vector<Integer>();
	 ytest = myFract.getPts_y();
	 
	GraphicWindow window = new GraphicWindow("SEND NUDES", xtest, ytest);
	 

     /*for(int i = 0; i < xtest.size(); i++)
	 {
      System.out.print(xtest.elementAt(i) + " ");
	  System.out.print(ytest.elementAt(i) + " ");
	 }*/
   }
 }
