package com.contabancaria.Conta_Banciaria.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.enums.ContaStatus;
import com.contabancaria.Conta_Banciaria.interfaces.ContaInterface;
import com.contabancaria.Conta_Banciaria.interfaces.OperacoesInterface;
import com.contabancaria.Conta_Banciaria.model.Conta;
import com.contabancaria.Conta_Banciaria.model.ContaInvestimento;
import com.contabancaria.Conta_Banciaria.repository.ContaInvestimentoRepository;
import com.contabancaria.Conta_Banciaria.utils.Utils;

@Service
public class ContaInvestimentoService implements ContaInterface<ContaInvestimento>, OperacoesInterface<ContaInvestimento> {

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
        ContaInvestimento contaExistente = contaInvestimentoRepository.findById(conta.getId())
                .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));
        contaExistente.setTitular(conta.getTitular());
        contaExistente.setSaldo(conta.getSaldo());
        return contaInvestimentoRepository.save(contaExistente);
    }

    @Override
    public void excluirConta(Long id) {
        ContaInvestimento contaExistente = contaInvestimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));
        contaInvestimentoRepository.delete(contaExistente);
    }

    @Override
    public void alterarPin(int novoPin, ContaInvestimento contaInvestimento) {
        ContaInvestimento contaExistente = contaInvestimentoRepository.findById(contaInvestimento.getId())
                .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));

        // Atualiza o PIN da conta
        contaExistente.setPin(novoPin);

        // Salva a conta atualizada no banco de dados
        contaInvestimentoRepository.save(contaExistente);
    }

    @Override
    public void depositar(ContaInvestimento conta, double valor) {
        ContaInvestimento contaExistente = contaInvestimentoRepository.findByNumeroConta(conta.getNumeroConta())
                .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));
                double saldo = contaExistente.getSaldo();
                double novoSaldo = saldo+valor;
                contaExistente.setSaldo(novoSaldo);


    }

    @Override
    public void levantar(ContaInvestimento conta, double valor, int pin) {
        ContaInvestimento contaExistente = contaInvestimentoRepository.findByNumeroConta(conta.getNumeroConta())
        .orElseThrow(() -> new RuntimeException("Conta de investimento não encontrada"));

        if (valor >contaExistente.getSaldo()) {
            System.out.println("Saldo insuficiente");
        }
        if (contaExistente.getPin() !=pin) {
            System.out.println("PIN invalido");
        }
        double novoSaldo  = contaExistente.getSaldo() - valor;
        contaExistente.setSaldo(novoSaldo);
        contaInvestimentoRepository.save(contaExistente);
    }

    @Override
    public void transferir(ContaInvestimento conta, ContaInvestimento contaDestino, double valor, int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }

    @Override
    public double veriricarSaldo(ContaInvestimento conta, int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'veriricarSaldo'");
    }

   

}
