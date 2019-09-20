import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jeu_Pong extends JFrame {
   
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  static JTextField txt = new JTextField("");
int ptsJ1=0,
        ptsJ2=0;

// le déplacement du bloc
   int bougeX = 5,
       bougeY = 5;

   // la position du bloc
   int posX = 0,
       posY = 0;
// la position du bloc
  
      int posY1 = 100;
   // la position du bloc
   
     int  posY2 =100 ;
   // les dimensions du JFrame
   int appX = 400,
       appY = 200;

   // les paramètres du bloc
   int dimBloc = 25;

   boolean debug = true;

   // pour double-tampon
   Graphics buffer;   
// tampon ou buffer de mémoire
   Image image;        // image mémoire correspondante au buffer

   //le constructeur
  
   
   public Jeu_Pong () {
      super("Rebondir dans la fenêtre");
      setSize(appX,appY);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setLayout(new BorderLayout());
      txt.setBackground(Color.RED);
      txt.setEnabled(true);
      add(txt,BorderLayout.NORTH);
      // commence un instance du carré qui bouge
      Mouvement cible1 = new Mouvement();
      cible1.start();
   } // fin constructeur

   public void paint(Graphics g) {
    //  if (debug) System.out.println("Dans paint");
      super.paint(g);

      //création du tampon s'il n'existe pas
      if(buffer==null){
         System.out.println("Buffer existe pas");
         image = createImage(appX,appY);
         buffer = image.getGraphics();
       
      }

      //fait l'arrière plan
      buffer.setColor(Color.RED);
      buffer.fillRect(0,0,appX,appY);
 
      //when we draw, the border will be green
     // if (debug) System.out.println("    dans paint: "+posX+","+posY);

      buffer.setColor(Color.BLACK);
      buffer.fillRect (posX, posY, dimBloc, dimBloc);
       buffer.fillRect(10,posY1,5,50);
        buffer.fillRect(385,posY2,5,50);
       buffer.drawString(" Points Joueur1  "+ptsJ1+"                                                      Points Joueur2:  "+ptsJ2, 10,50 );
      

// copie ce tampon complet à la fenêtre
      g.drawImage(image, 0, 0, this);
   }

   private class Mouvement extends Thread implements KeyListener  {
      public void run()  {
txt.addKeyListener(this);
//  if (debug) System.out.println("Dans run");
         // position et déplacement initiale
         posX =dimBloc;
         posY = dimBloc;
         bougeX = 1;
         bougeY = 1;

         /* Vérifie les limites
          * On vérifie que le carré n'est pas passé le côté droit ou gauche.
          * Si oui, on change la direction en reversant le signe du déplacement.
          * Ensuite, on fait la même chose pour le vertical.
          */
         while(true)  {
             if (posX > appX - dimBloc) {
                // changer la direction du mouvement
                posX=200;
                 posY=100;
               ptsJ1++;
             }
            if(posY>appY-dimBloc)
              bougeY=-bougeY;
             
            if(posY<24)
             bougeY=-bougeY;
           
            if(posX<0){
                posX=200;
                 posY=100;
                 ptsJ2++;
            }
          
        
            if((posX>360)&&(posY2<posY+dimBloc&&posY<(posY2+50))){
                 bougeY=-bougeY;
            bougeX=-bougeX;
            }   
                
              if((posX<15)&&(posY+dimBloc>posY1)&&(posY<posY1+50)){
              bougeY=-bougeY;
            bougeX=-bougeX;
              }    
                  
                  
                  posX = posX + bougeX;
             posY = posY + bougeY;

          

             // maintenant affiche le carré et fait dodo
             try {
                 repaint();
                 Thread.sleep(25);
             }
             catch(Exception e)  {
                    System.out.println("Dans exception de run et va sortir");
                    break;
             }

         } // while
      } //fin run
      
      
      public void keyReleased(KeyEvent event)
                { 
                switch(event.getKeyCode()){
                    case 40:
                        posY1+=5;
                        break;
                    case 38:
                    posY1-=5;
                    break;
                    case 83:
                        posY2+=5;
                        break;
                    case 87:
                        posY2-=5;
                        break;
                }
                }

        @Override
        public void keyTyped(KeyEvent ke) {
        
        }

        @Override
        public void keyPressed(KeyEvent ke) {
      
        }

       
      
   
      
   } //fin class Mouvement

   // le début de tout
   public static void main (String[] args)  {
      new Jeu_Pong();
   }
} //fin class RebondirDansFenetre