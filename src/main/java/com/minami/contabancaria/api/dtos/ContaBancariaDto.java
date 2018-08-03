package com.minami.contabancaria.api.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;



public class ContaBancariaDto {
	private Long id;
	private String numeroConta;
	private String cpf;
	private String nome;
	private String email;
	private BigDecimal saldo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message="O número da conta precisa ser informado")
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	@NotEmpty(message="O cpf precisa ser informado")
	@CPF(message="Não foi informado um cpf válido")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotEmpty(message="O nome do cliente precisa ser informado")
	@Length(min=5, max=100, message="O nome do cliente precisa ter entre 5 e 100 posições")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message="O e-mail precisa ser informado")
	@Email(message="Não foi informado um e-mail válido")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull(message="O saldo precisa ser informado")
	@DecimalMin(value = "0.01", inclusive = true, message="O saldo deve ser superior a 0.00")
	@DecimalMax(value = "999999999.99", inclusive = true, message="O saldo deve ser inferior a 999999999.99")
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "ContaBancariaDto [id=" + id + ", numeroConta=" + numeroConta + ", cpf=" + cpf + ", nome=" + nome
				+ ", email=" + email + ", saldo=" + saldo + "]";
	}
	
	

}
