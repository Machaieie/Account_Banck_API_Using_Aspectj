package com.contabancaria.Conta_Banciaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ContaInvestimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaInvestimento extends Conta{
    private String tipoInvestimento;
}
