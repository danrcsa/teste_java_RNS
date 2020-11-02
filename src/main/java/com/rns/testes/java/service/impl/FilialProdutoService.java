package com.rns.testes.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rns.testes.java.dto.FilialProdutoEstoqueDto;
import com.rns.testes.java.model.FilialProduto;
import com.rns.testes.java.model.FilialProdutoId;
import com.rns.testes.java.repository.FilialProdutoRepository;

@Service
public class FilialProdutoService {

	@Autowired
	FilialProdutoRepository repository;

	public List<FilialProduto> trocarEstoque(FilialProdutoEstoqueDto filialProdutoEstoqueDto) throws Exception {
		
		try {
			FilialProduto filialProdutoOrigem = repository.findById(new FilialProdutoId(filialProdutoEstoqueDto.getIdFilialOrigem(), filialProdutoEstoqueDto.getIdProduto())).get();
			
			FilialProduto filialProdutoDestino = repository.findById(new FilialProdutoId(filialProdutoEstoqueDto.getIdFilialDestino(), filialProdutoEstoqueDto.getIdProduto())).get();
			
			if(filialProdutoOrigem.getQuantidade() >= filialProdutoEstoqueDto.getQuantTroca()) {
				filialProdutoOrigem.setQuantidade(filialProdutoOrigem.getQuantidade() - filialProdutoEstoqueDto.getQuantTroca());
				filialProdutoDestino.setQuantidade(filialProdutoDestino.getQuantidade() + filialProdutoEstoqueDto.getQuantTroca());
				List<FilialProduto> lsFilialProdutos = new ArrayList<>();
				lsFilialProdutos.add(filialProdutoOrigem);
				lsFilialProdutos.add(filialProdutoDestino);
				return repository.saveAll(lsFilialProdutos);
			}else {
				return null;
			}
		}catch (Exception e) {
			throw new Exception("Ocorreu um erro. Tente novamente");
		}
	}

}