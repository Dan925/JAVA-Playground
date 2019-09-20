 import javax.swing.JOptionPane;
import java.util.*;

public class GestionEtudiants {
 
    public static Etudiant  listeDeClasse[];  
    public static int nombEtud;
   public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Entrer le nombre d'élèves");
       nombEtud= sc.nextInt();
        listeDeClasse=new Etudiant[nombEtud];
       for(int i=0;i<nombEtud;i++ ){
        
        Etudiant Batmoi=new Etudiant(Etudiant.demandeStr("Entrer le nom de l'étudiant"),Etudiant.demandeStr("Entrer le prenom de l'étudiant"),Etudiant.demandeUnEntier("Entrer le nombre de matières "));
       listeDeClasse[i]=Batmoi;
       
       }
       for(int i=0;i<nombEtud;i++){
         listeDeClasse[i].afficheÉtudiant(); 
         
       }
       
    }
    
}
