/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Grafo;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JTextArea;
import modelo.SNode;

public class ControladorGrafo {

    Grafo g = new Grafo();

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
        g.setTamaño(veString.size());
        g.setVisitadosTamaño(veString.size());
        g.setPalabras(veString);
        return veString;

    }

    public void llenarVisitados() {
        for (int i = 0; i < g.getTamaño(); i++) {
            g.setVisitados(i, 0);
        }
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

    public void tama(ArrayList d) { //Tamaño del grafo
        int l = 0;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < d.size(); j++) {
                if (conectarAdya(d.get(i).toString(), d.get(j).toString())) {
                    l++;
                }
            }
        }
        g.setTamaño(l);
    }

    public void grafo1(ArrayList d) {

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
        llenarVisitados();
        g.setListaAdyacencia(adya);

    }

    public SNode[] grafo2(ArrayList d) {

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

    public void imprimir() {
        SNode p;

        for (int i = 0; i < g.getTamaño(); i++) {
            System.out.println("Vertice:" + i);
            p = g.getListaAdyacencia()[i];
            while (p != null) {
                System.out.println(p.getData());
                p = p.getLink();
            }

        }
    }

    public void imprimirP(ArrayList palabras) {
        SNode p;

        for (int i = 0; i < g.getTamaño(); i++) {
            System.out.println("Vertice:" + palabras.get(i).toString());
            p = g.getListaAdyacencia()[i];
            while (p != null) {

                System.out.println(palabras.get(p.getData()).toString());
                p = p.getLink();
            }

        }
    }

    public int[][] mAdya(ArrayList d) { //Matriz de adyacencia del grafo
        int[][] l = new int[d.size()][d.size()];
        for (int i = 0; i < d.size(); i++) {
            for (int j = 1; j < d.size(); j++) {
                if (conectarAdya(d.get(i).toString(), d.get(j).toString())) {
                    l[i][j] = 1;
                    l[j][i] = 1;
                }
            }
        }
        return l;
    }

    public void Escribir(String nombre, SNode[] x, ArrayList d, int[][] madya) {
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

            wr.println("digraph try {");

            int i = 0;
            while (i < x.length) {
                p = x[i];
                while (p != null) {
                    if (madya[i][p.getData()] == 1) {
                        madya[p.getData()][i] = 0;

                        wr.println(d.get(i).toString() + "->" + d.get(p.getData()).toString() + " [dir=none color=" + "red" + "];");

                    }
                    p = p.getLink();
                }
                i++;
            }
            wr.println("rankdir=LR;}");
            wr.close();
            bw.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public void borrarArchivo(String nombre) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
            bw.write("");
            bw.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /*
     *Dibuja el grafo y realiza la construccion del comando en la linea de comandos: 
     * dot -Tpng -o archivo.png archivo.dot
     */
    public void dibujarG() {
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("Graphviz2.38\\bin\\dot.exe", "-Tpng", "-o", "src\\vista\\Grafo.jpg", "src\\modelo\\archivo.txt");
            pbuilder.redirectErrorStream(true);
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rutasPosibles(int v, int w, int pos, int camino[]) {
        SNode p;
        camino[pos] = v;
        if (v == w) {
            
            String[] l = new String[pos + 1];
            for (int i = 0; i <= pos; i++) {
                l[i] = g.getPalabras().get(camino[i]);
                
            }
            g.setCaminos(l);
            
        }
        g.setVisitados(v, 1);
        p = g.getListaAdyacencia()[v];
        int n;
        while (p != null) {
            n = p.getData();
            if (g.getVisitados()[n] == 0) {
                rutasPosibles(n, w, pos + 1, camino);
                g.setVisitados(n, 0);
            }
            p = p.getLink();
        }

    }

     public void procesarRutas(JTextArea recorridos) {
       recorridos.setText("");
        for (int i = 0; i < g.getCaminos().size(); i++) {
            String[] k = g.getCaminos().get(i);
            for (int j = 0; j < k.length; j++) {
                if(j==0){
                    recorridos.setText(recorridos.getText()+k[j] );
                }else{
                recorridos.setText(recorridos.getText()+ "→"+k[j] );
                }
            }
            recorridos.setText(recorridos.getText()+"\n");
        }
    }

    public void imprimirCamino(String[]k,JTextArea caminos){
        caminos.setText(null);
         for (int j = 0; j < k.length; j++) {
               if(j==0){
                   caminos.setText(caminos.getText()+k[j] );
                }else{
                caminos.setText(caminos.getText()+ "→"+k[j] );
                }

            }
        
    }
    public void caminoMasCorto(JTextArea caminos) {
        int menor;
        int indicador;
        String[] k = g.getCaminos().get(0);
        menor = k.length;
        indicador = 0;
        for (int i = 0; i < g.getCaminos().size(); i++) {
            k = g.getCaminos().get(i);
            if (k.length < menor) {
                menor = k.length;
                indicador = i;
            }
            
        }
        imprimirCamino(g.getCaminos().get(indicador),caminos);
        caminos.setText(caminos.getText()+"\n");
         for (int i = indicador+1; i < g.getCaminos().size(); i++) {
            k = g.getCaminos().get(i);
            if (k.length == menor) {
                imprimirCamino(k,caminos);
                caminos.setText(caminos.getText()+"\n");
            }
        }
        
    }

    public void main(String args[]) {

    }
}
