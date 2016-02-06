/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author richard
 */
public class Infija {
    String Qexpresion;
    int indice;

    public Infija(String expre) {
        this.indice=0;
        Qexpresion= new String();
        Qexpresion=expre;
    }
    public String retornar(){
        String aux=Qexpresion.substring(indice, indice+1);
        indice++;
        return (aux);
    }
    public void EntrarCaracterFinal(String car){
        Qexpresion=Qexpresion.concat(car);
        
    }
    public int  Caracteres(){
        return (Qexpresion.length());
    }
    
}
