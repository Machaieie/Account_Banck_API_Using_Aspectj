package com.contabancaria.Conta_Banciaria.interfaces;

public interface OperacoesInterface {
    void depositar(Long idConta, double valor);
    void levantar(Long idConta, double valor, int pin);
    void transferir(Long idContaOrigem, Long idContaDestino, double valor, int pin);
    double veriricarSaldo(Long idConta, int pin);
}
