/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author estudiantelis
 */
public class Grafo {

    private SNode ListaAdyacencia[];
    private int tamaño;
    private int visitados[];

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

    public void setVisitados(int i, int k) {// modifica el contenido del vector
        visitados[i] = k;
    }

}
