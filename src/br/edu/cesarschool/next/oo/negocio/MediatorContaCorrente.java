package br.edu.cesarschool.next.oo.negocio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.edu.cesarschool.next.oo.dao.DAOContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;

/* Métodos:
Construtor padrão.
String incluir(ContaCorrente conta)
Deve validar os dados da conta corrente recebida e, se algum dado estiver inválido, retornar
mensagem pertinente. As seguintes validações devem ser feitas:
• numero: dever ser diferente de nulo e de branco, e ter tamanho mínimo de 5
caracteres e máximo de 8 caracteres.
• saldo: deve ser maior ou igual a zero.
• nomeCorrentista: dever ser diferente de nulo e de branco, e ter tamanho máximo de
60 caracteres.
• Se a conta corrente recebida for uma conta poupança, validar o percentual de bônus
que deve ser maior ou igual a zero.
Se os dados estiverem válidos, incluir a conta corrente no mecanismo de persistência usando
o DAO. O retorno false do incluir do DAO indica que a chave da conta corrente (o seu
número) já existe. Se isto ocorrer, retornar mensagem pertinente.
Caso a inclusão seja realizada com sucesso, retornar null.*/

public class MediatorContaCorrente {
    private DAOContaCorrente daoContaCorrente = new DAOContaCorrente();

    public MediatorContaCorrente(){
        
    }

    public MediatorContaCorrente(DAOContaCorrente daoContaCorrente) {
        this.daoContaCorrente = daoContaCorrente;
    }

    public boolean stringNulaOuVazia(String dado){
        if(dado == null || dado.trim().equals("")){
            return true;
        } else{
            return false;
        }
    }

    public String incluir(ContaCorrente conta){
        if(conta == null){
            return "Conta não Encontrada!!";
        } else if(stringNulaOuVazia(conta.getNumero())){
            return "Numero da Conta nula ou vazia!!";
        } else if(conta.getNumero().length() < 5 || conta.getNumero().length() > 8){
            return "Numero da Conta menor que 5 ou maior que 8!!";
        } else if(conta.getSaldo() < 0){
            return "Saldo Negativado!!";
        } else if(stringNulaOuVazia(conta.getNomeCorrentista())){
            return "Nome Nulo ou Vazio!!";
        } else if(conta.getNomeCorrentista().length() > 60){
            return "Nome Muito Grande!!";
        } else if(conta instanceof ContaPoupanca){
            ContaPoupanca contaP = (ContaPoupanca)conta;
            if(contaP.getPercentualBonus() < 0){
                return "Conta Poupanca Sem percentual de bônus";
            } else {
                boolean retorno = daoContaCorrente.incluir(contaP);
                if(!retorno){
                    return "Conta Já Existente!!";
                }else {
                    return null;
                }   
            }
        } else {
            boolean retorno = daoContaCorrente.incluir(conta);
            if(!retorno){
                return "Conta já existente";
            } else {
                return null;
            }
            
        }
    }

    /*
     * String creditar(double valor, String numero)
Deve validar os dados recebidos. se algum dado estiver inválido, retornar mensagem
pertinente. As seguintes validações devem ser feitas:
• valor tem que ser maior ou igual a zero.
• numero tem que ser diferente de nulo e de branco.
O método deve buscar no DAO a conta corrente por número. Se ela não existir, retornar
mensagem pertinente. Se ela existir, creditar, usando o método da conta corrente, valor na
conta, alterar, no DAO, a conta, e retornar null.
     */

    public String creditar(double valor, String numero){
        if(valor < 0){
            return "Saldo Invalido!!";
        } else if(stringNulaOuVazia(numero)){
            return "Numero Invalido!!";
        } else {
            ContaCorrente contaBusca = daoContaCorrente.buscar(numero);
            if(contaBusca == null){
                return "Conta Não encontrada!!";
            } else {
                contaBusca.creditar(valor);
                daoContaCorrente.alterar(contaBusca);
                return null;
            }
        }
    }

    /*
     * String debitar(double valor, String numero)
Deve validar os dados recebidos. se algum dado estiver inválido, retornar mensagem
pertinente. As seguintes validações devem ser feitas:
• valor tem que ser maior ou igual a zero.
• numero tem que ser diferente de nulo e de branco.
O método deve buscar no DAO a conta corrente por número. Se ela não existir, retornar
mensagem pertinente. Se ela existir, verificar se o saldo atual é menor que valor, se for,
retornar mensagem pertinente. Caso contrário, debitar, usando o método da conta corrente,
valor na conta, alterar, no DAO, a conta, e retornar null.
     */

    public String debitar(double valor, String numero){
        if(valor < 0){
            return "Saldo Invalido!!";
        } else if(stringNulaOuVazia(numero)){
            return "Numero Invalido!!";
        } else {
            ContaCorrente contaBusca = daoContaCorrente.buscar(numero);
            if(contaBusca == null){
                return "Conta Não encontrada!!";
            } else {
                if(contaBusca.getSaldo() < valor){
                    return "Valor Debitado maior que Saldo";
                } else {
                    contaBusca.debitar(valor);
                    daoContaCorrente.alterar(contaBusca);
                    return null;
                }
            }
        }
    }

    /*
     * ContaCorrente buscar(String numero)
Se numero for nulo ou branco, retornar null. Caso contrário, realizar busca por número no
DAO e retornar o retorno desta busca.
     */

    public ContaCorrente buscar(String numero){
        if(stringNulaOuVazia(numero)){
            return null;
        } else {
            return daoContaCorrente.buscar(numero);
        }
    }

    /*
     * List<ContaCorrente> gerarRelatorioGeral()
Implementar tal método seguindo o modelo implementado no exemplo de Produto. A lista
de contas correntes retornada deve estar ordenada por saldo, em ordem crescente. Para
isto, usar o ComparadorContaCorrenteSaldo, já implementado.
     */

    public List<ContaCorrente> gerarRelatorioGeral(){
        ContaCorrente[] contas = daoContaCorrente.buscarTodos();
        List<ContaCorrente> listaContas = Arrays.asList(contas);
		Collections.sort(listaContas, new ComparadorContaCorrenteSaldo());
		return listaContas;
    }
}
