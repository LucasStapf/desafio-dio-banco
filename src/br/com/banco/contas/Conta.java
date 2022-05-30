package br.com.banco.contas;

import br.com.banco.clientes.Cliente;

public abstract class Conta {

    /**
     * Numero padrao de agencia para todas as contas.
     */
    private static final int AGENCIA_PADRAO = 1;

    /**
     * Contador utilizado para gerar o numero das contas a serem criadas.
     */
    private static int contadorNumero = 1;

    /**
     * Cliente proprietario da conta.
     */
    protected Cliente cliente;

    /**
     * Numero da agencia.
     */
    protected int agencia;

    /**
     * Numero da conta.
     */
    protected int numero;

    /**
     * Saldo da conta.
     */
    protected double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = contadorNumero++;
        this.saldo = 0;
    }

    /**
     * Retorna o numero da agencia.
     * @return o numero da agencia.
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * Retorna o numero da conta.
     * @return o numero da conta.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o saldo da conta.
     * @return o saldo da conta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Saca da conta o valor especificado.
     * @param valor valor a ser sacado.
     * @throws IllegalArgumentException se o valor passado for menor ou igual a zero ou for maior
     * que o saldo da conta.
     */
    public void sacar(double valor) throws IllegalArgumentException {
        if (valor <= 0 || valor > this.saldo) throw new IllegalArgumentException();
        this.saldo -= valor;
    }

    /**
     * Deposita na conta o valor especificado.
     * @param valor valor a ser depositado.
     * @throws IllegalArgumentException se o valor passado for menor ou igual a zero.
     */
    public void depositar(double valor) throws IllegalArgumentException {
        if (valor <= 0) throw new IllegalArgumentException();
        this.saldo += valor;
    }

    /**
     * Transfere para uma conta destino o valor especificado.
     * @param valor valor a ser transferido.
     * @param destino conta que recebera o valor.
     * @throws IllegalArgumentException se o valor passado for menor ou igual a zero ou maior que o saldo da conta.
     * @throws NullPointerException se a conta destino for nula.
     */
    public void transferir(double valor, Conta destino) throws IllegalArgumentException, NullPointerException {
        if (destino == null) throw new NullPointerException();
        this.sacar(valor);
        destino.depositar(valor);
    }

    public abstract void extrato();
}
