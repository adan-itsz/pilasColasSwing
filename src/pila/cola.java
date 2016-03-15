package pila;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adan
 */

public class cola {
    private int frente;
    private int fin;
    private int max;
    private int[] datos;
    
    public cola(int max){
    this.max=max-1;
    frente=-1;
    fin=-1;
    datos=new int[max];
     
    }
    public boolean estaVacia(){
    return frente==fin;
    }
    public boolean estaLlena(){
    return fin==max ;
    }
    
    public void encolar(int valor){
    if(!estaLlena()){
        fin++;
        datos[fin]=valor;
        JOptionPane.showMessageDialog(null,"agregado a cola");
    
    }
    else{
    JOptionPane.showMessageDialog(null,"cola llena");
    }
    
    }
    public int desencolar(){
    int valor = 0;
    int aux = frente;
    valor=datos[aux+1];
    if(!estaVacia()){
       
    for(int i= 0;i<fin;i++){
        
    datos[i]=datos[i+1];
    }
   
    fin--;
      
     }
    
    else{
         JOptionPane.showMessageDialog(null,"cola vacia");
         valor=0;
    
    }
    
   
    return valor;
    }
    
      public String toString(){
    String p="";
        for (int i = 0; i <=fin ; i++) {
            if(datos[i]!=0){
            p= p+ "\t  " + datos[i]+ "\t";
            }
            
        }
        return p;
    }
}
