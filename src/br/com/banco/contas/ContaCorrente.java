package br.com.banco.contas;

import br.com.banco.clientes.Cliente;
import br.com.banco.formaspagamento.Boleto;
import br.com.banco.formaspagamento.Cartao;

public class ContaCorrente extends Conta {

    private Boleto boleto;
    private Cartao cartao;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        boleto = new Boleto(this);
        cartao = new Cartao(this);
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public Cartao getCartao() {
        return cartao;
    }

    @Override
    public void extrato() {
        System.out.println("===\t Conta Corrente \t===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Limite do cartao: " + cartao.getLimite());
        System.out.println("Limite utilizado: " + cartao.getLimiteUtilizado());
    }
}
