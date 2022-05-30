package br.com.banco;

import br.com.banco.clientes.Cliente;
import br.com.banco.formaspagamento.Boleto;
import br.com.banco.formaspagamento.BoletoBancario;
import br.com.banco.formaspagamento.Cartao;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");

        cliente1.getContaCorrente().extrato();
        cliente2.getContaPoupanca().extrato();

        cliente1.getContaCorrente().depositar(400.0);
        cliente1.getContaCorrente().extrato();

        BoletoBancario boletoBancario = Boleto.gerarBoleto(100.0, cliente1.getContaCorrente(),
                cliente2.getContaPoupanca());

        cliente1.getContaCorrente().getBoleto().pagar(boletoBancario);

        cliente1.getContaCorrente().extrato();
        cliente2.getContaPoupanca().extrato();

        cliente2.getContaCorrente().getCartao().pagar(150.0, cliente1.getContaCorrente(), Cartao.Modo.CREDITO);
        cliente1.getContaCorrente().extrato();
        cliente2.getContaCorrente().extrato();
    }
}
