package com.contabancaria.Conta_Banciaria.services;

import org.springframework.stereotype.Service;

import com.contabancaria.Conta_Banciaria.interfaces.OperacoesInterface;

@Service
public class OperacoesService implements OperacoesInterface{

	@Override
	public void depositar(Long idConta, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levantar(Long idConta, double valor, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(Long idContaOrigem, Long idContaDestino, double valor, int pin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double veriricarSaldo(Long idConta, int pin) {
		// TODO Auto-generated method stub
		return 0;
	}

}
