package estruturas;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gugam
 * @param <T>
 */
public class ListaEncadeada<T> {

    private Celula primeira;
    private Celula ultima;
    private int Qtd = 0;

    public ListaEncadeada() {

    }

    public void adiciona(T elemento, int pos) throws PosicaoInvalidaExcecao {
        Celula nova = new Celula(elemento);

        if (Qtd < pos) {
            throw new PosicaoInvalidaExcecao();
        }
        if (Qtd == 0) {
            adicionaInicio(elemento);
        } else {
            if (Qtd == pos) {
                adicionaFim(elemento);
            } else {
                Celula aux = this.primeira;
                Celula anterior = aux;

                IteradorLista it = new IteradorLista(primeira);
                int cont = 0;
                while (it.hasNext() && cont < pos) {
                    anterior = aux;
                    aux = aux.getProximo();
                    it.next();
                    cont++;
                }
//            for (int i = 0; i < pos; i++) {
//                anterior = aux;
//                aux = aux.getProximo();
//            }

                nova.setProximo(aux);
                anterior.setProximo(nova);
                this.Qtd++;
            }
        }
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        if (Qtd == 0) {
            this.ultima = this.primeira;
        }
        this.Qtd++;
    }

    public void adicionaFim(T elemento) {
        Celula nova = new Celula(elemento);
        ultima.setProximo(nova);
        this.ultima = nova;

        if (this.Qtd == 0) {
            this.primeira = this.ultima;
        }
        this.Qtd++;
    }

    public boolean existeDado(T elemento) {
        Celula<T> aux = this.primeira;

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
//        for (int i = 0; i < pos; i++) {
//            aux = aux.getProximo();
//        }
    }

    public void Remove(int pos) {
        Celula<T> aux = this.primeira;
        Celula<T> remover = null;
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
//        for (int i = 0; i < pos; i++) {
//            remover = aux;
//            aux = aux.getProximo();
//        }
            remover.setProximo(aux.getProximo());
            this.Qtd--;
        }
    }

    public void RemoveInicio() {
        this.primeira = this.primeira.getProximo();
        this.Qtd--;
    }

    public void RemoveFim() {
        Celula<T> aux = this.primeira;
        Celula<T> novoUltimo = null;
        IteradorLista it = new IteradorLista(primeira);
        int cont = 0;
        if (this.primeira.equals(this.ultima)) {
            this.primeira = this.ultima = null;
            this.Qtd = 0;
        } else {
            while (it.hasNext() && cont < Tamanho()) {
                novoUltimo = aux;
                aux = aux.getProximo();
                it.next();
                cont++;
            }
//            for (int i = 0; i < Qtd - 1; i++) {
//                novoUltimo = aux;
//                aux = aux.getProximo();
//            }
            this.ultima = novoUltimo;
            this.Qtd--;
        }
    }

    public int Tamanho() {
        return Qtd;
    }

    public void Limpa() {
        this.primeira = this.ultima = null;
        this.Qtd = 0;
    }

    public void Redimensional() {
        //NÃO
    }

}
