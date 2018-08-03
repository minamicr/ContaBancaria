package com.minami.contabancaria.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minami.contabancaria.api.dtos.ContaBancariaDto;
import com.minami.contabancaria.api.responses.Response;


@RestController
@RequestMapping("api/contasbancarias")
public class ContaBancariaController {
	
	@GetMapping
	public String ler() {
		return "Ola mundo";
	}
	
	@PostMapping
	public ResponseEntity<Response<ContaBancariaDto>> cadastrar(@Valid @RequestBody ContaBancariaDto contaBancariaDto,
			BindingResult result) {
		
		Response<ContaBancariaDto> response = new Response<ContaBancariaDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		contaBancariaDto.setId(2L);
		response.setData(contaBancariaDto);
		return ResponseEntity.ok(response);
	}

}
