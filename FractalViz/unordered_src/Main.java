import java.util.*;

public class Main
 {

   public static void main(String[] args) throws Exception
   {
     // //GraphicWindow window = new GraphicWindow("SEND NUDES");
     // Complex test = new Complex(5,9);
     // //test.printComplex();
     // Complex test2 = new Complex();
     // test2 = test;
     // test2.printComplex();

     Mandelbrot myFract = new Mandelbrot(270, 240, 100);
     Vector<Integer> xtest = new Vector<Integer>();
     xtest = myFract.getPts_x();

     for(int i = 0; i < xtest.size(); i++)
      System.out.print(xtest.elementAt(i) + " ");
   }
 }
