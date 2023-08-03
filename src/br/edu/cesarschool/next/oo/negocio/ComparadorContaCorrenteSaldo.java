package br.edu.cesarschool.next.oo.negocio;

import java.util.Comparator;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;

/*
 * Classe ComparadorContaCorrenteSaldo, que implementa a interface Comparator (do JAVA)
    Atributos – sem atributos
    Métodos:
        Construtor padrão.
    int compare(ContaCorrente o1, ContaCorrente o2)
    Deve retornar 1 se o saldo de o1 for maior do que o saldo de o2.
    Deve retornar -1 se o saldo de o1 for menor do que o saldo de o2.
    Deve retornar 0 se o saldo de o1 for igual ao saldo de o2.
 */
public class ComparadorContaCorrenteSaldo implements Comparator<ContaCorrente>{
    
    public ComparadorContaCorrenteSaldo(){

    }

    @Override
    public int compare(ContaCorrente o1, ContaCorrente o2){
        if(o1.getSaldo() < o2.getSaldo()) {
            return 1;
        } else if(o1.getSaldo() > o2.getSaldo()) {
            return -1;
        } else {
            return 0;
        }
    }
}
