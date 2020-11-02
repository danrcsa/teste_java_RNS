package com.rns.testes.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rns.testes.java.model.FilialProduto;
import com.rns.testes.java.model.FilialProdutoId;

public interface FilialProdutoRepository extends JpaRepository<FilialProduto,FilialProdutoId> {

	List<FilialProduto> findAllByQuantidade(Long x);
	List<FilialProduto> findAllByIdIdFilial(Long x);
	FilialProduto findByIdIdFilialAndIdIdProduto(Long x, Long y);
	
}
