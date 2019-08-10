package estruturas;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gugam
 */
public class teste {

    public static void main(String[] args) throws PosicaoInvalidaExcecao {

//        ListaEncadeada li = new ListaEncadeada();
        Vetor v = new Vetor(3);
        ListaDuplaEncadeada li2 = new ListaDuplaEncadeada();
        ListaDuplaEncadeada li = new ListaDuplaEncadeada();
        Fila fi = new Fila();
        
        fi.Inserir("1");
        fi.Inserir("2");
        fi.tamanho();
        fi.recuperar();
//        v.adicionaInicio("1");
//        v.adiciona('2', 1);
//        v.Recupera(1);
//               li.Imprime('d');
//        li.adiciona(" 1 ", 0);
//        li.adiciona(" 2 ", 1);
//        li.adicionaInicio(" 0 ");
//        li.adicionaInicio("tururu");
////        li.adicionaFim(" 6 ");
//        li2.adicionaInicio("Fou"); 
//        li2.adicionaInicio("1");
////        li.Imprime('c');
////        li2.Imprime('c');
//        for (int i = 0; i < li.Tamanho(); i++) {
            System.out.println(fi.recuperar());
//        }
//        
//        System.out.println("-----");
//                for (int i = 0; i < li2.Tamanho(); i++) {
//            System.out.println(li2.Recupera(i) + "");
//        }
//        li.ConcatenarListas(li, li2);
////               li.Imprime('d');
////        li.Imprime('c');
//        System.out.println("-----");for (int i = 0; i < li.Tamanho(); i++) {
//            System.out.println(li.Recupera(i) + "");
//        }
//        li.Remove(2);
//        li.RemoveInicio();
//        li.RemoveFim();
//        System.out.println("----");
//        for (int i = 0; i < li.Tamanho(); i++) {
//            System.out.println(li.Recupera(i));
//        }
//        System.out.println("-----");
//        li.Limpa();
        //     System.out.println(li.Tamanho());
    }

}
