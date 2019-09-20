import java.util.*;
import javax.swing.JOptionPane;

public class Etudiant{
    private String nom,prenom;
    private double [] notes;
    private int nombDeNotes;
    private double moyenne;
    private String [] mati�res;
    public static Scanner scan=new Scanner(System.in);
    public Etudiant(String noms, String pren,int nomb){
        nom=noms;
        prenom=pren;
        nombDeNotes=nomb;
        notes=new double[nombDeNotes];
         mati�res=new String [nombDeNotes];
     for(int i=0;i<nombDeNotes;i++){
         System.out.println("Entrer le nom de la mati�re "+(i+1));
       mati�res[i]=  scan.next();
         Cours mati�re=new Cours(mati�res[i]);
       notes[i]= mati�re.calculeMoyenneDuCours(); 
     }
     moyenne=calculerMoyenneEtudiant();
         
    }
   
     public double calculerMoyenneEtudiant(){
       int somme=0;
         for(int k=0;k<nombDeNotes;k++){
             somme+=notes[k];
             
         }   
          return somme/nombDeNotes;
      }   
    
     public void affiche�tudiant(){
         System.out.println("Etudiant : "+prenom+" "+nom);
         for(int i=0;i<nombDeNotes;i++){ 
         System.out.print(String.format("%-10s",mati�res[i]));
         
         }
         System.out.println();
           for(int i=0;i<nombDeNotes;i++){ 
         System.out.print(String.format("%-10s",Double.toString(notes[i])));
      
         }
           System.out.println();
           System.out.println("La moyenne totale : "  +moyenne);
      }   
    
     public static int demandeUnEntier(String message){
       System.out.println(message);
       return scan.nextInt();
     }
     public static String demandeStr(String message){
       System.out.println(message);
       return scan.next();
     }
    
    
    
    
    
    
    
    
    
    
}
