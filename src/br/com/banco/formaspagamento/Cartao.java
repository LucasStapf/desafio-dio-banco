package br.com.banco.formaspagamento;

import br.com.banco.contas.Conta;

import java.util.Random;

public class Cartao {

    public static enum Modo {
        DEBITO,
        CREDITO;
    }

    /**
     * Valor inicial padrao para o limite.
     */
    private final double LIMITE_PADRAO = 300.0;

    /**
     * Numero do cartao.
     */
    private int numero;

    /**
     * Refere-se a qual conta o cartao pertecente.
     */
    private Conta conta;

    /**
     * Define o limite maximo do cartao.
     */
    private double limite;

    /**
     * Quantidade utilizada do limite do cartao.
     */
    private double limiteUtilizado;

    public Cartao(Conta conta) {
        Random random = new Random();
        this.numero = random.nextInt(); // apenas para exemplificar
        this.conta = conta;
        this.limite = LIMITE_PADRAO;
        limiteUtilizado = 0.0;
    }

    /**
     * Retorna o numero do cartao.
     * @return o numero do cartao.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna a conta dona do cartao.
     * @return a conta dona do cartao.
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * Retorna o limite do cartao.
     * @return o limite do cartao.
     */
    public double getLimite() {
        return limite;
    }

    /**
     * Retorna o limite utilizado do cartao.
     * @return o limite utilizado do cartao.
     */
    public double getLimiteUtilizado() {
        return limiteUtilizado;
    }

    /**
     * Realiza um pagamento para uma conta destinada escolhendo-se o modo de pagamento (debido ou credito).
     * @param valor valor a ser pago.
     * @param destino conta destino.
     * @param modo debito ou credito.
     * @throws IllegalArgumentException se o valor passado for invalido.
     * @throws NullPointerException se a conta destino for nula.
     */
    public void pagar(double valor, Conta destino, Modo modo) throws IllegalArgumentException, NullPointerException {

        if (valor <= 0) throw new IllegalArgumentException();
        if (destino == null) throw new NullPointerException();

        if (modo == Modo.DEBITO) {

            if (valor > this.conta.getSaldo()) throw new IllegalArgumentException();
            this.conta.sacar(valor);
            destino.depositar(valor);

        } else {

            if (valor > (limite - limiteUtilizado)) throw new IllegalArgumentException();
            limiteUtilizado += valor;
            destino.depositar(valor);
        }
    }
}
