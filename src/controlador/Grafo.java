/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.*;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.SNode;

public class Grafo {

    public ArrayList llenaArray(String Palabras, ArrayList<String> veString) {
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

    public boolean conectarAdya(String x, String y) {
        int k = 0;
        int nx = x.length();
        int ny = y.length();
        int a = y.length();
//        System.out.println(x);
//        System.out.println(y);
        if (nx == ny || ny == nx + 1 || nx == ny + 1) {
//            System.out.println("Tamaño x= "+x.length());
//            System.out.println("Tamaño y= "+y.length());
            if (nx < ny) {
                a = x.length();
            }
            if (nx == ny) {

                for (int i = 0; i < a; i++) {
                    if (x.charAt(i) != y.charAt(i)) {
                        k++;
                    }
                }
            } else if (ny == nx + 1 || nx == ny + 1) {
                k = 1;
                for (int i = 0; i < a; i++) {
                    if (x.charAt(i) != y.charAt(i)) {
                        k++;
                    }
                }
            }
        }
        return (k == 1);
    }

    public int tama(ArrayList d) { //Tamaño del grafo
        int l = 0;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < d.size(); j++) {
                if (conectarAdya(d.get(i).toString(), d.get(j).toString())) {
                    l++;
                }
            }
        }
        return l;
    }

    public SNode[] grafo2(ArrayList d) {
        int l = tama(d);
        int n = d.size();//tamaño del Array
        SNode adya[] = new SNode[n];
        SNode p = null;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (conectarAdya(d.get(i).toString(), d.get(j).toString())) {

                    SNode x = new SNode(j);//Porque el arrayList empieza desde 0
                    if (adya[i] == null) {
                        adya[i] = x;
                        p = x;
                    } else {
                        p.setLink(x);
                        p = x;
                    }
                }

            }

        }
        return adya;

    }

    public void imprimir(SNode adya[]) {
        SNode p;

        for (int i = 0; i < adya.length; i++) {
            System.out.println("Vertice:" + i);
            p = adya[i];
            while (p != null) {
                System.out.println(p.getData());
                p = p.getLink();
            }

        }
    }

    public void imprimirP(SNode adya[], ArrayList palabras) {
        SNode p;

        for (int i = 0; i < adya.length; i++) {
            System.out.println("Vertice:" + palabras.get(i).toString());
            p = adya[i];
            while (p != null) {

                System.out.println(palabras.get(p.getData()).toString());
                p = p.getLink();
            }

        }
    }
    
    public void Escribir(String nombre, SNode[] x, ArrayList d) {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;

        SNode p;

        try {
            f = new File(nombre);
            w = new FileWriter(f, true);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);

            wr.println("graph try {");
            for (int i = 0; i < x.length; i++) {
                wr.println(d.get(i)+ ";");
            }
            int i=0;
            while (i < x.length) {
                p = x[i];
                System.out.println("-"+d.get(x[i].getData()));
                while (p != null) {

                    wr.println(d.get(i).toString() + "--" + d.get(p.getData()).toString() + ";");
                    System.out.println("i: "+i);
                    System.out.println("p: "+p.getData());
                    p = p.getLink();

                }
                i++;
            }
            wr.println("}");
            wr.close();
            bw.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void rutasPosibles(int v, int w, int visitado[], SNode adya[]) {//Aun no falta hacer algo primero
        SNode p;
        if (v != w) {
            visitado[v] = 1;
            System.out.println(v);
            p = adya[v];
            while (p != null) {
                if (visitado[p.getData()] == 0) {
                    System.out.println(p.getData());
                    visitado[p.getData()] = 1;
                    rutasPosibles(p.getData(), w, visitado, adya);
                }
            }
        }

    }

    public void main(String args[]) {

    }
}
