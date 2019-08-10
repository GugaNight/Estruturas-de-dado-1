package estruturas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gugam
 */
public class Celula<T> {

    private Celula<T> proximo;
    private Celula<T> anterior;
    private T elemento;

    public Celula(T elemento, Celula<T> anterior, Celula<T> proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public Celula(T elemento, Celula<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Celula(T elemento) {
        this.elemento = elemento;
    }

    public Celula<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula<T> anterior) {
        this.anterior = anterior;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

}
