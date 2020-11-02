package com.rns.testes.java.dto;

import com.rns.testes.java.model.GenericEntity;

import lombok.Data;

@Data
public class ProdutoDto extends GenericEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6766666493263564590L;
	private Long id;
    private String nome;

}
