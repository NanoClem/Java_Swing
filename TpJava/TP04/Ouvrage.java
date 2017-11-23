import java.util.*;


public class Ouvrage
{
   private int id;
   protected boolean isTook;


   public Ouvrage (int new_id, boolean new_isTook)
   {
     id = new_id;
     isTook = new_isTook;
   }


   public void print_Ouvrage()
   {
     System.out.println("Id de l'oeuvre : " + id);
     System.out.println("Disponibilité : " + isTook);
   }
}
