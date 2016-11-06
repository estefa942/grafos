/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class SNode {

    private int data;
    private SNode link;

    public SNode(int d) {
        data = d;
        link = null;
    }

    public int getData() {
        return data;
    }

    public SNode getLink() {
        return link;
    }

    public void setData(int x) {
        data = x;
    }

    public void setLink(SNode x) {
        link = x;

    }
}
