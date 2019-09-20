import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calc extends JFrame implements ActionListener{
  static double resultat=0.0,valeur1=0.0,valeur2=0.0;
  DecimalFormat xy=new DecimalFormat("0.00");
  
  JPanel un=new JPanel();
   JPanel deux=new JPanel();
   JPanel trois=new JPanel();
  
  FlowLayout layout1=new FlowLayout();
  
  JLabel val1=new JLabel("Valeur1 ",JLabel.CENTER);
   JLabel val2=new JLabel("Valeur2 ",JLabel.CENTER);
   JLabel res=new JLabel("Resultat ",JLabel.CENTER);
  
  JTextField val1T=new JTextField("",5);
  JTextField val2T=new JTextField("",5);
  JTextField resT=new JTextField("",5);
  
  JButton plus=new JButton("+");
  JButton moins=new JButton("-");
  JButton fois=new JButton("x");
  JButton div=new JButton("÷");
  JButton mod=new JButton("%");
  
  
  
  
  public Calc(){ 
  
  super("Calculatrice Simple");
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  setLayout(new GridLayout(3,1));
  
  
   un.setBackground(new Color(0,150,200));
  deux.setBackground(new Color(200,200,200));
 trois.setBackground(new Color(200,200,200));
  
  
  
  un.setLayout(layout1);
  un.add(val1);
   un.add(val1T);
   un.add(val2);
   un.add(val2T);
  add(un);
  
  
  deux.setLayout(layout1);
  plus.addActionListener(this);
  moins.addActionListener(this);
  fois.addActionListener(this);
  div.addActionListener(this);
  mod.addActionListener(this);
  deux.add(plus);
   deux.add(moins);
    deux.add(fois);
     deux.add(div);
      deux.add(mod);
  add(deux);
  
  
  trois.setLayout(layout1);
  trois.add(res);
  trois.add(resT);
  add(trois);
  
  }
  
  public void actionPerformed(ActionEvent event){
  String op=event.getActionCommand();
  valeur1=Double.valueOf(val1T.getText());
  valeur2=Double.valueOf(val2T.getText());
  switch(op){
    case "+":
opp(valeur1,valeur2,"+");
  break;
    case "-":
  opp(valeur1,valeur2, "-");
  break;
    case "x":
opp(valeur1,valeur2, "x");
  break;
    case "÷":
opp(valeur1,valeur2,"÷");
  break;
    case "%":
 opp(valeur1,valeur2,"%");
  break;
   
  }
  resT.setText(xy.format(resultat));
  
  }
  public static void opp(double x,double y,String z){
    switch(z){
 case "+":
     resultat= x+y;
    break;
 
   case "-":
 resultat= x-y;
   break;
  
 
  case "x":  
resultat= x*y;
  break;
   case "÷": 
 resultat= x/y;
  break;
   case "%":
  resultat=x%y;
    break;
    }
  }
  public static void main(String[]args){
   new Calc(); 
  }
  
  
}