package com.contabancaria.Conta_Banciaria.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.enums.ContaStatus;
import com.contabancaria.Conta_Banciaria.interfaces.ContaInterface;
import com.contabancaria.Conta_Banciaria.model.ContaInvestimento;
import com.contabancaria.Conta_Banciaria.repository.ContaInvestimentoRepository;
import com.contabancaria.Conta_Banciaria.utils.Utils;

@Service
public class ContaInvestimentoService implements ContaInterface<ContaInvestimento>{

    @Autowired
    private ContaInvestimentoRepository contaInvestimentoRepository;

    @Autowired
    private Utils utils;

    @Override
    public ContaInvestimento criarConta(ContaInvestimento conta) {
        // Gerar número da conta com 9 dígitos aleatórios
        conta.setNumeroConta(utils.gerarNumeroConta());

        // Gerar PIN com 4 dígitos aleatórios
        conta.setPin(utils.gerarPIN());

        // Definir estado da conta como ATIVA por padrão ao criar
        conta.setEstado(ContaStatus.ATIVA);

        // Salvar a conta no banco de dados
        return contaInvestimentoRepository.save(conta);
    }

    @Override
    public ContaInvestimento procurarConta(Long id) {
        return contaInvestimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));
    }

    @Override
    public ContaInvestimento atualizarConta(ContaInvestimento conta) {
        return contaInvestimentoRepository.save(conta);
    }

    @Override
    public void excluirConta(Long id) {
        contaInvestimentoRepository.deleteById(id);
    }

    @Override
    public void alterarPin(int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarPin'");
    }

    
    
    
   
}
