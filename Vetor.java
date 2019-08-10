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
public class Vetor<T> {

    private T[] vetor;
    int qtd = 0;
    private int tam;

    public Vetor() {
    }

    public Vetor(int tam) {
        vetor = (T[]) new Object[tam];
        this.tam = tam;
    }

    public void adiciona(T elemento, int pos) {
        if (Tamanho() == vetor.length) {
            Redimensional();
        }
        Iterador it = new Iterador(vetor);
        int i = 0;

        while (it.hasNext()) {
            if (it.next() == null) {
                vetor[i] = elemento;
                qtd++;
                break;
            }
            i++;
        }
    }

    public void adicionaInicio(T elemento) throws PosicaoInvalidaExcecao {
        if (vetor[0] == null) {
            vetor[0] = elemento;
            qtd++;

        } else {
            throw new PosicaoInvalidaExcecao();
        }
    }

    public void adicionaFim(T elemento) {
        if (Tamanho() == vetor.length) {
            Redimensional();
        }
        vetor[qtd] = elemento;
        qtd++;
    }

    public boolean existeDado(int pos) throws PosicaoInvalidaExcecao {
        if (vetor[pos] != null) {
            return true;
        }
        throw new PosicaoInvalidaExcecao();
    }

    public T Recupera(int pos) throws PosicaoInvalidaExcecao {
        existeDado(pos);
        if (existeDado(pos) == true) {
            return vetor[pos];
        }
        throw new PosicaoInvalidaExcecao();
    }

    public boolean vazio() {
        if (vetor[qtd] == null) {
            return true;
        }
        return false;
    }

    public void Remove(int pos) throws PosicaoInvalidaExcecao {
        if (vetor[pos] == null) {
            throw new PosicaoInvalidaExcecao();
        } else {
            vetor[pos] = null;
            this.qtd--;
        }
    }

    public void RemoveInicio() {
        vetor[0] = null;
    }

    public void RemoveFim() {
        vetor[qtd] = null;
    }

    public int Tamanho() {
        return qtd;
    }

    public void Limpa() {

        Iterador it = new Iterador(vetor);
        int i = 0;

        while (it.hasNext()) {
            vetor[i] = null;

            i++;
        }
        this.qtd = 0;
        
    }

    public void Redimensional() {
        T[] novoVetor = (T[]) new Object[Tamanho() * 2];
        Iterador it = new Iterador(vetor);
        int i = 0;

        while (it.hasNext()) {
            novoVetor[i] = vetor[i];
            it.next();
        }
        vetor = novoVetor;
        this.vetor = novoVetor;
    }

}
