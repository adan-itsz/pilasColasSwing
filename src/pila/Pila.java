/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Pila extends JFrame{
JButton bEncolar,bDesencolar,bMostrar,bMostrarCola;
JButton bPush,bPop;
JTextField txtMostrarCola;
JTextField txtMostrarPila;
JComboBox seleccion;
JPanel card;
implementacionPila pila= new implementacionPila(5);
cola queue = new cola (5);
 int index;

String[] opciones= {" ","Pilas", "Colas"};

public Pila(){
    
super("pilas y colas");
setLayout(new BorderLayout());

seleccion=new JComboBox(opciones);
add(seleccion,BorderLayout.NORTH);
JPanel panelCards= panelCard();
add(panelCards,BorderLayout.CENTER);
this.seleccion.addActionListener(new escuchaComboBox());

//agregar paneles depende
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(400,150);
setVisible(true);

}
public JPanel panelCard(){

JPanel panelPila= panelPila();
JPanel panelCola= panelCola();
 card= new JPanel(new CardLayout());
card.add(panelPila,"pila");
card.add(panelCola,"cola");
return card;
}
 class escuchaComboBox implements ActionListener{
 public void actionPerformed(ActionEvent e){
 int index;
 index= seleccion.getSelectedIndex();
 if(index==1){
 CardLayout cl=(CardLayout)(card.getLayout());
 cl.show(card, "pila");
 }
 else if(index==2){
 CardLayout cl=(CardLayout)(card.getLayout());
 cl.show(card, "cola");
 }
 
 }
     
 }



public JPanel panelPila(){
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
bPush = new JButton("  Push  ");
panel.add(bPush);
bPop= new JButton("  Pop  ");
panel.add(bPop);
bMostrar=new JButton("Mostrar Pila");
panel.add(bMostrar);
txtMostrarPila= new JTextField(10);
panel.add(txtMostrarPila);
bPush.addActionListener(new escuchaBtnPush());
bPop.addActionListener(new escuchaBtnPop());
bMostrar.addActionListener(new escuchaBtnMostrarPila());
return panel;
}
public JPanel panelCola(){
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
bEncolar= new JButton("Encolar");
panel.add(bEncolar);
bDesencolar= new JButton("Desencolar");
panel.add(bDesencolar);
bMostrarCola= new JButton("Mostrar cola");
panel.add(bMostrarCola);
txtMostrarCola= new JTextField(10);
panel.add(txtMostrarCola);
bEncolar.addActionListener(new escuchaBtnEncolar());
bMostrarCola.addActionListener(new escuchaBtnMostrarCola());
bDesencolar.addActionListener(new escuchaBtnDesencolar());

return panel;
}
// Listeners de los elementos en cada panel
//
//
class escuchaBtnPush implements ActionListener{
public void actionPerformed(ActionEvent e){
int elemento;
String txt=txtMostrarPila.getText();
try{
elemento= Integer.parseInt(txtMostrarPila.getText());
//falta agregar txtFiel de maximo de pila
pila.push(elemento);
}
catch(NumberFormatException ex){
JOptionPane.showMessageDialog(null,"error");
}
txtMostrarPila.setText(null);

}

}
class escuchaBtnPop implements ActionListener{

    public void actionPerformed(ActionEvent e){
    int elementoPop=pila.pop();

    JOptionPane.showMessageDialog(null,Integer.toString(elementoPop));
   
    }
    
    }
class escuchaBtnMostrarPila implements ActionListener{
public void actionPerformed(ActionEvent e){
    
JOptionPane.showMessageDialog(null,pila);
}
}

class escuchaBtnEncolar implements ActionListener{
public void actionPerformed(ActionEvent e){

   int elementoCola;
try{
elementoCola= Integer.parseInt(txtMostrarCola.getText());
//falta agregar txtFiel de maximo de cola
queue.encolar(elementoCola);
}
catch(NumberFormatException ex){
JOptionPane.showMessageDialog(null,"error");
}
txtMostrarCola.setText(null);
}

}

class escuchaBtnDesencolar implements ActionListener{
public void actionPerformed(ActionEvent e){
int dequeue;
dequeue= queue.desencolar();
JOptionPane.showMessageDialog(null,Integer.toString(dequeue));
}
}
class escuchaBtnMostrarCola implements ActionListener{
public void actionPerformed(ActionEvent e){
JOptionPane.showMessageDialog(null,queue);
}
}



    

    public static void main(String[] args) {
        // TODO code application logic here
        Pila p= new Pila();
        
    }
      
}


