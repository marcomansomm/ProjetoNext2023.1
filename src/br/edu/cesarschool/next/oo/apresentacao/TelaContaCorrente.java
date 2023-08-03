package br.edu.cesarschool.next.oo.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;
import br.edu.cesarschool.next.oo.negocio.MediatorContaCorrente;

public class TelaContaCorrente {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private MediatorContaCorrente mediatorContaCorrente = new MediatorContaCorrente();

    public void iniciarTela(){
        int opcao = 0;
        do{

            System.out.println("Escolha uma opção: ");
			System.out.println("1- Incluir Conta");
			System.out.println("2- Creditar");
			System.out.println("3- Debitar");
			System.out.println("4- Buscar");
			System.out.println("5- Relatorio");
            System.out.println("6- Sair");
            opcao = ENTRADA.nextInt();
            switch (opcao) {
                case 1:
                    incluir();
                    break;
            
                case 2:
                    creditar();
                    break;

                case 3:
                    debitar();
                    break;

                case 4:
                    buscar();
                    break;

                case 5:
                    gerarRelatorioGeral();
                    break;

                case 6:
                    System.out.println("Saindo com Sucesso!!");
                    break;
            }
        }while(opcao != 6);
    }

    /*
     * Deve ler os dados de uma conta corrente do teclado, perguntar se a conta corrente a ser
incluída é uma conta poupança, e se for, ler o atributo específico desta classe. Com os dados
lidos, instanciar uma conta corrente ou uma conta poupança, chamar o método incluir do
mediator, e verificar se a mensagem retornada é nula, indicando inclusão realizada com
sucesso. Se for, mostrar a mensagem “sucesso na inclusão”. Se não for, mostrar a mensagem
retornada.
     */
    private void incluir(){
        System.out.println("Insira o Numero da Conta: ");
        String numero = ENTRADA.next();
        System.out.println("Insira o Saldo da Conta: ");
        double saldo = ENTRADA.nextDouble();
        System.out.println("Insira o Nome do Dono da Conta: ");
        String nome = ENTRADA.next();

        System.out.println("Insira o tipo da conta: 1- Conta Corrente\n 2- Conta Poupança");
        int tipo = ENTRADA.nextInt();


        if(tipo == 1){
            ContaCorrente conta = new ContaCorrente(numero, saldo, nome);
            String mensagem = mediatorContaCorrente.incluir(conta);
            if(mensagem == null){
                System.out.println("Sucesso na Inclusão!!");
            } else {
                System.out.println(mensagem);
            }
        } else {
            System.out.println("Insira o seu Percentual De Bonus");
            double percentualBonus = ENTRADA.nextDouble();
            ContaPoupanca contaP = new ContaPoupanca(numero, saldo, nome, percentualBonus);
            String mensagem = mediatorContaCorrente.incluir(contaP);
            if(mensagem == null){
                System.out.println("Sucesso na Inclusão!!");
            } else {
                System.out.println(mensagem);
            }
        }
    }

    /*
     * void creditar()
Deve ler do teclado o número da conta e o valor a ser creditado. Com os dados lidos, chamar
o método creditar do mediator, e verificar se a mensagem retornada é nula, indicando
crédito realizado com sucesso. Se for, mostrar a mensagem “sucesso no creditar”. Se não for,
mostrar a mensagem retornada.
     */

    private void creditar(){

        System.out.println("Qual o numero da conta?: ");
        String numero = ENTRADA.next();
        System.out.println("Qual o valor a ser creditado?: ");
        double valor = ENTRADA.nextDouble();

        String mensagem = mediatorContaCorrente.creditar(valor, numero);

        if(mensagem == null){
            System.out.println("Sucesso ao Creditar!!");
        } else {
            System.out.println(mensagem);
        }
    }

    /*
     * void debitar()
Deve ler do teclado o número da conta e o valor a ser debitado. Com os dados lidos, chamar
o método debitar do mediator, e verificar se a mensagem retornada é nula, indicando débito
realizado com sucesso. Se for, mostrar a mensagem “sucesso no debitar”. Se não for, mostrar
a mensagem retornada.
     */

    private void debitar(){

        System.out.println("Qual o numero da conta?: ");
        String numero = ENTRADA.next();
        System.out.println("Qual o valor a ser Debitado?: ");
        double valor = ENTRADA.nextDouble();

        String mensagem = mediatorContaCorrente.debitar(valor, numero);

        if(mensagem == null){
            System.out.println("Sucesso ao Debitar!!");
        } else {
            System.out.println(mensagem);
        }
    }

    /*
     * ContaCorrente buscar()
Deve ler do teclado o número da conta. Com o dado lido, chamar o método buscar do
mediator, e verificar se a conta retornada é nula. Se for, mostrar a mensagem “conta não
existente”. Se não for, mostrar os dados do objeto recebido através do comando
System.out.println(conta), onde conta é a varável que recebe o retorno do método buscar,
chamado do mediator.
     */

    private void buscar(){
        System.out.println("Qual o numero da conta?: ");
        String numero = ENTRADA.next();

        ContaCorrente conta = mediatorContaCorrente.buscar(numero);

        if(conta == null){
            System.out.println("Conta não Existente!!");
        } else {
            System.out.println(conta);
        }
        
    }


    /*
     * List<ContaCorrente> gerarRelatorioGeral()
Chamar o método gerarRelatorioGeral do mediator, e imprimir em um loop os dados das
contas correntes constantes na lista retornada, através do comando
System.out.println(contas.get(i)), onde contas.get(i) é cada ocorrência da lista.
     */
    private void gerarRelatorioGeral(){
        List<ContaCorrente> listaConta = mediatorContaCorrente.gerarRelatorioGeral();
        for(ContaCorrente conta: listaConta){
            if(conta instanceof ContaPoupanca){
                ContaPoupanca contaP = (ContaPoupanca)conta;
                System.out.println(contaP.toString()); 
            } else {
                System.out.println(conta.toString());
            } 
        }
    }
}
