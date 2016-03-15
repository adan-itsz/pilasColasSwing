package pila;


import java.awt.Frame;
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
public class implementacionPila {
    private int tope;
    private int[] datos;
    private int max;
    public implementacionPila(int max){
    tope= -1;
    this.max=max -1;
    datos=new int[max-1];
    }
    boolean estaVacia(){
          return tope==(-1);
       }
    boolean estaLlena(){
    return tope==max;
    }
    void push(int valor){
    if(!estaLlena()){
    tope++;
    datos[tope]=valor;
    JOptionPane.showMessageDialog(null,"elemento insertado"); 
    }
    else {
       JOptionPane.showMessageDialog(null,"pila llena");
    }
    
    }
    public  int pop(){
    int valor=0;
    if(!estaVacia()){
    valor=datos[tope];
    tope--;
    }
    else{
    //messagebox
    JOptionPane.showMessageDialog(null,"pila vacia");//el null es la ventana padre(this)
    }
    return valor;
    }
    public String toString(){
        
    String p="";
        for (int i = 0; i <=tope; i++) {
            p= p + "\n" + datos[i];
        }
        return p;
    }
    
    }
    

