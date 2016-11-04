/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;

/**
 *
 * @author estudiantelis
 */
public class MatrizEnTripletas {
    
//    protected ArrayList <Tripleta> V[];
      protected Tripleta V[];


    public MatrizEnTripletas( Tripleta t, int p) {
        
        int m=t.getFila();
        int n=t.getColumna();
//        int p = m*n+2;
        System.out.println(p);
        int i;
        Tripleta tp= new Tripleta(0,0,0);
        V= new Tripleta[p];
        V[0] =t;
        for(i=1; i<p; i++){
            V[i]=tp;
        }
    }
    Tripleta retornaTripleta(int i){
        return V[i];
    }
    
    void insertar(Tripleta ti){
        int i,j,datos;
        Tripleta t,tx;
        tx=retornaTripleta(0);
        datos= tx.getValor();
        i=1;
        t=retornaTripleta(i);
        while(i<= datos && t.getFila()< ti.getFila()){
            i=i+1;
            t= retornaTripleta(i);
        }
        while(i<= datos && t.getFila()== ti.getFila() && t.getColumna()< ti.getColumna()){
            i=i+1;
            t=retornaTripleta(i);            
        }
        datos=datos+1;
        j=datos-1;
        while(j>=i){
            V[j+1]=V[j];
            j=j-1;
        }
        V[i]=ti;
        V[0].setValor(datos);
    }
    
}
