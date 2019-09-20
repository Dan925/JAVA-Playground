import java.util.*;
import javax.swing.JOptionPane;

public class Etudiant{
    private String nom,prenom;
    private double [] notes;
    private int nombDeNotes;
    private double moyenne;
    private String [] matières;
    public static Scanner scan=new Scanner(System.in);
    public Etudiant(String noms, String pren,int nomb){
        nom=noms;
        prenom=pren;
        nombDeNotes=nomb;
        notes=new double[nombDeNotes];
         matières=new String [nombDeNotes];
     for(int i=0;i<nombDeNotes;i++){
         System.out.println("Entrer le nom de la matière "+(i+1));
       matières[i]=  scan.next();
         Cours matière=new Cours(matières[i]);
       notes[i]= matière.calculeMoyenneDuCours(); 
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
    
     public void afficheÉtudiant(){
         System.out.println("Etudiant : "+prenom+" "+nom);
         for(int i=0;i<nombDeNotes;i++){ 
         System.out.print(String.format("%-10s",matières[i]));
         
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
