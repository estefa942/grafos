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

   
   
    /**
     * Retorna la lista ligada de adyacencia del grafo.
     * @return 
     */
    public SNode[] getListaAdyacencia() {
        return ListaAdyacencia;
    }
    /**
     * Asigna la lista ligada de adyacencia del grafo.
     * @param ListaAdyacencia 
     */
    public void setListaAdyacencia(SNode[] ListaAdyacencia) {
        this.ListaAdyacencia = ListaAdyacencia;
    }
    /**
     * Retorna el tamaño del grafo.
     * @return 
     */
    public int getTamaño() {
        return tamaño;
    }
    /**
     * Asigna el tamaño del grafo.
     * @param tamaño 
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    /**
     * Retorna el vector que posee los vertices visitados del grafo, utilizado en todas las rutas posibles.
     * @return 
     */
    public int[] getVisitados() {
        return visitados;
    }
    /**
     * Asigna el tamaño del vector visitados.
     * @param n 
     */
    public void setVisitadosTamaño(int n) {
       visitados = new int[n];
    }
    /**
     * Asigna al vector visitados la posicón y el valor a editar.
     * @param i
     * @param k 
     */
    public void setVisitados(int i, int k){// modifica el contenido del vector
        visitados[i]=k;
    }
    /**
     * Retorna un Arraylist con las palabras que contiene el diccionario del grafo.
     * @return 
     */
    public ArrayList<String> getPalabras() {
        return palabras;
    }
    /**
     * Asigna las palabras que contiene el diccionario del grafo
     * @param palabras 
     */
    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }
    /**
     * Retorna el Arraylist con todos los caminos posibles para ir de un vértice a otro.
     * @return 
     */
    public ArrayList<String[]> getCaminos() {
        return caminos;
    }
    /**
     * Asigna un nuevo camino, al Arraylist Caminos.
     * @param n 
     */
    public void setCaminos(String[] n) {
        this.caminos.add(n);
    }

   
    
}
