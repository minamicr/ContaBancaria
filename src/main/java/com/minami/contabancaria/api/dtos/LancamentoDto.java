package com.minami.contabancaria.api.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class LancamentoDto {
	private Long id;
	private ContaBancariaDto contaBancaria;
	private BigDecimal valorLancamento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull(message="A conta bancária precisa ser informada.")
	public ContaBancariaDto getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancariaDto contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
	@NotNull(message="O valor do lançamento precisa ser informado")
	@DecimalMin(value = "0.01", inclusive = true, message="O valor mínimo do lançamento é de 0.01")
	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}
	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}
	
	@Override
	public String toString() {
		return "LancamentoDto [contaBancaria=" + contaBancaria + ", valorLancamento=" + valorLancamento + "]";
	}
	
	
	
}
