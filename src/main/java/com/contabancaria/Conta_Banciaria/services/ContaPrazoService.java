package com.contabancaria.Conta_Banciaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.enums.ContaStatus;
import com.contabancaria.Conta_Banciaria.interfaces.ContaInterface;
import com.contabancaria.Conta_Banciaria.model.Conta;
import com.contabancaria.Conta_Banciaria.model.ContaPrazo;
import com.contabancaria.Conta_Banciaria.repository.ContaPrazoRepository;
import com.contabancaria.Conta_Banciaria.utils.Utils;

@Service
public class ContaPrazoService implements ContaInterface<ContaPrazo>{

    @Autowired
    private ContaPrazoRepository contaPrazoRepository;

    @Autowired
    private Utils utils;

    @Override
    public ContaPrazo criarConta(ContaPrazo conta) {
        // Gerar número da conta com 9 dígitos aleatórios
        conta.setNumeroConta(utils.gerarNumeroConta());

        // Gerar PIN com 4 dígitos aleatórios
        conta.setPin(utils.gerarPIN());

        // Definir estado da conta como ATIVA por padrão ao criar
        conta.setEstado(ContaStatus.ATIVA);

        // Salvar a conta no banco de dados
        return contaPrazoRepository.save(conta);
    }

    @Override
    public ContaPrazo procurarConta(Long id) {
        return contaPrazoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta a prazo não encontrada"));
    }

    @Override
    public ContaPrazo atualizarConta(ContaPrazo conta) {
        return contaPrazoRepository.save(conta);
    }

    @Override
    public void excluirConta(Long id) {
        contaPrazoRepository.deleteById(id);
    }

    @Override
    public void alterarPin(int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarPin'");
    }

    
    
}
