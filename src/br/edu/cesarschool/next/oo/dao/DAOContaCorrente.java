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



 * Nova funcionalidade de exclusão (de Produto e de ContaCorrente)
Implementar tal funcionalidade.
• Começar pelo DAOProduto e DAOContaCorrente: que devem ter mais um método
excluir, recebendo, respectivamente, um código e um número, e retornando um
boolean, true se a exclusão for sucesso, e false caso contrário (aí, é indicação de que
o produto ou a conta corrente com tal código ou número não existe. Com o reuso do
DAOGenerico, fica bem fácil implementar estes dois métodos.
• MediatorProduto e MediatorContaCorrente: devem ter mais um método excluir,
recebendo, respectivamente, um código e um número, e retornando uma String.
Usar para este método a lógica do alterar.
• TelaProduto e TelaContaCorrente: incluir mais uma opção no menu, excluir, e seguir
a lógica da opção alterar. Lembrar que, para exclusão, só é necessário digitar o
identificador único (código para produto, ou número para conta corrente).
 * 
 * 
 */

public class DAOContaCorrente{
    private DAOGenerico daoGen = new DAOGenerico(ContaCorrente.class);
    CadastroObjetos cadastro = new CadastroObjetos(ContaCorrente.class);
                                                         

    public boolean incluir(ContaCorrente conta){
        return daoGen.incluir(conta);
        /*
        ContaCorrente numeroBusca = buscar(conta.getNumero());
        if(numeroBusca != null){
            return false;
        } else {
            cadastro.incluir(conta, conta.getNumero());
            return true;
        }
        */
    }

    public boolean alterar(ContaCorrente conta){
        return daoGen.alterar(conta);
        /*
        ContaCorrente numeroBusca = buscar(conta.getNumero());
        if(numeroBusca == null){
            return false;
        } else {
            cadastro.alterar(conta, conta.getNumero());
            return true;
        }
        */
    }

    public boolean excluir(String numero){
        return daoGen.excluir(numero);
    }

    public ContaCorrente buscar(String numero){
        return (ContaCorrente)daoGen.buscar(numero);
        /*
        return (ContaCorrente)cadastro.buscar(numero);
        */
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
