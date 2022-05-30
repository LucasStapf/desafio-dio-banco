package br.com.banco.clientes;

import br.com.banco.contas.ContaCorrente;
import br.com.banco.contas.ContaPoupanca;

public class Cliente {

    /**
     * Nome do cliente do banco.
     */
    private String nome;

    /**
     * Conta corrente do cliente.
     */
    private ContaCorrente contaCorrente;

    /**
     * Conta poupanca do cliente.
     */
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome) {
        this.nome = nome;
        this.contaCorrente = new ContaCorrente(this);
        this.contaPoupanca = new ContaPoupanca(this);
    }

    /**
     * Retorna o nome do cliente.
     * @return o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a conta corrente do cliente.
     * @return a conta corrente do cliente.
     */
    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    /**
     * Retorna a conta poupanca do cliente.
     * @return a conta poupanca do cliente.
     */
    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }
}
