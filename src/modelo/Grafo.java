/*
 *Clase Grafo: Clase para la representación de un grafo como lista ligada de adyacencia.
 */
package modelo;

import controlador.ControladorGrafo;
import java.util.ArrayList;
import vista.Principal;
public class Grafo {
    /*
    *@author: Estefany Muriel Cano y Angélica Arroyave Mendoza.
    */
    
  private SNode ListaAdyacencia[];
    private int tamaño;
    private int visitados[];
    private ArrayList<String> palabras = new ArrayList();
    private ArrayList<String[]> caminos = new ArrayList();

   
   

    public SNode[] getListaAdyacencia() {
        return ListaAdyacencia;
    }

    public void setListaAdyacencia(SNode[] ListaAdyacencia) {
        this.ListaAdyacencia = ListaAdyacencia;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int[] getVisitados() {
        return visitados;
    }

    public void setVisitadosTamaño(int n) {
       visitados = new int[n];
    }
    public void setVisitados(int i, int k){// modifica el contenido del vector
        visitados[i]=k;
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }

    public ArrayList<String[]> getCaminos() {
        return caminos;
    }

    public void setCaminos(String[] n) {
        this.caminos.add(n);
    }

   
    
}
