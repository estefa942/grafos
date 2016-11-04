/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class SNode {

    private Object data;
    private SNode link;

    public SNode(Object d) {
        data = d;
        link = null;
    }

    public Object getData() {
        return data;
    }

    public SNode getLink() {
        return link;
    }

    public void setData(Object x) {
        data = x;
    }

    public void setLink(SNode x) {
        link = x;

    }
}
