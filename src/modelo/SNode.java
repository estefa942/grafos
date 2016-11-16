/**
* Clase SNode: Clase nodo simple.
*/

package modelo;

public class SNode {
     /**
 * @author Estefany Muriel y Angélica Arroyave.
 */
    
    private int data;
    private SNode link;
    
    /**
     * Constructor de la clase nodo simple: Asigna al campo dato al objeto tipo int que entra por parámetro.
     */
    public SNode(int d) {
        data = d;
        link = null;
    }
    /**
    * Retorna Dato: Retorna un objeto del tipo int el cual es el dato del nodo.
    */
    public int getData() {
        return data;
    }
    /**
    * Retorna Liga: Retorna un objeto del tipo SNode el cual es el la dirección de memoria del nodo siguiente.
    */
    public SNode getLink() {
        return link;
    }
    /**
    * Asigna Dato: Asigna un objeto del tipo int que entra por parámetro al campo dato del nodo.
    */
    public void setData(int x) {
        data = x;
    }

    /**
    * Asigna liga: Asigna la dirección de memoria  del tipo nodo que entra por parámetro al campo liga del nodo.
    */
    public void setLink(SNode x) {
        link = x;

    }
}

