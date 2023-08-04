package br.edu.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.entidade.Produto;
import br.edu.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

/*
 * Criar tal classe, que terá uma implementação genérica para as operações básicas de um
    cadastro, baseando-se no tipo RegistroIdentificavel. Usar a mesma lógica de DAOProduto.

    Construtor que recebe como parâmetro tipoEntidade, do tipo Class. Inicializar no construtor
    o atributo cadastro com um new CadastroObjetos(...), e passar para o construtor de
    CadastroObjeto o tipoEntidade recebido.

    boolean incluir(RegistroIdentificavel reg)
    Implementar seguindo o modelo do DAOProduto. A chave de reg é o retorno do método
    obterChave().
 */
public class DAOGenerico {

    private Class tipoEntidade;
    private CadastroObjetos cadastro;

    //                   ContaCorrente.class
    //                   Produto.class
    public DAOGenerico(Class tipoEntidade){
        this.tipoEntidade = tipoEntidade;
        cadastro = new CadastroObjetos(tipoEntidade);
    }
    
    public boolean incluir(RegistroIdentificavel reg){
        RegistroIdentificavel regBusca = buscar(reg.obterChave());
        if(regBusca != null){
            return false;
        } else {
            cadastro.incluir(reg, reg.obterChave());
            return true;
        }
    }

    /*
     * boolean alterar(RegistroIdentificavel reg)
Implementar seguindo o modelo do DAOProduto. A chave de reg é o retorno do método
obterChave().
     */

    public boolean alterar(RegistroIdentificavel reg){
        RegistroIdentificavel regBusca = buscar(reg.obterChave());
        if(regBusca == null){
            return false;
        } else {
            cadastro.alterar(reg, reg.obterChave());
            return true;
        }
    }

    /*
     * RegistroIdentificavel buscar(String chave)
Implementar seguindo o modelo do DAOProduto.
     */
    public RegistroIdentificavel buscar(String chave){
        return (RegistroIdentificavel)cadastro.buscar(chave);
    }

    /*
     * RegistroIdentificavel[] buscarTodos()
Implementar seguindo o modelo do DAOProduto.
     */

    public RegistroIdentificavel[] buscarTodos(){
        Serializable[] rets = cadastro.buscarTodos(tipoEntidade);
		RegistroIdentificavel[] regs = new RegistroIdentificavel[rets.length];
		for(int i=0; i<rets.length; i++) {
			regs[i] = (RegistroIdentificavel)rets[i];
		}
		return regs;
    }
}
