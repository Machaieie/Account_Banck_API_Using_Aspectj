package com.contabancaria.Conta_Banciaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contabancaria.Conta_Banciaria.model.ContaInvestimento;

@Repository
public interface ContaInvestimentoRepository extends JpaRepository<ContaInvestimento,Long> {

    Optional<ContaInvestimento> findByNumeroConta ();
    
  
}
