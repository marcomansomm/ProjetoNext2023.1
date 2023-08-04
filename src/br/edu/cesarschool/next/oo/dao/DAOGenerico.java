package br.edu.cesarschool.next.oo.dao;

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
    CadastroObjetos cadastro = new CadastroObjetos(getClass());

    
}
