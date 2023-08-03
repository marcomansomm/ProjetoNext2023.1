package br.edu.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

/*
 * 
 * Classe DAOContaCorrente
    Atributos: cadastro, do tipo CadastroObjeto.
    O identificador único de uma conta corrente e de uma conta poupança é o seu número.
    Métodos:
    boolean incluir(ContaCorrente conta)
    boolean alterar(ContaCorrente conta)
    ContaCorrente buscar(String numero)
    List<ContaCorrente> buscarTodos()
    Implementar os métodos segundo o código do DAOProduto.
 * 
 * 
 * 
 */

public class DAOContaCorrente{
    private CadastroObjetos cadastro = new CadastroObjetos();

    public boolean incluir(ContaCorrente conta){
        ContaCorrente numeroBusca = buscar(conta.getNumero());
        if(numeroBusca != null){
            return false;
        } else {
            cadastro.incluir(conta, conta.getNumero());
            return true;
        }
    }

    public boolean alterar(ContaCorrente conta){
        ContaCorrente numeroBusca = buscar(conta.getNumero());
        if(numeroBusca == null){
            return false;
        } else {
            cadastro.alterar(conta, conta.getNumero());
            return true;
        }
    }

    public ContaCorrente buscar(String numero){
        return (ContaCorrente)cadastro.buscar(ContaCorrente.class, numero);
    }

    public ContaCorrente[] buscarTodos(){
        Serializable[] rets = cadastro.buscarTodos(ContaCorrente.class);
        ContaCorrente[] contas = new ContaCorrente[rets.length];
        for(int i = 0; i<rets.length; i++){
            contas[i] = (ContaCorrente)rets[i];
        }
        return contas;
    }
}
