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
 */
public class IteradorLista<T> implements Iterator<T> {

    private Celula<T> proximaCelula;

    public IteradorLista(Celula primeira) {
        this.proximaCelula = primeira;
    }

    @Override
    public boolean hasNext() {
        return proximaCelula != null;
    }

    @Override
    public T next() {
        
        T celula = proximaCelula.getElemento();
        proximaCelula = proximaCelula.getProximo();
        return celula;
    }
    
    public boolean hasPrevious(){
        return proximaCelula!= null;
    }
    
    public T previous(){
        
        T celula = proximaCelula.getElemento();
        proximaCelula = proximaCelula.getAnterior();
        return celula;
        
    }

}
