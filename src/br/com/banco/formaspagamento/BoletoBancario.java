package br.com.banco.formaspagamento;

import br.com.banco.contas.Conta;

import java.util.Random;

public class BoletoBancario {

    /**
     * Codigo de barras usado para identificar o boleto.
     */
    private String codigoBarras;

    /**
     * Valor do boleto.
     */
    private double valor;

    /**
     * Conta que ira pagar o boleto.
     */
    private Conta pagador;

    /**
     * Conta que recebera o pagamento do boleto.
     */
    private Conta beneficiario;

    public BoletoBancario(double valor, Conta pagador, Conta beneficiario) {

        Random random = new Random();
        codigoBarras = Integer.toString(random.nextInt());

        this.valor = valor;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
    }

    /**
     * Retorna o codigo de barras do boleto.
     * @return o codigo de barras do boleto.
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Retorna o valor do boleto.
     * @return o valor do boleto.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Retorna o pagador do boleto.
     * @return o pagador do boleto.
     */
    public Conta getPagador() {
        return pagador;
    }

    /**
     * Retorna o beneficiario do boleto.
     * @return o beneficiario do boleto.
     */
    public Conta getBeneficiario() {
        return beneficiario;
    }
}
