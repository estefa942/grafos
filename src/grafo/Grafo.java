/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Grafo {

    public  ArrayList llenaArray(String Palabras, ArrayList<String> veString) {
        char aux;
        String palabra = "";
        for (int i = 0; i < Palabras.length(); i++) {  //Guarda todas las palabras del .txt en un arrayList   

            aux = Palabras.charAt(i);
            if (!Character.isLetter(aux) || Character.toString(aux).equals("\n") || Character.toString(aux).equals("")) { //Valida que si sean palabras.
                if (!"".equals(palabra)) {
                    veString.add(palabra);
                    palabra = "";
                }
            } else {
                palabra = palabra.concat(Character.toString(aux));
            }

        }
        return veString;
    }

    public  boolean adya(String x, String y) {
        int k = 0;
        int a = y.length();
//        System.out.println(x);
//        System.out.println(y);
        if (x.length() == y.length() || y.length() == x.length() + 1 || x.length() == y.length() + 1) {
//            System.out.println("Tamaño x= "+x.length());
//            System.out.println("Tamaño y= "+y.length());
            if (x.length() < y.length()) {
                a = x.length();
            }
            if (x.length() == y.length()) {
                
                for (int i = 0; i < a; i++) {
                    if (x.charAt(i) != y.charAt(i)) {
                        k++;
                    }
                }
            } else if (y.length() == x.length() + 1 || x.length() == y.length() + 1) {
                k=1;
                for (int i = 0; i < a; i++) {
                    if (x.charAt(i) != y.charAt(i)) {
                        k++;
                    }
                }
            }
        }
        return (k == 1);
    }
    
   public  int tama(ArrayList d){
       int l=0;
       for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < d.size(); j++) {
                if (adya(d.get(i).toString(), d.get(j).toString())) {
                    l++;
                }
            }
        }
       return l;
   }

     public  MatrizEnTripletas grafo(ArrayList d) {
        int l = tama(d);
        Tripleta t = new Tripleta(d.size(), d.size(), 0);
        MatrizEnTripletas m = new MatrizEnTripletas(t,l+1);
//        System.out.println("["+m.V[0].getFila()+"|"+ m.V[0].getColumna()+"|"+ m.V[0].getValor()+"]");

        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < d.size(); j++) {
                if (adya(d.get(i).toString(), d.get(j).toString())) {
                    t = new Tripleta(i, j, 1);
                    m.insertar(t);
//                    System.out.println("["+t.getFila()+"|"+ t.getColumna()+"|"+ t.getValor()+"]");

                }
            }
        }
        return m;
    }

    public  void imprimir1(MatrizEnTripletas m) {
        for (int i = 0; i < m.V.length; i++) {
            System.out.println("[" + m.V[i].getFila() + "|" + m.V[i].getColumna() + "|" + m.V[i].getValor() + "]");
        }
    }

    public  void main(String args[]) {

        ArrayList<String> veString = new ArrayList();
        llenaArray("a,ab,ac,ad,abb,abc,acb,acc,", veString);

        imprimir1(grafo(veString));

    }
}
