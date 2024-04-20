package com.contabancaria.Conta_Banciaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contabancaria.Conta_Banciaria.model.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{

    
   
}
