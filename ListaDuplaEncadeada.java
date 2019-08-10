/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import jdk.internal.org.objectweb.asm.Opcodes;

/**
 *
 * @author gugam
 * @param <T>
 */
public class ListaDuplaEncadeada<T> {

    private Celula primeira;
    private Celula ultima;
    private Celula noCabeca;
    private int Qtd;

    public ListaDuplaEncadeada() {

    }

    public void adiciona(T elemento, int pos) throws PosicaoInvalidaExcecao {
        Celula nova = new Celula(elemento);

        if (Qtd < pos) {
            throw new PosicaoInvalidaExcecao();
        }
        if (Qtd == 0) {
            adicionaInicio(elemento);
        } else {
            if (pos > Qtd / 2) {
                if (pos == Qtd) {
                    adicionaFim(elemento);
                } else {
                    Celula aux = this.ultima;
                    Celula proximo = aux;
                    IteradorLista it = new IteradorLista(ultima);
                    int cont = Qtd;

                    while (it.hasPrevious() && cont != pos) {
                        proximo = aux;
                        aux = aux.getAnterior();
                        it.previous();
                        cont--;
                    }
//                    for (int i = Qtd; i > pos; i--) {
//                        proximo = aux;
//                        aux = aux.getAnterior();
//                    }
                    nova.setProximo(proximo);
                    nova.setAnterior(aux);
                    proximo.setAnterior(nova);
                    aux.setProximo(nova);
                    this.Qtd++;
                }
            } else {
                Celula aux = this.primeira;
                Celula anterior = aux;
                IteradorLista it = new IteradorLista(primeira);
                int cont = 0;
                while (it.hasNext() && cont != pos) {
                    anterior = aux;
                    aux = aux.getProximo();
                    it.next();
                    cont++;
                }
//                for (int i = 0; i < pos; i++) {
//                    anterior = aux;
//                    aux = aux.getProximo();
//                }
                nova.setProximo(aux);
                nova.setAnterior(anterior);
                aux.setAnterior(nova);
                anterior.setProximo(nova);
                this.Qtd++;
            }
        }
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        if (this.Qtd == 0) {
            this.ultima = primeira;
            this.noCabeca = nova;
            this.ultima.setProximo(noCabeca);
            this.noCabeca.setAnterior(ultima);
            noCabeca.setProximo(primeira);
            this.primeira.setAnterior(noCabeca);
        } else {
            nova.getProximo().setAnterior(nova);
        }

        this.Qtd++;
    }

    public void adicionaFim(T elemento) {
        Celula nova = new Celula(elemento, ultima, null);
        ultima.setProximo(nova);
        this.ultima = nova;

        if (this.Qtd == 0) {
            this.primeira = this.ultima;
        }
        this.Qtd++;
    }

    public boolean existeDado(T elemento) {
        Celula aux = this.primeira;

        IteradorLista it = new IteradorLista(primeira);
        while (it.hasNext() && aux.getElemento() != elemento) {
            aux = aux.getProximo();
            it.next();

        }
        return aux.getElemento().equals(elemento);
//        for (int i = 0; i < Qtd; i++) {
//            if (aux.getElemento().equals(elemento)) {
//                return true;
//            } else {
//                aux = aux.getProximo();
//            }
//        }
    }

    public T Recupera(int pos) throws PosicaoInvalidaExcecao {
        Celula<T> aux = this.primeira;
        IteradorLista it = new IteradorLista(primeira);
        int cont = 0;
        while (it.hasNext() && cont < pos) {
            aux = aux.getProximo();
            it.next();
            cont++;
        }
        if (existeDado(aux.getElemento())) {
            return aux.getElemento();
        } else {
            throw new PosicaoInvalidaExcecao();
        }
//        Celula recupera = null;
//        for (int i = 0; i <= pos; i++) {
//            recupera = aux;
//            aux = aux.getProximo();
//        }
    }

    public void Remove(int pos) {
        Celula aux = this.primeira;
        Celula remover = null;
        IteradorLista it = new IteradorLista(primeira);
        int cont = 0;
        if (pos == 0) {
            RemoveInicio();
        }
        if (pos == Tamanho()) {
            RemoveFim();
        } else {
            while (it.hasNext() && cont < pos) {
                remover = aux;
                aux = aux.getProximo();
                it.next();
                cont++;
            }
//        Celula aux = this.primeira;
//        Celula remover = null;
//        for (int i = 0; i < pos; i++) {
//            remover = aux;
//            aux = aux.getProximo();
//        }
            remover.setProximo(aux.getProximo());
            this.Qtd--;
        }
    }

    public void RemoveInicio() {
        if (this.primeira.equals(this.ultima)) {
            Limpa();
        } else {
            this.primeira = this.primeira.getProximo();
            this.primeira.setAnterior(null);
            this.Qtd--;
        }
    }

    public void RemoveFim() {
        if (this.primeira.equals(this.ultima)) {
            Limpa();
        } else {
            this.ultima = this.ultima.getAnterior();
            this.ultima.setProximo(null);
            this.Qtd--;
        }
    }

    public int Tamanho() {
        return Qtd;
    }

    public void Limpa() {
        this.primeira = this.ultima = null;
        Qtd = 0;
    }

    public void Redimensional() {
        //NÃO
    }

    public T RecuperaR(int pos) {

        return null;

    }

    public void ConcatenarListas(ListaDuplaEncadeada um, ListaDuplaEncadeada dois) {
        um.noCabeca.setAnterior(dois.ultima);
        dois.noCabeca = um.noCabeca;
        um.ultima.setProximo(dois.primeira);
        dois.primeira.setAnterior(um.ultima);
        um.ultima = dois.ultima;
        dois.primeira = um.primeira;
        dois.ultima.setProximo(um.noCabeca);
        um.Qtd  = um.Tamanho() + dois.Tamanho();
    }

    public void Imprime(char tipo) {

        if (Character.toUpperCase(tipo) == 'C' || Character.toUpperCase(tipo) == 'D') {
            if (Character.toUpperCase(tipo) == 'C') {
                IteradorLista it = new IteradorLista(primeira);

                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
            if (Character.toUpperCase(tipo) == 'D') {
                IteradorLista it = new IteradorLista(ultima);

                while (it.hasPrevious()) {
                    System.out.println(it.previous());
                }
            }
        } else {
            throw new IllegalArgumentException("Erro, Apenas caracteres C ou D ");

        }
    }

}
