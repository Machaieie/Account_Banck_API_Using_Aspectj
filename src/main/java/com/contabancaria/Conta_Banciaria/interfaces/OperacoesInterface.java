package com.contabancaria.Conta_Banciaria.interfaces;

public interface OperacoesInterface<T> {
    void depositar(T conta, double valor);
    void levantar(T conta, double valor, int pin);
    void transferir(T conta, T contaDestino, double valor, int pin);
    double veriricarSaldo(T conta, int pin);
}
