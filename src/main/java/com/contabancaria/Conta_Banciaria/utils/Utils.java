package com.contabancaria.Conta_Banciaria.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    // Método para gerar um número de conta com 9 dígitos aleatórios
    public String gerarNumeroConta() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10)); // Adiciona dígitos aleatórios de 0 a 9
        }
        return sb.toString();
    }

    // Método para gerar um PIN com 4 dígitos aleatórios
    public int gerarPIN() {
        Random random = new Random();
        return 1000 + random.nextInt(9000); // Gera um número aleatório de 1000 a 9999
    }
    
}
