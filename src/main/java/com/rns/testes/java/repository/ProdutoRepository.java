package com.rns.testes.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rns.testes.java.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
