package com.rns.testes.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rns.testes.java.model.FilialProduto;
import com.rns.testes.java.model.FilialProdutoId;

public interface IFilialProdutoDao extends JpaRepository<FilialProduto, FilialProdutoId>{

}
