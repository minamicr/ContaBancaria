package com.minami.contabancaria.api.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.minami.contabancaria.api.dtos.ContaBancariaDto;
import com.minami.contabancaria.api.dtos.LancamentoDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LancamentoServiceTest {
	@Autowired
	private LancamentoService lancamentoService;
	
	@Before
	public void setUp() throws Exception{

		
	}

	
	@Test
	public void testValidarLancamento() {
		ContaBancariaDto contaBancariaDto = new ContaBancariaDto();
		contaBancariaDto.setNumeroConta("4839");
		contaBancariaDto.setCpf("17608828870");
		contaBancariaDto.setNome("Cris Minami");
		contaBancariaDto.setEmail("minamicr@yahoo.com.br");
		contaBancariaDto.setSaldo(BigDecimal.valueOf(70.5));
		
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setContaBancaria(contaBancariaDto);
		lancamentoDto.setValorLancamento(BigDecimal.valueOf(100));
		
		BigDecimal saldoAtual = lancamentoService.atualizarSaldo(contaBancariaDto, lancamentoDto);
		
		assertEquals(saldoAtual, BigDecimal.valueOf(170.50));
	}
	
	@Test
	public void testValidarLancamentoNegativo() {
		ContaBancariaDto contaBancariaDto = new ContaBancariaDto();
		contaBancariaDto.setNumeroConta("4839");
		contaBancariaDto.setCpf("17608828870");
		contaBancariaDto.setNome("Cris Minami");
		contaBancariaDto.setEmail("minamicr@yahoo.com.br");
		contaBancariaDto.setSaldo(BigDecimal.valueOf(70.5));
		
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setContaBancaria(contaBancariaDto);
		lancamentoDto.setValorLancamento(BigDecimal.valueOf(-100));
		
		BigDecimal saldoAtual = lancamentoService.atualizarSaldo(contaBancariaDto, lancamentoDto);
		
		assertEquals(saldoAtual, BigDecimal.valueOf(-29.50));
	}
}
