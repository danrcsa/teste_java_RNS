package com.rns.testes.java.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rns.testes.java.model.FilialProduto;
import com.rns.testes.java.model.FilialProdutoId;
import com.rns.testes.java.repository.FilialProdutoRepository;
import com.rns.testes.java.repository.FilialRepository;
import com.rns.testes.java.repository.ProdutoRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProdutoXFilialSeeder {

	@Autowired
	FilialRepository filialRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	FilialProdutoRepository repository;
	
	@EventListener
	public void seedFilialProduto(ContextRefreshedEvent event) {
		try {
			log.info("Criando filiais X produtos....");
			criarFilalProduto();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private void criarFilalProduto() {
		filialRepository.findAll().forEach(filial -> {
			produtoRepository.findAll().forEach(produto ->{
				FilialProduto filialProduto = new FilialProduto();
				FilialProdutoId filialProdutoId = new FilialProdutoId(filial.getId(), produto.getId());
				filialProduto.setId(filialProdutoId);
				filialProduto.setQuantidade(10L);
				repository.save(filialProduto);

			});
		});
	}
		
}
