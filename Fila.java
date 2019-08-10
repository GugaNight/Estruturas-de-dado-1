/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author gugam
 * @param <T>
 */
public class Fila<T> {

    private Celula inicio;
    private Celula fim;
    private int Qtd;

    public Fila() {
    }

    public void Inserir(T elemento) {
        Celula nova = new Celula(elemento, fim, null);

        if (this.Qtd == 0) {
            this.fim = inicio = nova;
        } else {
            fim.setProximo(nova);
            this.fim = nova;
        }

        this.Qtd++;
    }

    public boolean existeDado(T elemento) {
        Celula aux = this.inicio;

        IteradorLista it = new IteradorLista(inicio);
        while (it.hasNext() && aux.getElemento() != elemento) {
            aux = aux.getProximo();
            it.next();

        }
        return aux.getElemento().equals(elemento);

    }

    public boolean isEmpty() {
        if (inicio.equals(null)) {
            return true;
        }
        return false;

    }

    public T recuperar() {
        if (existeDado((T) inicio.getElemento()) == true) {
            return (T) inicio.getElemento();
        }
        return null;

    }

    public void Alterar(T elemento) {
        inicio.setElemento(elemento);
    }

    public void remover() {
        if (this.inicio.equals(this.fim)) {
            limpa();
        } else {
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
            this.Qtd--;
        }

    }

    public int tamanho() {
        return Qtd;

    }

    public void limpa() {
        this.inicio = this.fim = null;
        Qtd = 0;
        //
    }
}
