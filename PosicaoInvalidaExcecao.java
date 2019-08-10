/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author gugam
 */
public class PosicaoInvalidaExcecao extends Exception{
   
    public static final long serialversion = 1L;

    public PosicaoInvalidaExcecao() {
        System.out.println("Posição inválida");
    }
    
}
