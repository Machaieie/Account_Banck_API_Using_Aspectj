package com.contabancaria.Conta_Banciaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.enums.ContaStatus;
import com.contabancaria.Conta_Banciaria.interfaces.ContaInterface;
import com.contabancaria.Conta_Banciaria.model.ContaPoupanca;
import com.contabancaria.Conta_Banciaria.repository.ContaPoupancaRepository;
import com.contabancaria.Conta_Banciaria.utils.Utils;

@Service
public class ContaPoupancaService implements ContaInterface<ContaPoupanca>{

    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;

    
    @Override
    public ContaPoupanca criarConta(ContaPoupanca conta) {
        Utils utils = new Utils();
        // Gerar número da conta com 9 dígitos aleatórios
        conta.setNumeroConta(utils.gerarNumeroConta());

        // Gerar PIN com 4 dígitos aleatórios
        conta.setPin(utils.gerarPIN());

        // Definir estado da conta como ATIVA por padrão ao criar
        conta.setEstado(ContaStatus.ATIVA);

        // Salvar a conta no banco de dados
        return contaPoupancaRepository.save(conta);
    }

    @Override
    public ContaPoupanca procurarConta(Long id) {
        return contaPoupancaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta poupança não encontrada"));
    }

    @Override
    public ContaPoupanca atualizarConta(ContaPoupanca conta) {
        return contaPoupancaRepository.save(conta);
    }

    @Override
    public void excluirConta(Long id) {
        contaPoupancaRepository.deleteById(id);
    }

    @Override
    public void alterarPin(int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarPin'");
    }

    
   
    
}
