package com.contabancaria.Conta_Banciaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contabancaria.Conta_Banciaria.model.ContaPoupanca;

@Repository
public interface ContaPoupancaRepository  extends JpaRepository<ContaPoupanca,Long>{
    Optional<ContaPoupanca> findByNumeroConta (String numeroConta);
}
