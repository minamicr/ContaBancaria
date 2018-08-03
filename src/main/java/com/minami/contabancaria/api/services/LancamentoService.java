package com.minami.contabancaria.api.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.minami.contabancaria.api.dtos.ContaBancariaDto;
import com.minami.contabancaria.api.dtos.LancamentoDto;

@Service
public class LancamentoService {

	public BigDecimal atualizarSaldo(ContaBancariaDto contaBancariaDto, LancamentoDto lancamentoDto) {
		return contaBancariaDto.getSaldo().add(lancamentoDto.getValorLancamento());
		
	}
	
	
}
