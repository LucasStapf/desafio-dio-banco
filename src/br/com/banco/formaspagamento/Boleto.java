package br.com.banco.formaspagamento;

import br.com.banco.contas.Conta;

public class Boleto {

    /**
     * Conta que ira realizar o pagamento via boleto.
     */
    private Conta conta;

    public Boleto(Conta conta) {
        this.conta = conta;
    }

    /**
     * Retorna a conta que ira pagar o boleto.
     * @return a conta que ira pagar o boleto.
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * Realiza o pagamento de um boleto bancario.
     * @param boletoBancario boleto a ser pago.
     * @throws IllegalArgumentException se nao houver saldo suficiente.
     * @throws NullPointerException se o boleto for nulo.
     */
    public void pagar(BoletoBancario boletoBancario) throws IllegalArgumentException, NullPointerException {

        if (boletoBancario == null) throw new NullPointerException();
        if (boletoBancario.getValor() > this.conta.getSaldo()) throw new IllegalArgumentException();

        this.conta.transferir(boletoBancario.getValor(), boletoBancario.getBeneficiario());
    }

    /**
     * Gera um boleto bancario.
     * @param valor valor do boleto.
     * @param pagador conta que ira pagar o boleto.
     * @param beneficiario conta que recebera o valor do boleto.
     * @return um boleto bancario.
     */
    public static BoletoBancario gerarBoleto(double valor, Conta pagador, Conta beneficiario) {
        return new BoletoBancario(valor, pagador, beneficiario);
    }
}
