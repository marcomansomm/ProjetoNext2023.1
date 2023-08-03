package br.edu.cesarschool.next.oo.apresentacao;

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
        String numero = ENTRADA.nextLine();
        System.out.println("Insira o Saldo da Conta: ");
        double saldo = ENTRADA.nextDouble();
        System.out.println("Insira o Nome do Dono da Conta: ");
        String nome = ENTRADA.nextLine();

        System.out.println("Insira o tipo da conta: 1- Conta Corrente\n 2- Conta Poupança");
        int tipo = ENTRADA.nextInt();


        if(tipo == 1){
            ContaCorrente conta = new ContaCorrente(numero, saldo, nome);
        } else {
            System.out.println("Insira o seu Percentual De Bonus");
            double percentualBonus = ENTRADA.nextDouble();
            ContaPoupanca conta = new ContaPoupanca(numero, saldo, nome, percentualBonus);
        }
    }
}
