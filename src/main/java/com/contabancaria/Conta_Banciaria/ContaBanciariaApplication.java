package com.contabancaria.Conta_Banciaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ContaBanciariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaBanciariaApplication.class, args);
	}

}
