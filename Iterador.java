/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import java.util.Iterator;

/**
 *
 * @author gugam
 * @param <T>
 */
public class Iterador<T> implements Iterator {

    T[] itens;
    int posicao = 0;

    public Iterador(T[] itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        if (posicao < 0 || posicao >= itens.length) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T next() {
        T item = itens[posicao];
        posicao++;
        return item;
    }
    
}
