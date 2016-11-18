/*
 * Clase Controlador Grafo: Contiene los métodos que manejan las funcionalidades principales del grafo.
 */
package controlador;

import modelo.Grafo;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JTextArea;
import modelo.SNode;

public class ControladorGrafo {

    /**
     * @author Estefany Muriel Y Angélica Arroyave
     */

    Grafo g = new Grafo();

    /**
     *  *Método que recibe un string y un objeto del tipo array como parámetros.
     * Llena cada posición del array con cada palabra del string filtrando
     * espacios y signos de puntuación.
     *
     * @param Palabras
     * @param veString
     * @return
     */
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

    /**
     * Método que inicializa el vector de visitados de la clase grafo en 0
     */
    public void llenarVisitados() {
        for (int i = 0; i < g.getTamaño(); i++) {
            g.setVisitados(i, 0);
        }
    }

    /**
     * *Método que retorna falso o verdadero si una palabra puede ser adyacente
     * a otra, si lo son, retorna verdadero de lo contrario, falso.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean conectarAdya(String x, String y) {
        int k = 0;
        int nx = x.length();
        int ny = y.length();
        int a = y.length();
        if (nx == ny || ny == nx + 1 || nx == ny + 1) {
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

    /**
     * Método que asigna el tamaño que tiene el grafo.
     *
     * @param d
     */
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

    /**
     * Método de tipo void que genera un grafo con base al objeto de tipo
     * arraylist que entra como parámetro, edita la matriz de adyacencia de la
     * clase grafo
     *
     * @param d
     */
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

    /**
     * Método de tipo SNode que genera un grafo con base al objeto de tipo
     * arraylist que entra como parámetro, retorna un vector de tipo SNode.
     *
     * @param d
     * @return
     */
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

    /**
     * Método que retorna una matriz de adyacencia en representacion de matriz
     * tradicional que se crea a partir de los datos de un objeto de tipo
     * arraylist.
     *
     * @param d
     * @return
     */
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

    /**
     * *Método que recibe como parámetro un string, un vector de tipo SNode, un
     * arraylist y una matriz de adyacencia representada como una matriz
     * tradicional; crea un archivo .txt y escribe en este los comandos tipo dot
     * para crear el grafo a travez de Graphviz.
     *
     * @param nombre
     * @param x
     * @param d
     * @param madya
     */
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

    /**
     * Método que borra los datos existentes en un archivo.
     *
     * @param nombre
     */
    public void borrarArchivo(String nombre) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
            bw.write("");
            bw.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Dibuja el grafo y realiza la construccion del comando en la linea de
     * comandos: dot -Tpng -o archivo.png archivo.dot
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

    /**
     * Método que realiza la construcción de todas las rutas posibles desde un
     * vértice inicial a un vértice final, las rutas se guardan en un arraylist
     * llamado caminos
     *
     * @param v
     * @param w
     * @param pos
     * @param camino
     */
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

    /**
     * Método que recorre el arrayList caminos, imprime cada ruta que tiene en
     * sus n posiciones y las escribe en un jTextArea
     *
     * @param recorridos
     */
    public void procesarRutas(JTextArea recorridos) {
        recorridos.setText("");
        for (int i = 0; i < g.getCaminos().size(); i++) {
            String[] k = g.getCaminos().get(i);
            for (int j = 0; j < k.length; j++) {
                if (j == 0) {
                    recorridos.setText(recorridos.getText() + k[j]);
                } else {
                    recorridos.setText(recorridos.getText() + "→" + k[j]);
                }
            }
            recorridos.setText(recorridos.getText() + "\n");
        }
    }

    /**
     * Método que imprime el contenido del vector camino y lo imprime en un
     * jTextArea
     *
     * @param k
     * @param caminos
     */
    public void imprimirCamino(String[] k, JTextArea caminos) {
        caminos.setText(null);
        for (int j = 0; j < k.length; j++) {
            if (j == 0) {
                caminos.setText(caminos.getText() + k[j]);
            } else {
                caminos.setText(caminos.getText() + "→" + k[j]);
            }

        }

    }

    /**
     * Método que procesa los caminos más cortos para ir de un vértice a otro
     *
     * @param caminos
     */
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
        imprimirCamino(g.getCaminos().get(indicador), caminos);
        caminos.setText(caminos.getText() + "\n");
        for (int i = indicador + 1; i < g.getCaminos().size(); i++) {
            k = g.getCaminos().get(i);
            if (k.length == menor) {
                imprimirCamino(k, caminos);
                caminos.setText(caminos.getText() + "\n");
            }
        }

    }

}
