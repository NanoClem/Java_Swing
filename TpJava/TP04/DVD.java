import java.util.*;


public class DVD extends Ouvrage
{
   private String title;
   private int minute;


   public Class_DVD (int new_id, boolean new_isTook, String new_title, int new_minute)
   {
     super(new_id, new_isTook);
     title = new_title;
     minute = new_minute;
   }


   public void print_DVD()
   {
     super.print_Ouvrage();
     System.out.println("Titre du DVD : " + title);
     System.out.println("Durée du film : " + minute);
   }
}
