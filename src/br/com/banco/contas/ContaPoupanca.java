package br.com.banco.contas;

import br.com.banco.clientes.Cliente;
import br.com.banco.formaspagamento.Boleto;

public class ContaPoupanca extends Conta {

    private Boleto boleto;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        boleto = new Boleto(this);
    }

    public Boleto getBoleto() {
        return boleto;
    }

    @Override
    public void extrato() {
        System.out.println("===\t Conta Poupanca \t===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: " + getSaldo());
    }
}
