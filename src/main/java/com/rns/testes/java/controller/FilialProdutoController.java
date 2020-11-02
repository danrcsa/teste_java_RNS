package com.rns.testes.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rns.testes.java.dto.FilialProdutoEstoqueDto;
import com.rns.testes.java.model.FilialProduto;
import com.rns.testes.java.model.FilialProdutoId;
import com.rns.testes.java.repository.FilialProdutoRepository;
import com.rns.testes.java.service.impl.FilialProdutoService;

@CrossOrigin
@RestController
@RequestMapping
public class FilialProdutoController {

	private static final String BASE_URL = "filial-produto/";
	
	@Autowired
	FilialProdutoRepository repository;
	
	@Autowired
	FilialProdutoService service;

	@GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<FilialProduto>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(value = BASE_URL + "find-by-quant", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<FilialProduto>> findAllByquant(@RequestParam Long idFilial) {
		return ResponseEntity.ok(repository.findAllByIdIdFilial(idFilial));
	}

	@PostMapping(value = BASE_URL + "buscar-por-loja", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)

	public ResponseEntity<List<FilialProduto>> buscarPorLoja(@RequestBody FilialProdutoId id) {
		List<FilialProdutoId> lsFilial = new ArrayList<>();
		lsFilial.add(id);
		return ResponseEntity.ok(repository.findAllById(lsFilial));
	}
	
	@PostMapping(value = BASE_URL + "trocar-estoque", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)

	public ResponseEntity<List<FilialProduto>> trocarEstoque(@RequestBody FilialProdutoEstoqueDto filialProdutoEstoqueDto) throws Exception {
		
			
		return ResponseEntity.ok(service.trocarEstoque(filialProdutoEstoqueDto));
	}
	
	
}
