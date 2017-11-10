import java.util.*;


public class Livre extends Ouvrage
{
   private String title;
   private String author;


   public Class_livre (int new_id, boolean new_isTook, String new_title, String new_author)
   {
     super(new_id, new_isTook);   //Constructeur de la classe mère Ouvrage
     title = new_title;
     author = new_author;
   }


   public void print_livre()
   {
     super.print_Ouvrage();       //Méthode de la classe mère
     System.out.println("Titre du livre : " + title);
     System.out.println("Nom de l'auteur : " + author);
   }
}
