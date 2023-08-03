package br.edu.cesarschool.next.oo.entidade;

/*
 * Classe ContaPoupanca, que herda de ContaCorrente
Atributos: percentual de bônus (double).
Métodos:
Construtor padrão e construtor com todos os atributos.
Get para todos os atributos.
Set para todos os atributos.
@Override
void creditar(double valor): saldo = saldo + valor *(1 + percentual de bônus / 100)
 */

public class ContaPoupanca extends ContaCorrente{
    private double percentualBonus;

    public ContaPoupanca(){
        super();
    }

    public ContaPoupanca(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }

    public ContaPoupanca(String numero, double saldo, String nomeCorrentista, double percentualBonus) {
        super(numero, saldo, nomeCorrentista);
        this.percentualBonus = percentualBonus;
    }

    public double getPercentualBonus() {
        return percentualBonus;
    }

    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }

    @Override
    public void creditar(double valor){
        super.creditar(this.getSaldo() + valor * (1 + this.percentualBonus / 100));
        //saldo = saldo + valor *(1 + percentual de bônus / 100)
    }

    @Override
    public String toString() {
        return super.toString() + "percentualBonus=" + percentualBonus;
    }

    
}
