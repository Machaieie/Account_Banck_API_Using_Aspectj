package com.contabancaria.Conta_Banciaria.interfaces;


public interface ContaInterface <T>{

    // Método para salvar uma nova conta no banco de dados
    T criarConta(T conta);

    // Método para buscar uma conta pelo ID
    T procurarConta(Long id);

    // Método para atualizar uma conta existente no banco de dados
    T atualizarConta(T conta);

    // Método para excluir uma conta do banco de dados
    void excluirConta(Long id);

     void alterarPin(int pin);
}
