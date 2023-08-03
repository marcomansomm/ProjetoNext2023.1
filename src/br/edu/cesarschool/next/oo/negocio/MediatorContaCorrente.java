package br.edu.cesarschool.next.oo.negocio;

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
        if(dado == null || dado == ""){
            return false;
        } else{
            return true;
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
            }
        }

        /*
         * ContaCorrente conta = new ContaPoupanca();
         * 
         * conta == ContaPoupanca
         * 
         * 
         * 
         * 
         * 
         * 
         */
    }
}
