package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;

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

public class ContaCorrente extends RegistroIdentificavel implements Serializable{
    
    private String numero;
    private double saldo;
    private String nomeCorrentista;
    
    public ContaCorrente() {

    }

    public ContaCorrente(String numero, double saldo, String nomeCorrentista) {
        this.numero = numero;
        this.saldo = saldo;
        this.nomeCorrentista = nomeCorrentista;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public void creditar(double valor){
        this.saldo += valor;
    }
    
    public void debitar(double valor){
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", saldo=" + saldo + ", nomeCorrentista=" + nomeCorrentista;
    }

    @Override
    public String obterChave(){
        return this.numero;
    }

}
