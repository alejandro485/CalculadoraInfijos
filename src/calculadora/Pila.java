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
public class Pila {

    private Nodo raiz;

    public Pila() {
        raiz = null;
    }

    public void insertar(String x) {

        Nodo nuevo = new Nodo(x);
        if (raiz == null) {
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }

    }

    public String Retirar() {
        Nodo temp = raiz;
        if (temp != null) {
            String informacion = temp.info;
            raiz = temp.sig;
            return informacion;

        } else {
            return "0";
        }
    }

    public boolean isEmpty() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }

    }

    public int Cantidad() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            cant++;
            reco = reco.sig;
        }
        return cant;
    }

    public String peek() {
        if (raiz != null) {
            String informacion = raiz.info;
            return informacion;
        } else {
            return "0";
        }
    }
    public String armarPost(){
        String postfix="";
        String post="";
        Nodo tem=raiz;
        while(tem!=null){
           postfix +=tem.info+" ";
            tem=tem.sig;            
        }
        String[] arreglo=postfix.split(" ");
        for (int i=arreglo.length-1;i>=0;i--){
            post = post+"|"+ arreglo[i];
        }
        
       return post;
    }
}
