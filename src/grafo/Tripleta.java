/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author estudiantelis
 */
public class Tripleta {

    protected int valor;
    protected int fila;
    protected int columna;

    public Tripleta(int fila, int columna, int valor) {
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getValor() {
        return valor;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

}
