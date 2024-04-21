package com.contabancaria.Conta_Banciaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.enums.ContaStatus;
import com.contabancaria.Conta_Banciaria.interfaces.ContaInterface;
import com.contabancaria.Conta_Banciaria.model.Conta;
import com.contabancaria.Conta_Banciaria.model.ContaPoupanca;
import com.contabancaria.Conta_Banciaria.repository.ContaPoupancaRepository;
import com.contabancaria.Conta_Banciaria.utils.Utils;

@Service
public class ContaPoupancaService implements ContaInterface<ContaPoupanca> {

    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;

    @Autowired
    private Utils utils;

    @Override
    public ContaPoupanca criarConta(ContaPoupanca conta) {
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
        ContaPoupanca contaExistente = contaPoupancaRepository.findById(conta.getId())
                .orElseThrow(() -> new RuntimeException("Conta poupança não encontrada"));
        contaExistente.setTitular(conta.getTitular());
        contaExistente.setSaldo(conta.getSaldo());
        return contaPoupancaRepository.save(contaExistente);
    }

    @Override
    public void excluirConta(Long id) {
        ContaPoupanca contaExistente = contaPoupancaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta poupança não encontrada"));
        contaPoupancaRepository.delete(contaExistente);
    }

    @Override
    public void alterarPin(int novoPin, ContaPoupanca contaPoupanca) {
        ContaPoupanca contaExistente = contaPoupancaRepository.findById(contaPoupanca.getId())
                .orElseThrow(() -> new RuntimeException("Conta poupança não encontrada"));

        // Atualiza o PIN da conta
        contaExistente.setPin(novoPin);

        // Salva a conta atualizada no banco de dados
        contaPoupancaRepository.save(contaExistente);
    }

}
