package com.minami.contabancaria.api.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minami.contabancaria.api.dtos.LancamentoDto;
import com.minami.contabancaria.api.responses.Response;
import com.minami.contabancaria.api.services.LancamentoService;

@RestController
@RequestMapping("api/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	public LancamentoController() {
		
	}
	
	@GetMapping
	public String ler() {
		return "lancamento get OK";
	}
	
	@PostMapping
	public ResponseEntity<Response<LancamentoDto>> realizarLancamento(@Valid @RequestBody LancamentoDto lancamentoDto,
			BindingResult result) {
		
		Response<LancamentoDto> response = new Response<LancamentoDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		lancamentoDto.setId(2L);
		
		BigDecimal novoSaldo = lancamentoService.atualizarSaldo(lancamentoDto.getContaBancaria(), lancamentoDto);
		lancamentoDto.getContaBancaria().setSaldo(novoSaldo);
		response.setData(lancamentoDto);
		
		return ResponseEntity.ok(response);
	}


}
